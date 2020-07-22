package com.biz.grade.exec;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PrintWriterEx_01 {

	public static void main(String[] args) {
		
		String fileName = "src/com/biz/grade/exec/data/test1.txt";
		FileWriter fileWriter = null;
		PrintWriter pWriter = null;
		try {
			
			/*
			 * PrintWriter는 보통 단독으로 사용하지 않고
			 * FileWriter로 파일을 open 한후 PrintWriter에 연결하여
			 * 		사용한다.
			 * FileWriter로 파일을 open할때 두번째 매개변수로 true을 주입하면
			 * 		파일을 append mode로 open 한다
			 * 		append mode로 open이 되면 기존에 저장된 내용을 삭제하지 않고
			 * 		계속에서 문자열을 추가하는 상태로 변경된다.
			 */
			fileWriter = new FileWriter(fileName,true);
			pWriter = new PrintWriter(fileWriter);

			Date date = new Date();
			pWriter.println("대한민국만세 : " + date.toString());
			
			// PrintWriter는 값을 저장하면 일단 임시 buffer에 보관이된다.
			// flush() method 를 호출하여 buffer에 담긴 데이터를
			// 파일로 보낸후 close() 해주어야 한다.
			pWriter.flush(); 
			pWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
