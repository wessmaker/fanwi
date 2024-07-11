package fi.wessmaker.fanwipcsoftware.GUI.infopanel;

import fi.wessmaker.fanwipcsoftware.FanwiApplication;
import fi.wessmaker.fanwipcsoftware.utility.GuiUtility;
import fi.wessmaker.fanwipcsoftware.utility.StyleClassType;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.text.ListFormat.Style;
import java.util.Objects;

public class InfoInstance {

	@FXML
	private GridPane infoInstanceGridPane;

	private Label textLabel;

	private Label valueLabel;

	private boolean booleanValue;

	private InfoInstanceType type;


	/**
	 * Constructor for elements of main window info panel
	 */
	public InfoInstance(String text, String value, InfoInstanceType type) {
		this.booleanValue = false;
		this.type = type;
		textLabel = new Label(text);
		valueLabel = new Label(value);
		textLabel.getStyleClass().addAll("textLabel");
		valueLabel.getStyleClass().addAll("valueLabel");
		instanceValueColoring();
		valueLabel.textProperty().addListener(changeListener -> {
			instanceValueColoring();
		});
	}



	private void instanceValueColoring() {
		if (this.type.isBooleanValue()) {
			switch (valueLabel.getText().toLowerCase()) {
				case "true":
					GuiUtility.setStatusStylingClass(valueLabel, StyleClassType.ENABLED_STYLE);
					break;
				case "false":
					GuiUtility.setStatusStylingClass(valueLabel, StyleClassType.DISABLED_STYLE);
			}
		} else {
			if (Integer.parseInt(valueLabel.getText()) > 0) {
				GuiUtility.setStatusStylingClass(valueLabel, StyleClassType.ENABLED_STYLE);
			} else {
				GuiUtility.setStatusStylingClass(valueLabel, StyleClassType.DISABLED_STYLE);
			}
		}
	}



	public InfoInstance(String labelText, boolean labelValue, InfoInstanceType type) {
		this(labelText, String.valueOf(labelValue), type);
		this.booleanValue = true;
	}



	/**
	 * Get new instance as FXML GridPane with predefined attributes and styling
	 * 
	 * @return GridPane
	 */
	public GridPane getNewInstance() throws IOException {
		GridPane infoInstance;
		double instanceHeight = 55;
		infoInstance = FXMLLoader
				.load(Objects.requireNonNull(FanwiApplication.class.getResource("fxml/info-instance.fxml")));
		infoInstance.setPrefHeight(instanceHeight);
		infoInstance.setMinHeight(instanceHeight);
		infoInstance.setMaxHeight(instanceHeight);
		infoInstance.add(this.textLabel, 0, 0);
		infoInstance.add(this.valueLabel, 1, 0);
		infoInstance.getStylesheets()
				.add(String.valueOf(FanwiApplication.class.getResource("stylesheet/info-instance.css")));
		return infoInstance;
	}



	public boolean isBooleanValue() {
		return this.booleanValue;
	}



	public InfoInstanceType getInfoInstanceType() {
		return this.type;
	}

	public void setValue(String value){
		this.valueLabel.setText(value);
	}
}
