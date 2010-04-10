package com.vlapan.gwt.englishlab.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.vlapan.gwt.englishlab.client.enums.GameType;
import com.vlapan.gwt.englishlab.client.enums.VerbForm;

public class EnglishLab implements EntryPoint {
	public final AbsolutePanel panel = new AbsolutePanel();
	public final CenterPanel cp = new CenterPanel(panel);
	public final IrregularAdjGame iaGame1 = new IrregularAdjGame(GameType.STRAIGHT);
	public final PartsOfSpeechGame psGame1 = new PartsOfSpeechGame();
	public final IrregularVerbGame ivGame1 = new IrregularVerbGame();
	public final IrregularVerbGame ivGame2 = new IrregularVerbGame(
			GameType.RANDOM, VerbForm.PastSimple);
	public final IrregularVerbGame ivGame3 = new IrregularVerbGame(
			GameType.RANDOM, VerbForm.PastParticiple);
	public final IrregularVerbGame ivGame4 = new IrregularVerbGame(
			GameType.STRAIGHT, VerbForm.PastSimple);
	public final IrregularVerbGame ivGame5 = new IrregularVerbGame(
			GameType.STRAIGHT, VerbForm.PastParticiple);

	public void onModuleLoad() {
		RootPanel.get("viewPort").add(cp);
		panel.add(new SimpleTestWidget(iaGame1));
		panel.add(new SimpleTestWidget(psGame1));
		panel.add(new SimpleTestWidget(ivGame1));
		panel.add(new SimpleTestWidget(ivGame2));
		panel.add(new SimpleTestWidget(ivGame4));
	}
}
