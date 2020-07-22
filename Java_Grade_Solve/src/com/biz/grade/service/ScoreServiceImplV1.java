package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.config.DBContract;
import com.biz.grade.config.Lines;
import com.biz.grade.domain.ScoreVO;
import com.biz.grade.domain.StudentVO;

public class ScoreServiceImplV1 implements ScoreService {

	private List<StudentVO> studentList;
	private List<ScoreVO> scoreList;
	private Scanner scan;
	private String fileName;
	
	// 과목명을 문자열 배열로 선언하고, 
	// 과목명 문자열 배열 개수만큼 점수를 담을 intScores배열을 선언
	private String[] strSubjects; 
	private Integer[] intScores;
	
	private int[] totalSum;
	private int[] totalAvg;
	
	StudentService stService;

	/*
	 * 기본 생성자에서는
	 * 혹시 사용자사 파일이름, 과목리스트를 전달하지 않으면
	 * 기본값으로 수행할수 있도록 해당 값들을 매개변수로 전달하여
	 * 내부의 생성자를 호출한다.
	 */
	public ScoreServiceImplV1() {
		this("src/com/biz/grade/exec/data/score.txt",
				new String[]{"국어","영어","수학","음악"});
	}
	public ScoreServiceImplV1(String fileName) {
		this(fileName,new String[]{"국어","영어","수학","음악"});
	}
	public ScoreServiceImplV1(String[] strSubjects) {
		this("src/com/biz/grade/exec/data/score.txt",strSubjects);
	}
	/*
	 * 점수를 저장하는 fileName, 과목개수를 고정하여 작성을 했다.
	 * 이러한 변수의 값들을 고정하면
	 * 코드를 다른용도로 사용하기가 매우 불편해 진다.
	 * 그래서 생성자를 만들고 생성자에서 fileName, 과목개수를 매개변수로
	 * 받아서 사용할수 있도록 변경했다.
	 * 
	 * 아래와 같은 코드를 사용해서 Serivce클래스의 사용을 유연하게 만든다
	 * ScoreService scoreSerivce = new ScoreServiceImplV1("score.txt",{"""""""}) 
	 */
	public ScoreServiceImplV1(String fileName, String[] strSubjects) {
		scoreList = new ArrayList<ScoreVO>();
		scan = new Scanner(System.in);
		
		this.fileName = fileName; 
		this.strSubjects = strSubjects;
				
		intScores =  new Integer[ strSubjects.length ];
		totalSum = new int[ strSubjects.length ];
		totalAvg  = new int[strSubjects.length ];
		
		stService = new StudentServiceImplV1();
		stService.loadStudent();
		
		// StudentService로부터 studentList를 추출하여
		// 사용할 준비를 하자
		studentList = stService.getStudentList();
	
	}

