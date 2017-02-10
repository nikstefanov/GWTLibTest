package com.gwt.der.lib.client.handlers;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
//Used as non static Selection Handler in Nikolay's DERAutoSuggestBoxes.
public class WidgetSelectionHandler implements SelectionHandler<Suggestion> {
	

	@Override
	public void onSelection(SelectionEvent<Suggestion> event) {
		updateFieldFromSource((ValueWidget)((SuggestBox)event.getSource()).getValueBox());		
	}
	
	private void updateFieldFromSource(ValueWidget sourceWidget){
		ServerRequestsFactory.updateField(sourceWidget);
	}	

}
