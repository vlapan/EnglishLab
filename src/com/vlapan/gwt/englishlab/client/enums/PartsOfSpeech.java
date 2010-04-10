package com.vlapan.gwt.englishlab.client.enums;

public enum PartsOfSpeech {
	Noun("n"), Verb("v"), Adjective("a"), Adverb("av"), Pronoun("pn"), Preposition(
			"pp"), Conjunction("cj"), Interjection("ij");

	private String shortForm;

	PartsOfSpeech(String shortForm) {
		this.shortForm = shortForm;
	}

	public String getShortForm() {
		return this.shortForm;
	}
}
