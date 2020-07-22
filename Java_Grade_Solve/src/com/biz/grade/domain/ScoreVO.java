package com.biz.grade.domain;

/*
 * 클래스를 선언(만들기)하고 다른 클래스를 별도로 상속받지 않았을경우
 * 모든 클래스는 Java의 최상위 부모 클래스인 Object를 자동으로 상속받는다
 */
public class ScoreVO  {

	private String num;
	private int kor;
	private int eng;
	private int math;
	private int music;
	
	private int sum;
	private float avg;
	
	/*
	 * 보통 VO(DTO)클래스를 정의할때
	 * Object로 부터 상속받은 toString() method를 재 정의하는데
	 * 필드변수에 담긴 값들을 보여주는 method 코드로 재 작성을 한다.
	 * 이 기능은 이클립스의 source  / generate toString 메뉴를 통해
	 * 만들어 사용할 수 있다. 
	 */
	@Override
	public String toString() {
		return "ScoreVO [num=" + num + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", music=" + music
				+ ", sum=" + sum + ", avg=" + avg + "]";
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getMusic() {
		return music;
	}
	public void setMusic(int music) {
		this.music = music;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	
}
