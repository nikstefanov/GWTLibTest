package com.gwt.der.lib.client.upload.listeners.image;

import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnFinishUploaderHandler;

import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.gwt.der.lib.client.upload.image.UploadableImage;

public class UploadableImageUploadHandler implements OnFinishUploaderHandler {
	private UploadableImage parent;
	
	public UploadableImageUploadHandler(UploadableImage parent) {
		this.parent = parent;
	}
	
	@Override
	public void onFinish(final IUploader uploader) {
		parent.setUploaded(true);
		parent.refreshImage();
		if (parent.getSendFilenameTo() != null) {
			ServerRequestsFactory.updateField(new ValueWidget() {
				
				@Override
				public void setWidgetValue(String str) {
					
				}
				
				@Override
				public void setWidgetDefaultValue(String str) {
					
				}
				
				@Override
				public void setName(String widName) {
					
				}
				
				@Override
				public String getWidgetValue() {
					return uploader.getBasename();
				}
				
				@Override
				public String getWidgetDefaultValue() {
					return null;
				}
				
				@Override
				public String getName() {
					return parent.getSendFilenameTo();
				}
			});// parent.getSendFilenameTo(), uploader.getBasename());
		}
		
	}


}
