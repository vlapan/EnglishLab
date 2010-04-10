package com.vlapan.gwt.englishlab.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class CenterPanel extends DockPanel implements EntryPoint {
	public CenterPanel() {
		this(new Label("CenterPanel"));
	}
	public CenterPanel(Widget widget) {
		super();
		this.setSize("100%", "100%");
		this.add(widget, DockPanel.CENTER);
		this.setCellHorizontalAlignment(widget, DockPanel.ALIGN_CENTER);
		this.setCellVerticalAlignment(widget, DockPanel.ALIGN_MIDDLE);
	}

	public void onModuleLoad() {
		RootPanel.get().add(this);
		this.add(new Label("test"), DockPanel.SOUTH);
	}
}
