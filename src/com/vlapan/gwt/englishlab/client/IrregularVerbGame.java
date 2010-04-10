package com.vlapan.gwt.englishlab.client;

import com.google.gwt.user.client.Random;
import com.vlapan.gwt.englishlab.client.data.IrregularVerbJSO;
import com.vlapan.gwt.englishlab.client.data.Settings;
import com.vlapan.gwt.englishlab.client.enums.GameType;
import com.vlapan.gwt.englishlab.client.enums.VerbForm;

public class IrregularVerbGame extends Game implements SimpleTestDataSource {
	public IrregularVerbJSO current = null;
	public VerbForm currentForm = null;
	public String correctAnswer = null;
	public final int lenght = Settings.getIrregularVerbsArray().length();
	public GameType gameType = null;
	public VerbForm verbForm = null;
	int index = 0;


	public IrregularVerbGame() {
		this(GameType.RANDOM);
	}

	public IrregularVerbGame(GameType gameType) {
		this(gameType, null);
	}

	public IrregularVerbGame(GameType gameType, VerbForm verbForm) {
		this.gameType = gameType;
		this.verbForm = verbForm;
		this.currentForm = verbForm;
	}

	public SimpleTestObjectAbstract next() {
		IrregularVerbJSO next = null;
		if (gameType.equals(GameType.RANDOM)) {
			index = Random.nextInt(lenght);
			next = Settings.getIrregularVerbsArray()
					.get(index);
		} else {
			index++;
			if( lenght == index + 1 ){
				return null;
			}
			next = Settings.getIrregularVerbsArray().get(index);
		}
		if (verbForm == null) {
			this.currentForm = VerbForm.values()[Random.nextBoolean() ? 1 : 2];
		}
		this.current = next;
		System.out.println(current.get(currentForm));
		this.correctAnswer = current.get(currentForm);
		return this.current();
	}

	@Override
	public SimpleTestObjectAbstract current() {
		return new SimpleTestObjectAbstract(current.getVerb(), currentForm
				.toString());
	}

	@Override
	public boolean isCorrect(String answer) {
		return answer.equals(correctAnswer);
	}

	@Override
	public String getDescriptionString() {
		return current.getVerb() + " - " + current.getPastSimple() + " - "
				+ current.getPastParticiple();
	}

	@Override
	public String getQuestionString() {
		return current.getVerb();
	}

}
