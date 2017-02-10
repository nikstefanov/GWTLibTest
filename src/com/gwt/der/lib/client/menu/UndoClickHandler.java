package com.gwt.der.lib.client.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;

public class UndoClickHandler implements DERSpecificClickHandler {

	private String derName;

	
	public UndoClickHandler(String dType) {
		derName = dType;
	}
	@Override
	public void onClick(ClickEvent event) {
		ServerRequestsFactory.undo(derName);
	}


	public String getDerName() {
		return derName;
	}


	public void setDerName(String derName) {
		this.derName = derName;
	}
}
