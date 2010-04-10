package com.vlapan.gwt.englishlab.client;

public class SimpleTestObjectAbstract {
	public String desc = "";
	public String question = "";

	public SimpleTestObjectAbstract(String question, String desc) {
		this.question = question;
		this.desc = desc;
	}

	public String getDescriptionString() {
		return desc;
	}

	public String getQuestionString() {
		return question;
	}

}
