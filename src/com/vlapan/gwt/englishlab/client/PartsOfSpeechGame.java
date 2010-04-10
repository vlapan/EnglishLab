package com.vlapan.gwt.englishlab.client;

import com.google.gwt.user.client.Random;
import com.vlapan.gwt.englishlab.client.data.Settings;
import com.vlapan.gwt.englishlab.client.data.SpeechPartJSO;
import com.vlapan.gwt.englishlab.client.enums.GameType;
import com.vlapan.gwt.englishlab.client.enums.PartsOfSpeech;

public class PartsOfSpeechGame extends Game implements SimpleTestDataSource {
	public SpeechPartJSO current = null;
	public PartsOfSpeech currentPart = null;
	public String correctAnswer = null;
	public final int lenght = Settings.getPartsOfSpeechArray().length();
	public GameType gameType = null;
	public PartsOfSpeech part = null;
	int index = 0;

	public PartsOfSpeechGame() {
		this(GameType.RANDOM);
	}

	public PartsOfSpeechGame(GameType gameType) {
		this(gameType, null);
	}

	public PartsOfSpeechGame(GameType gameType, PartsOfSpeech partOfSpeech) {
		this.gameType = gameType;
		this.part = partOfSpeech;
		this.currentPart = partOfSpeech;
	}

	public SimpleTestObjectAbstract next() {
		SpeechPartJSO next = null;
		if (gameType.equals(GameType.RANDOM)) {
			index = Random.nextInt(lenght);
			next = Settings.getPartsOfSpeechArray().get(index);
		} else {
			index++;
			if (lenght == index + 1) {
				return null;
			}
			next = Settings.getPartsOfSpeechArray().get(index);
		}
		if (part == null) {
			currentPart = PartsOfSpeech.values()[Random.nextInt(2) + 1];
			if (current.get(currentPart) == null) {
				currentPart = PartsOfSpeech.Adjective;
			}
		}
		this.current = next;
		System.out.println(currentPart + " - " + current.get(currentPart));
		this.correctAnswer = current.get(currentPart);
		return this.current();
	}

	@Override
	public SimpleTestObjectAbstract current() {
		return new SimpleTestObjectAbstract(current.getNoun(), currentPart
				.toString());
	}

	@Override
	public boolean isCorrect(String answer) {
		return answer.equals(correctAnswer);
	}

	@Override
	public String getDescriptionString() {
		return current.getNoun() + " - " + current.getVerb() + " - "
				+ current.getAdj();
	}

	@Override
	public String getQuestionString() {
		return current.getNoun();
	}
}