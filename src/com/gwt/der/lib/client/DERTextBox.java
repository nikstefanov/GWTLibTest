package com.gwt.der.lib.client;

import com.google.gwt.user.client.ui.TextBox;
import com.gwt.der.lib.client.handlers.WidgetChangeHandler;
import com.gwt.der.lib.client.handlers.WidgetInitiator;
import com.gwt.der.lib.client.handlers.ValueWidget;

public class DERTextBox extends TextBox implements ValueWidget {
	private String defaultValue = "";
	public DERTextBox () {
		super();
		addAttachHandler(new WidgetInitiator());
		addChangeHandler(new WidgetChangeHandler());
	}
	
	@Override
	public void setWidgetValue(String str) {
		this.setText(str);
	}
	
	@Override
	public String getWidgetValue() {
		return this.getText();
	}

	@Override
	public void setWidgetDefaultValue(String str) {
		 this.defaultValue = str;
		
	}

	@Override
	public String getWidgetDefaultValue() {
		return this.defaultValue;
	}
	
}
