package com.gwt.der.lib.client;

import com.google.gwt.user.client.ui.RichTextArea;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.gwt.der.lib.client.handlers.WidgetFocusBlurHandler;
import com.gwt.der.lib.client.handlers.WidgetInitiator;

public class DERRichTextArea extends RichTextArea implements ValueWidget {
	
	private String Name;
	private String defaultValue = "";

	public DERRichTextArea() {
		Name = "";
		this.addBlurHandler (new WidgetFocusBlurHandler());
		this.addFocusHandler(new WidgetFocusBlurHandler());
		this.addAttachHandler(new WidgetInitiator());
	}

	@Override
	public void setWidgetValue(String str) {
		setHTML(str);
	}

	@Override
	public String getWidgetValue() {
		return getHTML();
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public void setName(String widName) {
		Name = widName;		
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
