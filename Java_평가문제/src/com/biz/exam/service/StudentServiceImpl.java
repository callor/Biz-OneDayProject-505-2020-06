package com.biz.exam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.exam.model.BookVO;

public class StudentServiceImpl implements StudentService {

	// private으로 선언된 변수, 객체들은 상속받은 클래스에서 사용이 불가
	// 접근이 안된다
	// private List<BookVO> bookList;
	// private Scanner scan;
	
	// 상속받은 클래스에서 변수, 객체들을 사용하려면
	// 최소 protected로 해준다, 
	// public으로 설정해도 되지만 그것은 바람직한 방법이 아니다.
	protected List<BookVO> bookList;
	protected Scanner scan;

	public StudentServiceImpl() {
		bookList = new ArrayList<BookVO>();
		scan = new Scanner(System.in);
	}

	public void inputStudent() {
	}

	public void studentList() {
	}

}
