package com.gwt.der.lib.client.handlers;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;

public class WidgetChangeHandler implements ChangeHandler {

	@Override
	public void onChange(ChangeEvent event) {
//		String newValue = ((ValueWidget)event.getSource()).getWidgetValue();
//		String newField = ((ValueWidget)event.getSource()).getName();
		
		ServerRequestsFactory.updateField((ValueWidget)event.getSource());
		

	}
}
