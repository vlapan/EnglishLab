package com.vlapan.gwt.englishlab.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.vlapan.gwt.englishlab.client.enums.VerbForm;

public class IrregularVerbJSO extends JavaScriptObject {
	protected IrregularVerbJSO() {
	}

	public final native String getVerb() /*-{
		return this.v;
	}-*/;

	public final native String getPastSimple() /*-{
		return this.ps;
	}-*/;

	public final native String getPastParticiple() /*-{
		return this.pp;
	}-*/;

	public final native String get(String key) /*-{
		return this[key];
	}-*/;
	
	public final String get(VerbForm vf) {
		return this.get(vf.getShortForm());
	}
}