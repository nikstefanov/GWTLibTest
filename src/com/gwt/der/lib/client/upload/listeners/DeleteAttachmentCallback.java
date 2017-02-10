package com.gwt.der.lib.client.upload.listeners;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.gwt.der.lib.client.upload.UploadPanel;

public class DeleteAttachmentCallback implements RequestCallback {
	private UploadPanel panel;
	private String filename;
	public DeleteAttachmentCallback(String filename, UploadPanel uploadPanel) {
		this.panel = uploadPanel;
		this.filename = filename;
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		panel.removeFileRow(filename);

	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert("Could not delete "+filename+"from server!");

	}

}
