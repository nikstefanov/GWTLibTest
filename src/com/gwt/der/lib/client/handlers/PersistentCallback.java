package com.gwt.der.lib.client.handlers;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

public class PersistentCallback implements RequestCallback {
	private ValueWidget source;

	public PersistentCallback(ValueWidget source) {
		this.source = source;
	}

	@Override
	public void onError(Request request, Throwable exception) {
		source.setWidgetValue("##ERROR##");
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getText().equals("##RETRY##")) {
			ServerRequestsFactory.setValueForField(source);
		}
		else {
			source.setWidgetValue(response.getText());
		}
	}
}
