package com.gwt.der.lib.client.upload;

import gwtupload.client.MultiUploader;

import java.util.HashMap;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.der.lib.client.upload.listeners.UploadPanelAttachHandler;

public class UploadPanel extends VerticalPanel {
	private MultiUploader uploader;
	private HashMap<String, UploadPanelRow> rows = new HashMap<String, UploadPanelRow>();
	private String derType = "";
	
	
	public UploadPanel(String derType) {
		setStylePrimaryName("GWTUpld");
		uploader = new MultiUploader();
		uploader.setServletPath("/DERServer/UploadAttachmentServlet?derType="+derType);
		this.setDerType(derType);
		addAttachHandler(new UploadPanelAttachHandler());
		
//		this.add(child);
	}


	public String getDerType() {
		return derType;
	}


	public void setDerType(String derType) {
		this.derType = derType;
	}
	
	public void setData(String data) {
		this.remove(uploader);
		if (!data.isEmpty()) {
			String [] filenames = data.split("#FILENAME_SEPARATOR#");
			
			this.clear();
			rows.clear();
			for (String fn : filenames) {
				addFileRow(fn);
			}
		}
		
		this.add(uploader);
	}
	
	private void addFileRow(String filename) {
		UploadPanelRow row = new UploadPanelRow(filename, derType, this);
		rows.put(filename,row);
		this.add(row);
	}
	
	public void removeFileRow(String filename) {
		UploadPanelRow row = rows.remove(filename);
		this.remove(row);
		
		
	}
	
}
