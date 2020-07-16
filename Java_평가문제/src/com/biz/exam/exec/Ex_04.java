package com.biz.exam.exec;

import java.util.Random;

public class Ex_04 {

	public static void main(String[] args) {
		Random rnd = new Random();
		
		for(int i = 0 ; i < 10 ; i++) {
			int num = rnd.nextInt(50) + 51; // 51 ~ 100
			num = rnd.nextInt(100) + 1; // 1 ~ 100
			if(num % 2 == 0) {
				System.out.println(num + "는 짝수");
			} else {
				System.out.println(num + "은 짝수가 아님");
			}
		}
	}
	
}
