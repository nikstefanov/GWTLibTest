package com.gwt.der.lib.client.upload;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.gwt.der.lib.client.upload.listeners.DeleteAttachmentClickHandler;

public class UploadPanelRow extends HorizontalPanel {
	public UploadPanelRow(final String filename, final  String derType, UploadPanel parent) {
		
		setStylePrimaryName("upld-status");
		Label img = new Label(" ");
		img.setStylePrimaryName("cancel");
		
		img.addClickHandler(new DeleteAttachmentClickHandler(filename, parent));
		
		this.add(img);
		
		Label lbl = new Label(filename);
		lbl.setStylePrimaryName("filename");
		this.add(lbl);
		HTML dwnld = new HTML("<a href=\"../DERServer/GetFile?DER="+derType+"&ftype=attachment&filename="+filename+"\">Download</a>");
		dwnld.setStylePrimaryName("status");
		dwnld.addStyleDependentName("changed");
		dwnld.addStyleDependentName("submiting");
		dwnld.addStyleDependentName("queued");
		dwnld.addStyleDependentName("inprogress");
		dwnld.addStyleDependentName("success");
		
		this.add(dwnld);
		
		
		
	}
}
