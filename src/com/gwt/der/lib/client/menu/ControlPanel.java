package com.gwt.der.lib.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.der.lib.client.handlers.Connectable;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;

public class ControlPanel extends SimplePanel implements Connectable {

	private enum ColorSchemes {
		GREEN, RED
	};

	private String derName;
	private HorizontalPanel buttonHolder;
	private Label undo, clear, loadXML, saveXML, saveDOC, about, connected;
	private Timer timer;
	private String aboutText;

	private DERSpecificClickHandler saveXMLClick, saveDOCClick, loadXMLClick,
			aboutClick, undoClick, clearClick;
	private HandlerRegistration saveXMLReg, saveDOCReg, loadXMLReg, aboutReg,
			undoReg, clearReg;

	public ControlPanel(String derType, String aboutStr) {
		
		aboutText = aboutStr;
		derName = derType;
		preloadImages();

		buttonHolder = new HorizontalPanel();
		this.add(buttonHolder);

		createLabels();
		createHandlers();
		setColorScheme(ColorSchemes.GREEN);

		buttonHolder.add(loadXML);
		buttonHolder.add(saveXML);
		buttonHolder.add(saveDOC);
		buttonHolder.add(clear);
		buttonHolder.add(undo);
		buttonHolder.add(about);
		buttonHolder.add(connected);

		addAttachHandler(new Handler() {

			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					ServerRequestsFactory.checkConnection(ControlPanel.this);
				}

			}
		});

		timer = new Timer() {

			@Override
			public void run() {
				ServerRequestsFactory.checkConnection(ControlPanel.this);

			}
		};
		timer.scheduleRepeating(15000);

	}

	public String getDerName() {
		return derName;
	}

	public void setDerName(String derName) {
		this.derName = derName;

		loadXMLClick.setDerName(derName);
		saveXMLClick.setDerName(derName);
		saveDOCClick.setDerName(derName);
		aboutClick.setDerName(derName);
		undoClick.setDerName(derName);
		clearClick.setDerName(derName);

	}

	@Override
	public void setConnected(Boolean conn) {
		if (conn) {
			setColorScheme(ColorSchemes.GREEN);
			setListeningState(conn);
		} else {
			setColorScheme(ColorSchemes.RED);
			setListeningState(conn);
		}
	}

	private void setColorScheme(ColorSchemes cl) {
		if (cl == ColorSchemes.GREEN) {
			undo.setStyleName("undoImageGreen");
			clear.setStyleName("clearImageGreen");
			loadXML.setStyleName("loadXMLImageGreen");
			saveXML.setStyleName("saveXMLImageGreen");
			saveDOC.setStyleName("saveDOCImageGreen");
			about.setStyleName("aboutImageGreen");
			connected.setStyleName("connectedImageGreen");
			connected
					.setTitle("Your connection is alive and your data is being saved to the server with every change.");
			setStyleName("controlPanelGreen");
		} else if (cl == ColorSchemes.RED) {
			undo.setStyleName("undoImageRed");
			clear.setStyleName("clearImageRed");
			loadXML.setStyleName("loadXMLImageRed");
			saveXML.setStyleName("saveXMLImageRed");
			saveDOC.setStyleName("saveDOCImageRed");
			about.setStyleName("aboutImageRed");
			connected.setStyleName("connectedImageRed");
			connected
					.setTitle("There is a problem with your connection. No data is being saved to the server.");
			setStyleName("controlPanelRed");
		}
	}

	private void setListeningState(Boolean state) {
		if (state) {
			saveXMLReg.removeHandler(); // Ensures we don't stack several
										// handlers
			saveXMLReg = saveXML.addClickHandler(saveXMLClick);

			loadXMLReg.removeHandler();
			loadXMLReg = loadXML.addClickHandler(loadXMLClick);

			saveDOCReg.removeHandler();
			saveDOCReg = saveDOC.addClickHandler(saveDOCClick);

			clearReg.removeHandler();
			clearReg = clear.addClickHandler(clearClick);

			undoReg.removeHandler();
			undoReg = undo.addClickHandler(undoClick);

			aboutReg.removeHandler();
			aboutReg = about.addClickHandler(aboutClick);
		} else {
			saveXMLReg.removeHandler();
			loadXMLReg.removeHandler();
			saveDOCReg.removeHandler();
			clearReg.removeHandler();
			undoReg.removeHandler();
			aboutReg.removeHandler();
		}
	}

	private void createLabels() {
		undo = new Label(" ");
		clear = new Label(" ");
		loadXML = new Label(" ");
		saveXML = new Label(" ");
		saveDOC = new Label(" ");
		about = new Label(" ");
		connected = new Label(" ");
	}

	private void createHandlers() {

		saveXMLClick = new SaveXMLClickHandler(derName);
		saveXMLReg = saveXML.addClickHandler(saveXMLClick);

		loadXMLClick = new LoadXMLClickHandler(derName,
				loadXML.getAbsoluteLeft(), loadXML.getAbsoluteTop());
		loadXMLReg = loadXML.addClickHandler(loadXMLClick);

		saveDOCClick = new SaveDOCClickHandler(derName);
		saveDOCReg = saveDOC.addClickHandler(saveDOCClick);

		clearClick = new ClearClickHandler(derName);
		clearReg = clear.addClickHandler(clearClick);

		undoClick = new UndoClickHandler(derName);
		undoReg = undo.addClickHandler(undoClick);

		aboutClick = new AboutClickHandler(derName, aboutText);
		aboutReg = about.addClickHandler(aboutClick);

	}

	private void preloadImages() {
		SimplePanel smp = new SimplePanel();
		smp.setStyleName("preloader");
		VerticalPanel sp = new VerticalPanel();
		smp.add(sp);
		String prefix = GWT.getModuleBaseForStaticFiles();
		RootPanel.get().add(smp);
		
		Image img;
		img = new Image(prefix + "aboutg.png");
		sp.add(img);
		img = new Image(prefix + "aboutr.png");
		sp.add(img);
		img = new Image(prefix + "clearg.png");
		sp.add(img);
		img = new Image(prefix + "clearr.png");
		sp.add(img);
		img = new Image(prefix + "connectedg.png");
		sp.add(img);
		img = new Image(prefix + "connectedr.png");
		sp.add(img);
		img = new Image(prefix + "loadXMLg.png");
		sp.add(img);
		img = new Image(prefix + "loadXMLr.png");
		sp.add(img);
		img = new Image(prefix + "saveDOCg.png");
		sp.add(img);
		img = new Image(prefix + "saveDOCr.png");
		sp.add(img);
		img = new Image(prefix + "saveXMLg.png");
		sp.add(img);
		img = new Image(prefix + "saveXMLr.png");
		sp.add(img);
		img = new Image(prefix + "undog.png");
		sp.add(img);
		img = new Image(prefix + "undor.png");
		sp.add(img);
		
		img = new Image(prefix + "trcorner.png");
		sp.add(img);
		img = new Image(prefix + "tlcorner.png");
		sp.add(img);
		img = new Image(prefix + "brcorner.png");
		sp.add(img);
		img = new Image(prefix + "blcorner.png");
		sp.add(img);
		
		img = new Image(prefix + "upload.png");
		sp.add(img);
	}

}
