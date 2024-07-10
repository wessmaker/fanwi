package fi.wessmaker.fanwipcsoftware.GUI.infopanel;

import fi.wessmaker.fanwipcsoftware.FanwiApplication;
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
		infoInstance = FXMLLoader
				.load(Objects.requireNonNull(FanwiApplication.class.getResource("fxml/info-instance.fxml")));
		int textWidth = (int) infoInstance.getColumnConstraints().getFirst().getPrefWidth();
		int valueWidth = (int) infoInstance.getColumnConstraints().getLast().getPrefWidth();
		int height = 55; // This height is hardcoded, it determines the InfoInstance height
		textLabel.setPrefSize(textWidth, height);
		valueLabel.setPrefSize(valueWidth, height);
		textLabel.setWrapText(true);
		infoInstance.setPrefHeight(height);
		infoInstance.setMinHeight(height);
		infoInstance.setMaxHeight(height);
		infoInstance.add(textLabel, 0, 0);
		infoInstance.add(valueLabel, 1, 0);
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
