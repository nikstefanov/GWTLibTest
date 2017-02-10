package com.gwt.der.lib.client.upload.image;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

public class UploadableImageCallback implements RequestCallback {
	private UploadableImage subject; 
	public UploadableImageCallback(UploadableImage widget) {
		subject = widget;
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		String reply = response.getText();
		subject.setUploaded(reply.contains(subject.getFilename()));
		subject.refreshImage();
	}

	@Override
	public void onError(Request request, Throwable exception) {
		subject.setUploaded(false);
		subject.refreshImage();

	}

}
