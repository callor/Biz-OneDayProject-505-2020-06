package com.biz.exam.service;

import com.biz.exam.model.BookVO;

public class StudentServiceImplV2 extends StudentServiceImpl {

	@Override
	public void inputStudent() {
		
		BookVO bookVO = new BookVO();
		bookVO.setTitle("자바만세");
		bookVO.setComp("우리출판사");
		
		bookList.add(bookVO);
		
	}

	
	
}
