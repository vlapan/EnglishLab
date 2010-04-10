package com.vlapan.gwt.englishlab.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.vlapan.gwt.englishlab.client.enums.AdjForm;

public class IrregularAdjJSO extends JavaScriptObject {
	protected IrregularAdjJSO() {
	}

	public final native String getAdj() /*-{
		return this.a;
	}-*/;

	public final native String getComparative() /*-{
		return this.c;
	}-*/;

	public final native String getSuperlative() /*-{
		return this.s;
	}-*/;

	public final native String get(String key) /*-{
		return this[key];
	}-*/;

	public final String get(AdjForm pos) {
		return this.get(pos.getShortForm());
	}

}