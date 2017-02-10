package com.gwt.der.lib.client.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.PopupPanel;

public class LoadXMLClickHandler implements DERSpecificClickHandler {
	private String derName;
	private PopupPanel uploadPanel;
	private XMLUploadPanel uploadPanelForm;
	private int left, top;

	
	public LoadXMLClickHandler(String dType, int left, int top) {
		derName = dType;
		this.left = left;
		this.top = top;
		createUploadPanel();
	}
	@Override
	public void onClick(ClickEvent event) {
		showUploadPanel();
	}


	public String getDerName() {
		return derName;
	}


	public void setDerName(String derName) {
		this.derName = derName;
		
		
//		uploadPanel
//		.setWidget(new HTML(
//				"<form action=\"/DERServer/UploadFile\" method=\"post\" enctype=\"multipart/form-data\">"
//						+ "<input type=\"hidden\" name=\"derType\" value=\""
//						+ derName
//						+ "\"/>"
//						+ "<input type=\"hidden\" name=\"derFileType\" value=\"XML\"/>"
//						+ "<input type=\"file\" name=\"file\"/><br/>"
//						+ "<input type=\"submit\" /><br/>"));
	}

	private void createUploadPanel() {
		uploadPanel = new PopupPanel(true);
		uploadPanel.setGlassEnabled(true);
		uploadPanel.setStyleName("XMLuploadPanel");
		
		uploadPanelForm = new XMLUploadPanel();
		
		uploadPanelForm.setDERType(derName);
		uploadPanel.add(uploadPanelForm);
//		
//		
//		
//		
//		uploadPanel
//				.setWidget(new HTML(
//						"<form action=\"/DERServer/UploadFile\" method=\"post\" enctype=\"multipart/form-data\">"
//								+ "<input type=\"hidden\" name=\"derType\" value=\""
//								+ derName
//								+ "\"/>"
//								+ "<input type=\"hidden\" name=\"derFileType\" value=\"XML\"/>"
//								+ "<input type=\"file\" name=\"file\"/><br/>"
//								+ "<input type=\"submit\" /><br/>"));
	}

	public void showUploadPanel() {
		uploadPanel.setPopupPosition(left+34, top+50);
		uploadPanel.show();
	}
}
