package com.vlapan.gwt.englishlab.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.vlapan.gwt.englishlab.client.enums.PartsOfSpeech;

public class SpeechPartJSO extends JavaScriptObject {
	protected SpeechPartJSO() {
	}

	public final native String getNoun() /*-{
		return this.n;
	}-*/;

	public final native String getVerb() /*-{
		return this.v;
	}-*/;

	public final native String getAdj() /*-{
		return this.a;
	}-*/;

	public final native String get(String key) /*-{
		return this[key];
	}-*/;

	public final String get(PartsOfSpeech pos) {
		return this.get(pos.getShortForm());
	}
}