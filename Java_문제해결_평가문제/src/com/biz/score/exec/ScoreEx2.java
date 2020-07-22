package com.biz.score.exec;

import java.util.Scanner;

import com.biz.score.service.ScoreService;
import com.biz.score.service.ScoreServiceImplV1;

public class ScoreEx2 {

	public static void main(String[] args) {
		
		ScoreService sService = new ScoreServiceImplV1();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("=========================");
			System.out.println("1. 성적입력");
			System.out.println("2. 성적출력(콘솔)");
			System.out.println("3. 성적출력(파일)");
			System.out.println("QUIT. 성적입력");
			System.out.println("-------------------------");
			System.out.print("업무선택 >> ");
			
			String strMenu = scanner.nextLine();
			if(strMenu.equals("QUIT")) {
				break;
			}
			
			int intMenu = 0;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (NumberFormatException e) {
				System.out.println("업무선택은 1 ~ 3 숫자만 입력하세요");
				continue;
			}
			
			if(intMenu == 1) {
				
				while(sService.inputScore());
				sService.calcSum();
				sService.calcAvg();
				
			} else if (intMenu == 2) {
				sService.scoreListConsole();
			} else if (intMenu == 3) {
				sService.scoreListFileSave();
			}
		}
		System.out.println("업무종료");
		
		
		
		
		
		
	}
	
}
