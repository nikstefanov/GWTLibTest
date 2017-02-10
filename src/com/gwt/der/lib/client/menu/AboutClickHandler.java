package com.gwt.der.lib.client.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;

public class AboutClickHandler implements DERSpecificClickHandler {
	private String derName;
	private String aboutText;
	
	
	public AboutClickHandler(String dType, String aboutString) {
		derName = dType;
		aboutText = aboutString;
	}
	@Override
	public void onClick(ClickEvent event) {
		Window.alert(aboutText);
	}


	public String getDerName() {
		return derName;
	}


	public void setDerName(String derName) {
		this.derName = derName;
	}
}
