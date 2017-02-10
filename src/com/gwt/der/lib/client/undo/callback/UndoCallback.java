package com.gwt.der.lib.client.undo.callback;

import java.util.ArrayList;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.gwt.der.lib.client.undo.WidgetUndoRegister;

public class UndoCallback implements RequestCallback {
	
	

	@Override
	public void onResponseReceived(Request request, Response response) {
		String resp = response.getText();
		if (!resp.equals("ERROR") && resp.contains("#DATA_SEPARATOR#")) {
			String resps [] = resp.split("#DATA_SEPARATOR#");
			String path = resps[0];
			String val = "";
			if (resps.length > 1) {
				val = resps[1];
			}
			
			
			ArrayList<ValueWidget> widgets = WidgetUndoRegister.getRegister();
			for (int i = 0 ; i < widgets.size(); i++) {
				ValueWidget el = widgets.get(i);
				if (el.getName().equals(path)) {
					el.setWidgetValue(val);
				}
			}
			
			
		}

	}

	@Override
	public void onError(Request request, Throwable exception) {

	}

}
