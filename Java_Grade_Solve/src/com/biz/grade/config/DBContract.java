package com.biz.grade.config;

public class DBContract {

	// 학번, 이름, 학과, 학년, 전화번호
	public static class STUDENT {
		public static final int ST_NUM = 0;
		public static final int ST_NAME = 1;
		public static final int ST_DEPT = 2;
		public static final int ST_GRADE = 3;
		public static final int ST_TEL = 4;
	}

	// 학번, 국어, 영어, 수학, 음악, 총점, 평균
	public static class SCORE {
		public static final int SC_NUM = 0;
		public static final int SC_KOR = 1;
		public static final int SC_ENG = 2;
		public static final int SC_MATH = 3;
		public static final int SC_MUSIC = 4;
		public static final int SC_SUM = 5;
		public static final int SC_AVG = 6;
	}
	
	public static class MENU {
		public static final int 학생정보등록 = 1;
		public static final int 학생리스트출력 = 2;
		public static final int 성적등록 = 3;
		public static final int 성적일람표 = 4;
	}
	
	
}
