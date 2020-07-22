package com.biz.grade.service;

import com.biz.grade.domain.ScoreVO;

public interface ScoreService {

	public void loadScore();
	public boolean inputScore();
	
	public void saveScoreVO(ScoreVO scoreVO);
	
	public void calcSum();
	public void calcAvg();
	
	public void saveScore();
	public void scoreList();
	
}
