package com.biz.grade.config;

public class Lines {

	public static String dLine = "";
	public static String sLine = "";
	
	static {
		for(int i = 0 ; i < 100 ; i++) {
			dLine += "=";
			sLine += "-";
		}
	}
	
}
