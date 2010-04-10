package com.vlapan.gwt.englishlab.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Settings extends JavaScriptObject {
	protected Settings() {
	}

	public static native JavaScriptObject getSettings() /*-{
		return $wnd["com_vlapan_gwt_englishlab"];
	}-*/;

	public static native JsArray<IrregularVerbJSO> getIrregularVerbsArray() /*-{
		return $wnd["com_vlapan_gwt_englishlab"].ivArray;
	}-*/;

	public static native JsArray<IrregularAdjJSO> getIrregularAdjArray() /*-{
		return $wnd["com_vlapan_gwt_englishlab"].iaArray;
	}-*/;

	public static native JsArray<SpeechPartJSO> getPartsOfSpeechArray() /*-{
		return $wnd["com_vlapan_gwt_englishlab"].psArray;
	}-*/;
}