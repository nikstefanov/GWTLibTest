package com.gwt.der.lib.client;

import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.CheckBox;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.gwt.der.lib.client.handlers.WidgetInitiator;
import com.gwt.der.lib.client.handlers.WidgetBooleanValueChangeHandler;

public class DERCheckBox extends CheckBox implements ValueWidget {
	private String defaultValue = ""; 

	public DERCheckBox() {
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(SafeHtml label) {
		super(label);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(String label) {
		super(label);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(Element elem) {
		super(elem);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(SafeHtml label, Direction dir) {
		super(label, dir);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(SafeHtml label, DirectionEstimator directionEstimator) {
		super(label, directionEstimator);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(String label, Direction dir) {
		super(label, dir);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(String label, DirectionEstimator directionEstimator) {
		super(label, directionEstimator);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	public DERCheckBox(String label, boolean asHTML) {
		super(label, asHTML);
		addAttachHandler(new WidgetInitiator());
		addValueChangeHandler(new WidgetBooleanValueChangeHandler());
	}

	@Override
	public void setWidgetValue(String str) {
		String lowCaseStr = str.toLowerCase();
		if (lowCaseStr.equals("true") || lowCaseStr.equals("false"))
			this.setValue(Boolean.parseBoolean(str), true);		
	}

	@Override
	public String getWidgetValue() {
		return this.getValue().toString();
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
