package com.gwt.der.lib.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;

public class UndoButton extends Button {
	public UndoButton(final String derType) {
		this.setText("Undo");
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					ServerRequestsFactory.undo(derType);
			}
		});
	}
}
