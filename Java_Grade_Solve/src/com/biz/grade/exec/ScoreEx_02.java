package com.biz.grade.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.biz.grade.domain.ScoreVO;

public class ScoreEx_02 {

	public static void main(String[] args) {
		
		ScoreVO scoreVO = new ScoreVO();
		
		/*
		 * 클래스를 사용하여 만든 객체인스턴스를 
		 * System.out.print*() method에 전달하면
		 * print*() 는 자동으로 
		 * 	객체인스턴스의 .toString() method를 호출하도록
		 * 내부에 코딩이 되어있다.
		 * .toString() method는 클래스의 최상위 부모인 Object 클래스에
		 * 상속받은 method이다
		 * 별도로 .toString() method를 재 정의하지 않으면
		 * Object 클래스에 구현된 코드가 실행된다.
		 */
		System.out.println(scoreVO); // .toString()을 붙이지 않아도
									 // 자동으로 .toString()을 호출한다.
		System.out.println(scoreVO.toString());
		
		// 이미 생성된 scoreVO객체를 다시 생성자를 호출하여
		// 만들기
		scoreVO = new ScoreVO();
		System.out.println(scoreVO.toString());
		/*
		 * Object 클래스에 정의된 toString()은
		 * 생성된 객체 인스턴의 정보(패키지, 클래스, 메모리주소)를
		 * 보여주도록 코드가 만들어져 있다.
		 */
		
		scoreVO = new ScoreVO();
		scoreVO.setNum("0001");
		scoreVO.setKor(90);
		scoreVO.setEng(80);
		scoreVO.setMath(100);
		scoreVO.setMusic(88);
		System.out.println(scoreVO);
		
		List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
		Random rnd = new Random();
		for(int i = 0 ; i < 10; i++) {
			int intKor = rnd.nextInt(51) + 50;
			int intEng= rnd.nextInt(51) + 50;
			int intMath = rnd.nextInt(51) + 50;
			int intMusic = rnd.nextInt(51) + 50;
			
			String num = String.format("%05d", i);
			
			scoreVO = new ScoreVO();
			scoreVO.setNum(num);
			scoreVO.setKor(intKor);
			scoreVO.setEng(intEng);
			scoreVO.setMath(intMath);
			scoreVO.setMusic(intMusic);
			scoreList.add(scoreVO);
		}
		// VO(DTO) 클래스에서 toString() method를 재정의 해 두면
		// VO, List<VO>와 같은 객체에 담긴 데이터를
		// debuging(확인)용도로 코드를 작성할때는 매우 간소하게 만들수 있다.
		System.out.println(scoreList);
		System.out.println(scoreList.toString());
		
	}
}
