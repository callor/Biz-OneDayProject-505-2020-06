package com.biz.score.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.score.config.Position;
import com.biz.score.model.ScoreVO;

public class ScoreServiceImplV1 implements ScoreService {

	// 데이터를 담아서 사용할 부분
	// 혹시 상속받은 클래스에서 사용할수 있기 때문에 protected설정
	protected List<ScoreVO> scoreList;
	
	// 학생들의 성적정보를 저장할 파일
	// 파일에서 성적정보를 읽어서 scoreList에 저장할때
	// 각 학생의 성적정보를 저장할때
	// 이 변수를 사용하는 곳이 성적정보읽기, 성적정보 저장하는 곳
	//	2곳에서 사용하므로 필드변수로 선언하는 것도 무리가 없다
	protected String scoreFile ; 
	
	// 학생들의 성적결과를 저장할 파일
	// 학생들의 성적결과를 저장할때
	// 사용하는 곳이 한 곳, 결과를 저장하는 곳
	// 이럴때는 변수를 사용하는 method내에서 선언, 초기화 하여
	// 사용하는 것도 고려해볼 필요가 있다.
	protected String scoreRepFile; 
	
	public ScoreServiceImplV1() {
		
		scoreList = new ArrayList<ScoreVO>();
		scoreFile = "";
		scoreRepFile = "";
		
		this.loadScore();
		
	}
	
	@Override
	public boolean inputScore() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학번:(END:종료) >> ");
		String strNum = scanner.nextLine();
		
		// 종료를 위해 입력한 END Command를 대소문자를 구별하여
		// 인식하도록 하는 것이 혹시 실수로 어플이 종료되는 것을 막는
		// 사용자 배려이다.
		if(strNum.equals("END")) {
			return false;
		}
		
		int intNum = 0 ;
		try {
			intNum = Integer.valueOf(strNum);
		} catch (NumberFormatException e) {
			// 문자열을 정수로 바꾸려고 시도하는 과정에서 발생한 exception
			System.out.println("값은 숫자로만 입력해야 합니다");
			return true;
		}
		
		if(intNum < 1 || intNum > 99999) {
			System.out.println("학번은 1 ~ 99999까지만 입력하세요");
			return true;
		}
		
		// 00001 형식으로 변환
		strNum = String.format("%05d", intNum);
		
		System.out.print("국어점수:(END:종료) >> ");
		String strKor = scanner.nextLine();
		if(strKor.equals("END")) {
			return false;
		}
		
		int intKor = 0;
		try {
			intKor = Integer.valueOf(strKor);
		} catch (NumberFormatException e) {

			System.out.println("국어점수는 숫자로만 입력하세요");
			System.out.println("입력한 문자열은 : " + strKor);
			return true;
		}

		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setNum(strNum);
		scoreVO.setKor(intKor);

		// 한학생의 성적을 저장하는 부분 실행
		scoreList.add(scoreVO);
		
		// 리스트를 저장하는 부분 실행
		// 여기에서 리스트(전체학생의 성적)를 저장하는 부분을
		// 실행하는 것은 상당히 비효율적이 될수 있다.
		
		return false;
	
	}

	@Override
	public void calcSum() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcAvg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scoreListConsole() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scoreListFileSave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadScore() {
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		// 혹시 list에 담겨있는 성적정보가 있을지 모르기 때문에
		// list의 데이터를 모두 삭제(clear)하고 파일로 부터 load를 실행
		scoreList.clear();
		
		try {
			fileReader = new FileReader(scoreFile);
			buffer = new BufferedReader(fileReader);
			
			// 초기화는 하지말고 선언만 하자
			ScoreVO scoreVO = null; // new ScoreVO();
			String reader = "";
			while(true) {
				reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				
				String[] scores = reader.split(":");
				scoreVO = new ScoreVO();
				scoreVO.setNum(scores[Position.SCORE_NUM]);
				scoreVO.setKor(Integer.valueOf(scores[Position.SCORE_KOR]));
				scoreVO.setEng(Integer.valueOf(scores[Position.SCORE_ENG]));
				scoreVO.setMath(Integer.valueOf(scores[Position.SCORE_MATH]));
				scoreVO.setMusic(Integer.valueOf(scores[Position.SCORE_MUSIC]));
				scoreList.add(scoreVO);
			
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); // 실제코드를 중단 상태
			System.out.println(scoreFile + "을 여는데 문제 발생");
			/*
			 * 실무상에서 exception처리는
			 * exception이 발생하면
			 * 발생된 시간정보를 포함한 exception정보를 파일, DB에 저장
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("데이터를 읽는데 문제가 발생");
		}
		
	}

}
