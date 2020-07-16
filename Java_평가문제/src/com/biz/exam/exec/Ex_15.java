package com.biz.exam.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex_15 {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		Random rnd = new Random();
		
		for(int i = 0 ; i < 100 ; i++) {
			// List에 값을 어떻게 추가하는가
			intList.add(rnd.nextInt());
		}
		
		int sum = 0;
		for(int i = 0 ; i < 100; i++) {
			// List에서 값을 어떻게 읽어 오는가
			sum += intList.get(i);
		}
		System.out.println("총합계:" + sum);
	}
}
