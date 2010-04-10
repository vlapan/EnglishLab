package com.vlapan.gwt.englishlab.client.enums;

public enum VerbForm {
	Verb("v"), PastSimple("ps"), PastParticiple("pp");

	private String shortForm;

	VerbForm(String shortForm) {
		this.shortForm = shortForm;
	}

	public String getShortForm() {
		return this.shortForm;
	}
}
