package com.biz.exam.exec;

public class Ex_14 {

	public static void main(String[] args) {
		
		int num = 7;
		System.out.println("============================");
		System.out.println("7단 구구단");
		System.out.println("============================");
		for(int i = 1 ; i <10 ; i++) {
			System.out.printf("%d x %d = %d",num,i,num * i);
		}
		System.out.println("============================");
		
		for(int i = 0 ; i <9 ; i++) {
			System.out.printf("%d x %d = %d",num,i+1, num * (i + 1));
		}
		System.out.println("============================");
		
		
//		System.out.println("7 x 1 = 7");
//		System.out.println("7 x 2 = 7");
//		System.out.println("7 x 3 = 7");
//		System.out.println("7 x 4 = 7");
//		System.out.println("7 x 5 = 7");
		
		
	}
}
