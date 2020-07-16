package com.biz.exam.exec;

public class Ex_05 {

	public static void main(String[] args) {
		
		int intSum = 0;
		// 0 ~ 99 까지 i 값이 변화가 되고 있다.
		for(int i  = 0 ; i <  100; i++) {
			intSum += (i + 1);
		}
		System.out.println("1 부터 100까지 덧셈 결과 : " + intSum);
	}
	
}
