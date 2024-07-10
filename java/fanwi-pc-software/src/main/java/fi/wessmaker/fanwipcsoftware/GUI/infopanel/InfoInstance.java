package fi.wessmaker.fanwipcsoftware.GUI.infopanel;

import fi.wessmaker.fanwipcsoftware.FanwiApplication;
import fi.wessmaker.fanwipcsoftware.utility.GuiUtility;
import fi.wessmaker.fanwipcsoftware.utility.StyleClassType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
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
		valueLabel.getStyleClass().addAll("valueLabel");
		textLabel.getStyleClass().addAll("textLabel");
	}



	public InfoInstance(String labelText, boolean labelValue, InfoInstanceType type) {
		this(labelText, String.valueOf(labelValue), type);
		this.booleanValue = true;
	}



	/**
	 * Get instance as FXML GridPane with predefined attributes and styling
	 * 
	 * @return GridPane
	 */
	public GridPane getInstance() throws IOException {
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



	public void setText(String text) {
		this.textLabel.setText(text);
	}



	public void setValue(String value) {
		this.textLabel.setText(value);
	}



	public void setValue(boolean boolValue) {
		this.textLabel.setText(String.valueOf(boolValue));
	}
}
