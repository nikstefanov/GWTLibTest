package com.gwt.der.lib.client.handlers;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.der.lib.client.initialization.InitializationPanel;

public class InitializationCallback implements RequestCallback {
	private Widget childComposite;
	private InitializationPanel initScreen;
	private HasWidgets rootPanel;
	
	public InitializationCallback(HasWidgets rootPanel, InitializationPanel initScreen, Widget composite) {
		this.initScreen = initScreen;
		childComposite = composite;
		this.rootPanel = rootPanel;
	}
	
	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getText().equals("success") ){
			rootPanel.remove(initScreen);
			rootPanel.add(childComposite);
		}
		else {
			if (response.getText().startsWith("<!DOC")) {
				initScreen.setError("Initialization servlet is not active.");
			}
			else {
				initScreen.setError(response.getText());
			}
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
		initScreen.setError(exception.getMessage());
	}

}
