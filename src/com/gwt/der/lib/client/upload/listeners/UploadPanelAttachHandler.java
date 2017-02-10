package com.gwt.der.lib.client.upload.listeners;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.gwt.der.lib.client.upload.UploadPanel;

public class UploadPanelAttachHandler implements Handler {

	@Override
	public void onAttachOrDetach(AttachEvent event) {
		UploadServerRequests.fetchServerData((UploadPanel) event.getSource());

	}

}
