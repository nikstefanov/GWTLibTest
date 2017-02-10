package com.gwt.der.lib.client.handlers;

import java.util.Date;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.der.lib.client.initialization.InitializationPanel;
import com.gwt.der.lib.client.undo.callback.UndoCallback;

public class ServerRequestsFactory {

	public static void setValueForField(ValueWidget field) {
		try {

			RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
					"/DERServer/" + "FetchServlet");
			builder.setRequestData(field.getName() + "#DEFAULT_VALUE#"
					+ field.getWidgetDefaultValue());
			PersistentCallback req = new PersistentCallback(field);
			builder.setCallback(req);

			try {
				builder.send();

			} catch (RequestException e) {
				Window.alert("Failed to send the request: " + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initiateSession(HasWidgets rootElement, Widget composite) {
		InitializationPanel initPanel = new InitializationPanel();
		rootElement.add(initPanel);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
				"/DERServer/" + "CheckSessionServlet");
		InitializationCallback iCall = new InitializationCallback( rootElement, initPanel,  composite);
		
		builder.setCallback(iCall);
		try {
			builder.send();
		} catch (RequestException e) {
			Window.alert("Failed to send the request: " + e.getMessage());
		}
		
	}
	
	
	public static void checkConnection(Connectable conn) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
				"/DERServer/" + "CheckSessionServlet");
		ConnectedStatusCallback iCall = new ConnectedStatusCallback(conn);
		builder.setRequestData(String.valueOf(new Date().getTime()));
		builder.setCallback(iCall);
		try {
			builder.send();
		} catch (RequestException e) {
			conn.setConnected(false);
		}
	}
	public static void updateField(final String path, final String value) {
		final RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
				"/DERServer/" + "UpdateServlet");
		String requestData = path + "#DATA_SEPARATOR#" + value;
		builder.setRequestData(requestData);
		RequestCallback req = new RequestCallback() {

			public void onError(Request request, Throwable exception) {
				// code omitted for clarity
				Window.alert("Failed to send the request: "
						+ exception.getMessage());
			}

			public void onResponseReceived(Request request, Response response) {
				if (response.getText().equals("done")) {
				}
				else {
					Timer timer = new Timer() {
						
						@Override
						public void run() {
							updateField(path, value);
							
						}
					};
					timer.schedule(5000);
				}
			}
		};
		builder.setCallback(req);

		try {
			builder.send();
		} catch (RequestException e) {
			Window.alert("Failed to send the request: " + e.getMessage());
		}
	}
	
	public static void updateField(final ValueWidget widget) {
		updateField(widget.getName(), widget.getWidgetValue());
	}
	
	public static void deleteField(String path) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
				"/DERServer/" + "DeleteServlet");

		String requestData = path;
		builder.setRequestData(requestData);
		RequestCallback req = new RequestCallback() {

			public void onError(Request request, Throwable exception) {
				// code omitted for clarity
				Window.alert("Failed to send the request: "
						+ exception.getMessage());
			}

			public void onResponseReceived(Request request, Response response) {

			}
		};
		builder.setCallback(req);

		try {
			builder.send();
		} catch (RequestException e) {
			Window.alert("Failed to send the request: " + e.getMessage());
		}
	}
	
	public static void undo(String der) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
				"/DERServer/" + "UndoServlet");
		builder.setRequestData(der);
		builder.setCallback(new UndoCallback());
		try {
			builder.send();
		} catch (RequestException e) {
			Window.alert("Failed to send the request: " + e.getMessage());
		}
	}

}
