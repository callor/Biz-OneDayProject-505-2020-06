package com.biz.score.service;

public interface ScoreService {

	public void loadScore();
	
	// 성적입력
	public boolean inputScore();
	
	// 총점과 평균계산
	public void calcSum();
	public void calcAvg();
	
	// 성적 저장
	// 개별적으로 학생한명 성적입력 후 저장
	// 전체적으로 List 한꺼번에 저장
	public void saveScore();

	// 콘솔 출력
	public void scoreListConsole();
	
	// 파일저장
	public void scoreListFileSave();
	
	
}
