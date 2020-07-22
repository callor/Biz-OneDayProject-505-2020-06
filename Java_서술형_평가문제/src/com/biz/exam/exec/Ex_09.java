package com.biz.exam.exec;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileReader;

public class Ex_09 {

	public static void main(String[] args) {
		
		String fileName = "data.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {

			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			
			// String reader = ""
			String reader = new String();
			while(true) {
				reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				System.out.println(reader);
			}
			buffer.close();
			fileReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}
