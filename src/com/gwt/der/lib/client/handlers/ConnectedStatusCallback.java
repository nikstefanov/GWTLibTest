package com.gwt.der.lib.client.handlers;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

public class ConnectedStatusCallback implements RequestCallback {
	private Connectable conn;
	
	public ConnectedStatusCallback(Connectable icon) {
		this.conn = icon;
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		try {
			if (response.getText().equals("success")) {
				conn.setConnected(true);
			}
			else {
				conn.setConnected(false);
			}
			
		}
		catch (Exception e) {
			conn.setConnected(false);
		}

	}

	@Override
	public void onError(Request request, Throwable exception) {
		conn.setConnected(false);

	}

}
