package com.gwt.der.lib.client.upload.image;

import gwtupload.client.SingleUploader;

import java.util.Date;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.der.lib.client.upload.listeners.image.UploadableImageAttachHandler;
import com.gwt.der.lib.client.upload.listeners.image.UploadableImageUploadHandler;

public class UploadableImage extends VerticalPanel {
	private SingleUploader singleUpload;
	private boolean isUploaded;
	private Image img;
	private String filename;
	private String derType;
	private String sendFilenameTo;

	public UploadableImage(String filename, String derType) {
		singleUpload = new SingleUploader();
		setUploaded(false);
		img = new Image();
		this.setFilename(filename);
		this.setDerType(derType);
		this.sendFilenameTo = null;
		
		
		updatePath();
		singleUpload.addOnFinishUploadHandler(new UploadableImageUploadHandler(this));
		addAttachHandler(new UploadableImageAttachHandler());
		add(singleUpload);
	}
	
	public UploadableImage(String filename, String derType, String filenameToXMLPath) {
		this(filename, derType);
		setSendFilenameTo(filenameToXMLPath);
	}

	public void refreshImage() {
		remove(singleUpload);
		if (isUploaded()) {
			img.setUrl("/DERServer/GetFile?DER=" + getDerType()
					+ "&ftype=attachment&filename=" + getFilename() + "&lastupdate="
					+ ((sendFilenameTo != null) ? "&actualFilename=" + getSendFilenameTo() : "")  
					+ new Date().getTime());
			add(img);
		}
		else {
			remove(img);
		}
		add(singleUpload);
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
		updatePath();
	}

	public boolean isUploaded() {
		return isUploaded;
	}

	public void setUploaded(boolean isUploaded) {
		this.isUploaded = isUploaded;
	}

	public String getDerType() {
		return derType;
	}

	public void setDerType(String derType) {
		this.derType = derType;
		updatePath();
	}

	public String getSendFilenameTo() {
		return sendFilenameTo;
	}

	public void setSendFilenameTo(String sendFilenameTo) {
		this.sendFilenameTo = sendFilenameTo;
		updatePath();
	}
	private void updatePath() {
		singleUpload.setServletPath("/DERServer/UploadAttachmentServlet?derType="+derType+"&presetFilename="+filename
				+ ((sendFilenameTo != null) ? "&actualFilename=" + getSendFilenameTo() : ""));	
	}

}
