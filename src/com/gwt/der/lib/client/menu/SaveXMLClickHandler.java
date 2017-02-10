package com.gwt.der.lib.client.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;

public class SaveXMLClickHandler implements DERSpecificClickHandler {
	private String derName;

	
	public SaveXMLClickHandler(String dType) {
		derName = dType;
	}
	@Override
	public void onClick(ClickEvent event) {
		Window.Location.assign("/DERServer/GetFile?ftype=xml&DER=" + derName); 

	}


	public String getDerName() {
		return derName;
	}


	public void setDerName(String derName) {
		this.derName = derName;
	}

}
