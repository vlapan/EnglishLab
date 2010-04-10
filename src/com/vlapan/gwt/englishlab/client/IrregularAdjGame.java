package com.vlapan.gwt.englishlab.client;

import com.google.gwt.user.client.Random;
import com.vlapan.gwt.englishlab.client.data.IrregularAdjJSO;
import com.vlapan.gwt.englishlab.client.data.Settings;
import com.vlapan.gwt.englishlab.client.enums.AdjForm;
import com.vlapan.gwt.englishlab.client.enums.GameType;

public class IrregularAdjGame extends Game implements SimpleTestDataSource {
	public IrregularAdjJSO current = null;
	public AdjForm currentForm = null;
	public String correctAnswer = null;
	public final int lenght = Settings.getIrregularAdjArray().length();
	public GameType gameType = null;
	public AdjForm adjForm = null;
	int index = 0;


	public IrregularAdjGame() {
		this(GameType.RANDOM);
	}

	public IrregularAdjGame(GameType gameType) {
		this(gameType, null);
	}

	public IrregularAdjGame(GameType gameType, AdjForm adjForm) {
		this.gameType = gameType;
		this.adjForm = adjForm;
		this.currentForm = adjForm;
	}

	public SimpleTestObjectAbstract next() {
		IrregularAdjJSO next = null;
		if (gameType.equals(GameType.RANDOM)) {
			index = Random.nextInt(lenght);
			next = Settings.getIrregularAdjArray()
					.get(index);
		} else {
			if( lenght == index ){
				return null;
			}
			next = Settings.getIrregularAdjArray().get(index);
			index++;
		}
		if (adjForm == null) {
			this.currentForm = AdjForm.values()[Random.nextBoolean() ? 1 : 2];
		}
		this.current = next;
		System.out.println(current.get(currentForm));
		this.correctAnswer = current.get(currentForm);
		return this.current();
	}

	@Override
	public SimpleTestObjectAbstract current() {
		return new SimpleTestObjectAbstract(current.getAdj(), currentForm
				.toString());
	}

	@Override
	public boolean isCorrect(String answer) {
		return answer.equals(correctAnswer);
	}

	@Override
	public String getDescriptionString() {
		return current.getAdj() + " - " + current.getComparative() + " - "
				+ current.getSuperlative();
	}

	@Override
	public String getQuestionString() {
		return current.getAdj();
	}

}
