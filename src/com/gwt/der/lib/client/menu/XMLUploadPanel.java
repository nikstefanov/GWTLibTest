package com.gwt.der.lib.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class XMLUploadPanel extends SimplePanel {
	
	private FormPanel uploadForm;
	private Hidden derTypeField;
	
	
	public XMLUploadPanel() {
		VerticalPanel vpan = new VerticalPanel();
		vpan.setSize("100%", "100%");
		this.add(vpan);
		String prefix = GWT.getModuleBaseForStaticFiles();
		
		HorizontalPanel topRow= new HorizontalPanel();
		
		topRow.setSize("100%", "100%");
		
		
		Label cornerLabel = new Label(" ");
		cornerLabel.setSize("15px", "15px");
		cornerLabel.setStyleName("tlcorner");
		topRow.add(cornerLabel);
//		topRow.add(new Image(prefix + "tlcorner.png"));
		
		Label midLabel = new Label(" ");
		midLabel.setSize("100%", "100%");
		topRow.add(midLabel);
		
		cornerLabel = new Label(" ");
		cornerLabel.setSize("15px", "15px");
		cornerLabel.setStyleName("trcorner");
		topRow.add(cornerLabel);
		topRow.setCellHorizontalAlignment(cornerLabel,HasHorizontalAlignment.ALIGN_RIGHT);
//		topRow.add(new Image(prefix + "trcorner.png"));
		
		vpan.add(topRow);
		
		HorizontalPanel midRow = new HorizontalPanel();
		Label spacer = new Label(" ");
		spacer.setWidth("10px");
		midRow.add(spacer);
		uploadForm = new FormPanel();
		uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		uploadForm.setMethod(FormPanel.METHOD_POST);
		uploadForm.addStyleName("table-center");
		uploadForm.getElement().<FormElement>cast().setTarget("");
		VerticalPanel formPanel = new VerticalPanel();
		formPanel.setSpacing(3);
		
		Hidden derFileTypeField = new Hidden("derFileType", "XML");
		formPanel.add(derFileTypeField);
		
		derTypeField = new Hidden("derType", "");
		formPanel.add(derTypeField);
		
		FileUpload fUp = new FileUpload();
		fUp.setName("file");
		
		fUp.setStyleName("fileUpload");
		formPanel.add(fUp);
		
		HTML submitButton = new HTML();
		submitButton.setHTML("<input type=\"image\" src=\"" + prefix + "upload.png\"/>");
		
		
		formPanel.add(submitButton);
		formPanel.setCellHorizontalAlignment(submitButton, HasHorizontalAlignment.ALIGN_RIGHT);
		
		uploadForm.add(formPanel);
		
		
		midRow.add(uploadForm);
		spacer = new Label(" ");
		spacer.setWidth("10px");
		midRow.add(spacer);
		
		vpan.add(midRow);
		
		HorizontalPanel bottomRow = new HorizontalPanel();
		bottomRow.setSize("100%", "100%");
		
		cornerLabel = new Label(" ");
		cornerLabel.setSize("15px", "15px");
		cornerLabel.setStyleName("blcorner");
		bottomRow.add(cornerLabel);
//		bottomRow.add(new Image(prefix + "blcorner.png"));
//		bottomRow.add(new Label());
		midLabel = new Label(" ");
		midLabel.setSize("100%", "100%");
		bottomRow.add(midLabel);
		
		cornerLabel = new Label(" ");
		cornerLabel.setSize("15px", "15px");
		cornerLabel.setStyleName("brcorner");
		bottomRow.add(cornerLabel);
		bottomRow.setCellHorizontalAlignment(cornerLabel,HasHorizontalAlignment.ALIGN_RIGHT);
//		bottomRow.add(new Image(prefix + "brcorner.png"));
		
		vpan.add(bottomRow);
		
		
		topRow.setSpacing(0);
		midRow.setSpacing(0);
		bottomRow.setSpacing(0);
		vpan.setSpacing(0);
		uploadForm.setAction("/DERServer/UploadFile");
		
		
		
	}
	

	public void setDERType(String str) {
		
		derTypeField.setValue(str);
		
		
	}
	

}
