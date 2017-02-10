package com.gwt.der.lib.client.handlers;

import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;

public class WidgetFocusBlurHandler implements BlurHandler, FocusHandler {
	
	private String StringValueOnFocus;
	
	public WidgetFocusBlurHandler(){
		StringValueOnFocus = null;
	}

	@Override
	public void onFocus(FocusEvent event) {
		StringValueOnFocus = ((ValueWidget)event.getSource()).getWidgetValue();
	}
	
	@Override
	public void onBlur(BlurEvent event) {
		String StringValueOnBlur = ((ValueWidget)event.getSource()).getWidgetValue();
		if (!StringValueOnBlur.equals(StringValueOnFocus))
			updateFieldFromSource((ValueWidget)event.getSource());
	}
	
	private void updateFieldFromSource(ValueWidget sourceWidget){
		ServerRequestsFactory.updateField(sourceWidget);
	}	

}
