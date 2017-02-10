package com.gwt.der.lib.client.initialization;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class InitializationPanel extends SimplePanel {
	private Label lbl;
	
	public InitializationPanel() {
		super();
		setSize("500px", "200px");
		setStyleName("gwt-initPanel");
		lbl = new Label("Initializing ...");
		lbl.setStyleName("gwt-initPanelLabel");
		this.add(lbl);
	}
	
	public void setError(String err) {
		lbl.setText("ERROR : "+err);
	}

}
