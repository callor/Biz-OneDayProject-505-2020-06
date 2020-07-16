package com.biz.exam.exec;

import com.biz.exam.model.BookVO;

public class Ex_06 {

	public static void main(String[] args) {
		
		BookVO[] bookVO = new BookVO[10];
		
		// length : 10
		for(int i = 0 ; i < bookVO.length ; i++) {
			bookVO[i] = new BookVO(); 
		}
		
		bookVO[2] = new BookVO(); // 정답
		
		int index = 2;
		bookVO[index] = new BookVO(); // 정답
		
		bookVO[index].setTitle("자바의 정석");
		bookVO[index].setComp("도우출판사");
		
		System.out.println("도서명 : "  + bookVO[index].getTitle());
		System.out.println("출판사 : "  + bookVO[index].getComp());
		
	}
	
}
