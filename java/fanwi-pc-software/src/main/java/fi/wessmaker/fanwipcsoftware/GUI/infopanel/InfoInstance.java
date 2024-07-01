package fi.wessmaker.fanwipcsoftware.GUI.infopanel;

import fi.wessmaker.fanwipcsoftware.FanwiApplication;
import fi.wessmaker.fanwipcsoftware.communication.debug.Debug;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Objects;

public class InfoInstance {
	private int height, width;
	private Label textLabel;
	private Label valueLabel;
	private boolean booleanValue;
	
	/**
	 * Constructor for elements of main window info panel
	 * */
	public InfoInstance(String labelText, String labelValue){
		this.booleanValue = false;
 		textLabel = new Label(labelText);
		valueLabel = new Label(labelValue);
		textLabel.setMaxSize(width,height);
		textLabel.setMinSize(width, height);
		textLabel.setMinSize(width, height);
	}
	
	
	public InfoInstance(String labelText, boolean labelValue){
		this(labelText, String.valueOf(labelValue));
		this.booleanValue = true;
	}
	
	
	
	/**
	 * Get instance as FXML GridPane with predefined attributes and styling
	 * @return GridPane
	 * */
	public GridPane getInstance(){
		GridPane infoInstance = new GridPane();
		infoInstance.setPrefSize(250, 80);
		try {
			infoInstance = FXMLLoader.load(Objects.requireNonNull(FanwiApplication.class.getResource("fxml/info-instance.fxml")));
			infoInstance.getStylesheets().add(String.valueOf(FanwiApplication.class.getResource("stylesheets/info-instance.css")));
		}
		catch (IOException e) {
			Label errorLabel = new Label("Could not load instance with label: " + "\"" + this.textLabel + "\"");
			errorLabel.setWrapText(true);
			infoInstance.getChildren().add(errorLabel);
			Debug.print(infoInstance, "Instancepane failure: ");
			return infoInstance;
		}
		catch (NullPointerException e){
			Label errorLabel = new Label("Could not load instance with label: " + "\"" + this.textLabel + "\"");
			errorLabel.setWrapText(true);
			infoInstance.getChildren().add(errorLabel);
			return infoInstance;
		}
		return infoInstance;
	}
	
	
	
	public boolean isBooleanValue(){
		return booleanValue;
	}
	
	public void setText(String text){
		this.textLabel.setText(text);
	}
	
	public void setValue(String value){
		this.textLabel.setText(value);
	}
	
	public void setValue(boolean boolValue){
		this.textLabel.setText(String.valueOf(boolValue));
	}
}
