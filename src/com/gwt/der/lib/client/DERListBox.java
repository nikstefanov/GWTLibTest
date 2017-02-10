package com.gwt.der.lib.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ListBox;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.gwt.der.lib.client.handlers.WidgetChangeHandler;
import com.gwt.der.lib.client.handlers.WidgetInitiator;

public class DERListBox extends ListBox implements ValueWidget {

	private String ItemDelimiter = ";";
	private String defaultValue = "";

	public DERListBox() {
		this(false);
	}

	public DERListBox(boolean isMultipleSelect) {
		super(isMultipleSelect);
		addAttachHandler(new WidgetInitiator());
		addChangeHandler(new WidgetChangeHandler());
	}

	public DERListBox(Element element) {
		super(element);
		addAttachHandler(new WidgetInitiator());
		addChangeHandler(new WidgetChangeHandler());
	}

	@Override
	public void setWidgetValue(String str) {
		String itemValue;
		int SBIndex = 0;
		StringBuilder SB = new StringBuilder(str);
		SB.append(ItemDelimiter);
		for (int item = 0; item < this.getItemCount(); item++) {
			itemValue = this.getValue(item);
			if (SBIndex + itemValue.length() + ItemDelimiter.length() <= SB
					.length()
					&& SB.substring(
							SBIndex,
							SBIndex + itemValue.length()
									+ ItemDelimiter.length()).equals(
							itemValue + ItemDelimiter)) {
				this.setItemSelected(item, true);
				SBIndex += itemValue.length() + ItemDelimiter.length();
			}
		}
	}

	@Override
	public String getWidgetValue() {
		StringBuilder SB = new StringBuilder();
		for (int item = 0; item < this.getItemCount(); item++) {
			if (this.isItemSelected(item)) {
				SB.append(this.getValue(item)).append(ItemDelimiter);
			}
		}
		// remove last delimited
		SB.delete(SB.length() - ItemDelimiter.length(), SB.length());
		return SB.toString();
	}

	public String getItemDelimiter() {
		return ItemDelimiter;
	}

	public void setItemDelimiter(String newDelimiter) {
		ItemDelimiter = newDelimiter;
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
