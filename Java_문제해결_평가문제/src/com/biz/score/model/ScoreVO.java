package com.biz.score.model;

public class ScoreVO {

	/*
	 * VO 변수를 private으로 설정하지 않아도
	 * VO 클래스가 있는 pacakge가 다른곳과 분리되어 있기 때문에
	 * private 처럼 동작을 하지만
	 * 그래도 클래스 작성 패턴상 getter, setter가 있는 
	 * VO의 필드변수는 private으로 설정하자
	 */
	private String num;
	
	private int kor;
	private int eng;
	private int math;
	private int music;
	
	private int sum;
	private float avg;
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