	@Override
	public void loadScore() {
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(this.fileName);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}
				String[] scores = reader.split(":");
				ScoreVO scoreVO = new ScoreVO();
				scoreVO.setNum(scores[DBContract.SCORE.SC_NUM]);
				scoreVO.setKor(Integer.valueOf(scores[DBContract.SCORE.SC_KOR]));
				scoreVO.setEng(Integer.valueOf(scores[DBContract.SCORE.SC_ENG]));
				scoreVO.setMath(Integer.valueOf(scores[DBContract.SCORE.SC_MATH]));
				scoreVO.setMusic(Integer.valueOf(scores[DBContract.SCORE.SC_MUSIC]));
				scoreList.add(scoreVO);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("학생정보 파일 열기 오류!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("학생정보 파일 읽기 오류!!!");
		}
	}

	// return type을 int(primitive)가 아닌 
	// Integer(Wrapper Class)로 설정
	
	// sc_score(매개변수)로 전달받은 값을 검사하는 코드
	// END 문자열을 받았으면 -1을 return
	// 숫자로 바꿀수 없는 문자열, 점수범위를 벗어나는 값이면 null 을 return
	// 정상적이문 문자열을 정수로 바꾸어 return
	private Integer scoreCheck(String sc_score) {
		
		// 만약 END를 입력했으면 -1을 return 해라
		if(sc_score.equals("END")) {
			return -1;
		}
		
		/*
		 * int intScore = nul : 오류가 발생하는 코드
		 * 		primitive int 형 변수는 null 값으로 clear, 초기화를 할수 없다.
		 * Integer intScore = null : 정상적인 코드
		 * 		wrapper class Integer 형 변수는 null 값으로 clear, 초기화 할수 있다
		 */
		Integer intScore = null;
		try {
			intScore = Integer.valueOf(sc_score);
		} catch (Exception e) {
			System.out.println("점수는 숫자만 가능");
			System.out.println("입력한 문자열 : " + sc_score);
			return null;
		}
		if(intScore < 0 || intScore > 100) {
			System.out.println("점수는 0 ~ 100까지만 가능");
			System.out.println("다시 입력해 주세요");
			return null;
		}
		return intScore;
	}
	
	@Override
	public boolean inputScore() {

		ScoreVO scoreVO = new ScoreVO();
		
		System.out.print("학번(END:종료) >> ");
		String st_num = scan.nextLine();
		if(st_num.equals("END")) {
			return false;
		}
		
		int intNum = 0;
		try {
			intNum = Integer.valueOf(st_num);
		} catch (Exception e) {
			System.out.println("학번은 숫자만 가능");
			System.out.println("입력한 문자열 : " + st_num);
			return true;
		}
		if(intNum < 1 || intNum > 99999) {
			System.out.println("학번은 1 ~ 999999까지만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		//00001 형식으로 만들기
		st_num = String.format("%05d",intNum);
		
		for(ScoreVO sVO : scoreList) {
			if(sVO.getNum().equals(st_num)) {
				System.out.println(st_num + " 학생의 성적이 이미 등록 되어 있습니다");
				return true;
			}
		}
		
		// 학생정보에서 학번이 등록되어 있는지 확인
		/*
		for(StudentVO stVO : studentList) {
			if(stVO.getNum().equals(st_num)) {
				System.out.println(st_num + " 학생정보가 학적부에 없음");
				System.out.println("성적을 입력할수 없음");
				return true;
			}
		}
		*/
		StudentVO retVO = stService.getStudent(st_num);
		if(retVO == null) {
			System.out.println(st_num +" 학생정보가 학적부에 없음");
			System.out.println("성적을 입력할 수 없음");
			return true;
		}
		scoreVO.setNum(st_num);
		
		for(int i = 0 ; i < strSubjects.length ; i++) {
			
			System.out.printf("%s 점수(END:종료)", strSubjects[i]);
			String sc_score = scan.nextLine();
			
			// intScore -1, null, 숫자 값이 담겨지게 된다.
			Integer intScore = this.scoreCheck(sc_score);
			if(intScore == null) { // 입력값이 오류!!
				
				// 만약 입력한 점수가 오류(문자열, 범위)가 발생했다면
				// for() 반복문의 i값을 -1하여 감소시키고
				// 다시 for()을 시작하도록 한다.
				// 국어점수에서 이러한 일이 발생한다면
				// 계속해서 국어점수를 입력받는 화면이 반복해서 나타날 것이다.
				i--;
				continue;
			} else if(intScore < 0) {
				return false;
			}
			
			// 모든 것이 정상이면 점수배열에 값을 저장하자
			intScores[i] = intScore;
		}
		scoreVO.setKor(intScores[0]);
		scoreVO.setEng(intScores[1]);
		scoreVO.setMath(intScores[2]);
		scoreVO.setMusic(intScores[3]);
		
		scoreList.add(scoreVO);
		this.saveScoreVO(scoreVO); // 1명의 데이터를 추가 저장하기
		return true;
		
	}

	@Override
	public void saveScore() {

	}

	@Override
	public void scoreList() {

		// 과목별 평균과 총점을 계산할 배열을 0으로 clear 하기
		Arrays.fill(totalSum, 0);
		Arrays.fill(totalAvg, 0);
				
		System.out.println(Lines.dLine);
		System.out.println("성적 일람표");
		System.out.println(Lines.dLine);
		System.out.println("학번\t|이름\t|국어\t|영어\t|수학\t|음악\t|총점\t|평균\t|");
		System.out.println(Lines.sLine);
		for (ScoreVO sVO : scoreList) {
			System.out.printf("%s\t|", sVO.getNum());
			
			StudentVO retVO = stService.getStudent(sVO.getNum());
			String st_name = "[없음]";
			if(retVO != null) {
				st_name = retVO.getName();
			}
			System.out.printf("%s\t|", st_name);
			System.out.printf("%d\t|", sVO.getKor());
			System.out.printf("%d\t|", sVO.getEng());
			System.out.printf("%d\t|", sVO.getMath());
			System.out.printf("%d\t|", sVO.getMusic());
			System.out.printf("%d\t|", sVO.getSum());
			System.out.printf("%5.2f\t|\n", sVO.getAvg());
			
			totalSum[0] += sVO.getKor();
			totalSum[1] += sVO.getEng();
			totalSum[2] += sVO.getMath();
			totalSum[3] += sVO.getMusic();
			
		}
		System.out.println(Lines.sLine);
		
		System.out.print("과목총점:\t|");
		int sumAndSum = 0;
		for(int sum : totalSum) {
			System.out.printf("%s\t|",sum);
			sumAndSum += sum;
		}
		System.out.printf("%s\t|\n",sumAndSum);

		System.out.print("과목평균:\t|");
		float avgAndAvg = 0f;
		for(int sum : totalSum) {
			float avg = (float)sum / scoreList.size();
			System.out.printf("%5.2f\t|",avg);
			avgAndAvg += avg;
		}
		System.out.printf("\t|%5.2f\t|\n",avgAndAvg / totalSum.length);
		System.out.println(Lines.dLine);
	}

	@Override
	public void saveScoreVO(ScoreVO scoreVO) {

		FileWriter fileWriter = null;
		PrintWriter pWriter = null;

		try {
			fileWriter = new FileWriter(this.fileName,true);
			pWriter = new PrintWriter(fileWriter);
			
			pWriter.printf("%s:", scoreVO.getNum());
			pWriter.printf("%d:", scoreVO.getKor());
			pWriter.printf("%d:", scoreVO.getEng());
			pWriter.printf("%d:", scoreVO.getMath());
			pWriter.printf("%d\n", scoreVO.getMusic());
			pWriter.flush();
			pWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void calcSum() {
		for(ScoreVO scoreVO : scoreList) {
			int sum = scoreVO.getKor();
			sum += scoreVO.getEng();
			sum += scoreVO.getMath();
			sum += scoreVO.getMusic();
			sum += scoreVO.getKor();
			scoreVO.setSum(sum);
		}
	}

	@Override
	public void calcAvg() {
		for(ScoreVO scoreVO : scoreList) {
			int sum = scoreVO.getSum();
			float avg = (float)sum / 4;
			scoreVO.setAvg(avg);
		}
	}
}
