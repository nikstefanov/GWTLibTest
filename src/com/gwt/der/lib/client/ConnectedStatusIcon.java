package com.gwt.der.lib.client;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import com.gwt.der.lib.client.handlers.Connectable;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.reveregroup.gwt.imagepreloader.ImagePreloader;

public class ConnectedStatusIcon extends Image implements Connectable {
	private Timer timer; 
	
	public ConnectedStatusIcon() {
		ImagePreloader.load("/DERServer/CONNECTED.GIF", null);
		ImagePreloader.load("/DERServer/NOACCESS.GIF", null);
		addAttachHandler(new Handler() {
			
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					ServerRequestsFactory.checkConnection(ConnectedStatusIcon.this);
				}
				
			}
		});
		
		timer = new Timer() {
			
			@Override
			public void run() {
				 ServerRequestsFactory.checkConnection(ConnectedStatusIcon.this);
				
			}
		};
		timer.scheduleRepeating(15000);
		
	}
	
	public void setConnected(Boolean state) {
		if (state) {
			this.setUrl("/DERServer/CONNECTED.GIF");
			this.setTitle("Your connection is alive and your data is being saved to the server with every change.");
		}
		else {
			this.setUrl("/DERServer/NOACCESS.GIF");
			this.setTitle("There is a problem with your connection. No data is being saved to the server.");
		}
	}

}
