package com.vlapan.gwt.englishlab.client;


public interface SimpleTestDataSource {
	public SimpleTestObjectAbstract next();
	public SimpleTestObjectAbstract current();
	public boolean isCorrect(String answer);
	public String getDescriptionString();
	public String getQuestionString();
}
