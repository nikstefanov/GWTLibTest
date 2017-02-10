package com.gwt.der.lib.client.handlers;

import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class WidgetBooleanValueChangeHandler implements ValueChangeHandler<Boolean> {
	

	public WidgetBooleanValueChangeHandler() {
	}

	@Override
	public void onValueChange(ValueChangeEvent<Boolean> event) {
		updateFieldFromSource((ValueWidget)event.getSource());
	}
	
	private void updateFieldFromSource(ValueWidget sourceWidget){
		ServerRequestsFactory.updateField(sourceWidget);
	}	

}
