package com.gwt.der.lib.client.upload.listeners;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.user.client.Window;
import com.gwt.der.lib.client.upload.UploadPanel;
import com.gwt.der.lib.client.upload.image.UploadableImage;
import com.gwt.der.lib.client.upload.image.UploadableImageCallback;

public class UploadServerRequests {

	public static void fetchImageData(UploadableImage image) {
		try {

			RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
					"/DERServer/" + "FetchAttachmentListServlet");
			builder.setRequestData(image.getDerType());
			UploadableImageCallback req = new UploadableImageCallback(image);
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
	
	public static void fetchServerData(UploadPanel panel) {
		try {

			RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
					"/DERServer/" + "FetchAttachmentListServlet");
			builder.setRequestData(panel.getDerType());
			UploadPanelCallback req = new UploadPanelCallback(panel);
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
	
	public static void deleteAttachment(String filename, UploadPanel uploadPanel) {
		try {

			RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,
					"/DERServer/" + "DeleteAttachmentServlet");
			builder.setRequestData(filename+"#DER_TYPE#"+uploadPanel.getDerType());
			DeleteAttachmentCallback req = new DeleteAttachmentCallback(filename, uploadPanel);
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
	
	
	
}
