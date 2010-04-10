package com.vlapan.gwt.englishlab.client.enums;

public enum AdjForm {
	Adjective("a"), Comparative("c"), Superlative("s");

	private String shortForm;

	AdjForm(String shortForm) {
		this.shortForm = shortForm;
	}

	public String getShortForm() {
		return this.shortForm;
	}
}
