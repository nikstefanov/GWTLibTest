package com.gwt.der.lib.client.upload.listeners;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.gwt.der.lib.client.upload.UploadPanel;

public class DeleteAttachmentClickHandler implements ClickHandler {
	private UploadPanel parent;
	private String filename;
	
	public DeleteAttachmentClickHandler(String filename, UploadPanel parent){
		this.parent = parent;
		this.filename = filename;
	}
	
	

	@Override
	public void onClick(ClickEvent event) {
		
		UploadServerRequests.deleteAttachment(filename, parent);

	}

}
