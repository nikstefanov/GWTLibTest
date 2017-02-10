package com.gwt.der.lib.client.upload.listeners.image;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.gwt.der.lib.client.upload.image.UploadableImage;
import com.gwt.der.lib.client.upload.listeners.UploadServerRequests;

public class UploadableImageAttachHandler implements Handler {

	@Override
	public void onAttachOrDetach(AttachEvent event) {
		if (event.isAttached()) {
			UploadServerRequests.fetchImageData((UploadableImage)event.getSource());
		}

	}

}
