package com.gwt.der.lib.client.undo;

import java.util.ArrayList;

import com.gwt.der.lib.client.handlers.ValueWidget;

public class WidgetUndoRegister {
	private static ArrayList<ValueWidget> register = new ArrayList<ValueWidget>();
	
	
	public static void addWidget(ValueWidget widget) {
		if (!getRegister().contains(widget)) {
			getRegister().add(widget);
		}
	}
	
	public static void removeWidget(ValueWidget widget) {
		if (!getRegister().contains(widget)){
			getRegister().remove(widget);
		}
	}


	public static ArrayList<ValueWidget> getRegister() {
		return register;
	}


	public static void setRegister(ArrayList<ValueWidget> register) {
		WidgetUndoRegister.register = register;
	}

}
