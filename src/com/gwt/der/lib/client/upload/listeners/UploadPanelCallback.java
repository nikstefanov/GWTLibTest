package com.gwt.der.lib.client.upload.listeners;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.gwt.der.lib.client.upload.UploadPanel;

public class UploadPanelCallback implements RequestCallback {
	private UploadPanel panel;
	
	public UploadPanelCallback(UploadPanel panel) {
		this.panel = panel;
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getText().equals("##RETRY##")) {
			UploadServerRequests.fetchServerData(panel);
		}
		else {
			panel.setData(response.getText());
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert("Could not load attachment data!");

	}

}
