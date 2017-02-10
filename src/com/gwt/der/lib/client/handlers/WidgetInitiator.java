package com.gwt.der.lib.client.handlers;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.gwt.der.lib.client.undo.WidgetUndoRegister;

public class WidgetInitiator implements Handler {

	@Override
	public void onAttachOrDetach(AttachEvent event) {
		if (event.isAttached()) {
			ValueWidget field = (ValueWidget)event.getSource();
			WidgetUndoRegister.addWidget(field);
			ServerRequestsFactory.setValueForField(field);
			
		}
		else {
			ValueWidget field = (ValueWidget)event.getSource();
			WidgetUndoRegister.removeWidget(field);
		}
	}

}
