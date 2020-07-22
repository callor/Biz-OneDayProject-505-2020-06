package com.biz.exam.exec;

import java.util.Random;

public class Ex_11 {
	
	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		int[] num = new int[100];
		for(int i = 0 ; i < num.length ; i++) {
			num[i] = rnd.nextInt(91) + 10;
		}
		
		// main for
		for(int j = 0 ; j < num.length ; j++) {
			int i = 0;
			
			// sub for
			// 2 부터 num[j] - 1까지 반복을 하면서
			// num[j]에 들어있는 값과 나머지 연산을 수행
			for(i = 2 ; i < num[j] ; i++) {
				// 나머지 연산을 수행하다가 중간 한번이라도
				// 결과 0이 나오면 이수는 소수가 아니다
				// 더이상 반복을 하지말고 i-for문을 중단
				if(num[j] % i == 0) {
					break;
				}
			} // for(i) end
			// sub for가 끝나는 시점에서
			// 만약 sub for가 중간에 if문을 만나서 break로 빠져나왔다면
			// i 값은 num[j] 무조건 작은 상태 i < num[j]
			
			// sub for가 중간에 if, break를 만나지 않고
			// 완전하에 i < num[j]까지 반복한후 종료했다면
			// i 값은 num[j] 보다 크거나 같은 값이 된다.
			if(i >= num[j]) {
				System.out.println(num[j] + "는 소수");
			} else {
				System.out.println(num[j] + "는 소수가 아니다");
			}
		}
	}
}
