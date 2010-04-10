package com.vlapan.gwt.englishlab.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.vlapan.gwt.englishlab.client.enums.VerbForm;

public class SimpleTestWidget extends Composite {
	interface MyUiBinder extends UiBinder<DockLayoutPanel, SimpleTestWidget> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField
	Label correctCounter;
	@UiField
	Label correctRateWidget;
	@UiField
	Label mistakeCounter;
	@UiField
	Label mistakeRateWidget;
	@UiField
	Label questionWidget;
	@UiField
	Label currentFormWidget;
	@UiField
	Label correctWidget;
	@UiField
	TextBox inputWidget;
	@UiField
	DockLayoutPanel panel;

	public int attempt = 1;
	public VerbForm currentForm = VerbForm.PastSimple;
	public SimpleTestDataSource dataSource = null;

	public SimpleTestWidget(SimpleTestDataSource dataSource) {
		initWidget(uiBinder.createAndBindUi(this));
		this.dataSource = dataSource;
		currentFormWidget.setText("PastSimple");
		mistakeCounter.setText("0");
		correctCounter.setText("0");
		mistakeRateWidget.setText("0%");
		correctRateWidget.setText("0%");
		panel.setSize("300px", "150px");
		correctCounter.setStyleName("counter");
		mistakeCounter.setStyleName("counter");
		questionWidget.setStyleName("question");
		correctWidget.setStyleName("border");
		this.setCurrent();
		inputWidget.setFocus(true);
		inputWidget.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				checkInput();
				setRate();
			}
		});
	}

	public void setCurrent() {
		inputWidget.setText("");
		SimpleTestObjectAbstract next = dataSource.next();
		if (next == null) {
			currentFormWidget.setText("");
			questionWidget.setText("Game over!");
			inputWidget.setEnabled(false);
		} else {
			currentFormWidget.setText(next.getDescriptionString());
			questionWidget.setText(next.getQuestionString());
		}
	}

	public void setRate() {
		int mistakeCount = Integer.valueOf(mistakeCounter.getText());
		int correctCount = Integer.valueOf(correctCounter.getText());
		int mistakeRate = mistakeCount * 100 / (correctCount + mistakeCount);
		int correctRate = correctCount * 100 / (correctCount + mistakeCount);
		correctRateWidget.setText("" + correctRate + "%");
		mistakeRateWidget.setText("" + mistakeRate + "%");
	}

	public void checkInput() {
		if (dataSource.isCorrect(inputWidget.getText())) {
			setCurrent();
			currentFormWidget.removeStyleName("wrong");
			correctWidget.setText("");
			if (attempt < 3) {
				int correctCount = Integer.valueOf(correctCounter.getText()) + 1;
				correctCounter.setText("" + correctCount);
			}
			attempt = 1;
		} else {
			inputWidget.setText("");
			currentFormWidget.addStyleName("wrong");
			attempt++;
			if (attempt == 3) {
				correctWidget.setText(dataSource.getDescriptionString());
			}
			int mistakeCount = Integer.valueOf(mistakeCounter.getText()) + 1;
			mistakeCounter.setText("" + mistakeCount);
		}
	}
}
