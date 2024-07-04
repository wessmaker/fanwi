package fi.wessmaker.fanwipcsoftware.GUI;

import fi.wessmaker.fanwipcsoftware.FanwiApplication;
import fi.wessmaker.fanwipcsoftware.communication.TransmitType;
import fi.wessmaker.fanwipcsoftware.communication.Writer;
import fi.wessmaker.fanwipcsoftware.communication.debug.Debug;
import fi.wessmaker.fanwipcsoftware.hardware.Fan;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FanGridPaneController implements Initializable {

	@FXML
	private GridPane contentGridPane;

	@FXML
	private GridPane labelGridPane1;

	@FXML
	private Label offsetLabel;

	@FXML
	private Label offsetLabel1;

	@FXML
	private Label offsetLabel11;

	@FXML
	private Slider offsetSlider;

	@FXML
	private Label offsetValueLabel;

	@FXML
	private Label speedLabel;

	@FXML
	private Slider speedSlider;

	@FXML
	private Label speedValueLabel;

	@FXML
	private Label tempControlToggleLabel;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		speedSlider.setOnMouseDragged(mouseDrag -> {
			onSpeedSliderDrag();
		});
		offsetSlider.setOnMouseDragged(mouseDrag -> {
			onOffsetSliderDrag();
		});
		tempControlToggleLabel.setOnMouseClicked(mouseClick -> {
			onTempControlClick();
		});
		if (Fan.getInstance().isTempControlled()) {
			getTempControlToggleLabel().setText("ON");
		} else {
			getTempControlToggleLabel().setText("OFF");
		}
	}


	public GridPane getFanGridPane() {
		GridPane fanGridPane;
		try {
			fanGridPane = FXMLLoader
					.load(Objects.requireNonNull(FanwiApplication.class.getResource("fxml/fan-block.fxml")));
			ImageView fanImageView = new ImageView(
					new Image(Objects.requireNonNull(FanwiApplication.class.getResourceAsStream("images/fan_icon1.png"))));
			fanImageView.setFitHeight(120);
			fanImageView.setPreserveRatio(true);
			fanImageView.setSmooth(false);
			fanGridPane.add(fanImageView, 1, 1);
			fanGridPane.getStylesheets()
					.add(String.valueOf(FanwiApplication.class.getResource("stylesheet/fan-block.css")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return fanGridPane;
	}



	private void onTempControlClick() {
		switch (getTempControlToggleLabel().getText().toLowerCase()) {
			case "on" -> {
				Fan.getInstance().setTempControlled(false);
				Debug.print(getTempControlToggleLabel().getText(), "TempControlClick");
				break;
			}
			case "off" -> {
				Fan.getInstance().setRealTempControlled(true);
				Debug.print(getTempControlToggleLabel().getText(), "TempControlClick");
				break;
			}
		}
		// To make sure that it doesn't fail or display different value
		if (Fan.getInstance().isTempControlled()) {
			getTempControlToggleLabel().setText("ON");
		} else {
			getTempControlToggleLabel().setText("OFF");
		}
		Debug.print(Fan.getInstance().isTempControlled(), "Fan: isTempControlled");
	}



	private void onSpeedSliderDrag() {
		Writer.getInstance().write(TransmitType.SPEED, getSpeedSlider().getValue());
		Debug.print(String.format("%.2f", getSpeedSlider().getValue()), "SpeedSliderDrag");
	}



	private void onOffsetSliderDrag() {
		Writer.getInstance().write(TransmitType.OFFSET, getOffsetSlider().getValue());
		Debug.print(String.format("%.2f", getOffsetSlider().getValue()), "OffsetSliderDrag");
	}



	public Label getTempControlToggleLabel() {
		return tempControlToggleLabel;
	}



	public Label getSpeedValueLabel() {
		return speedValueLabel;
	}



	public Slider getSpeedSlider() {
		return speedSlider;
	}



	public Label getSpeedLabel() {
		return speedLabel;
	}



	public Label getOffsetValueLabel() {
		return offsetValueLabel;
	}



	public Slider getOffsetSlider() {
		return offsetSlider;
	}



	public Label getOffsetLabel() {
		return offsetLabel;
	}
}
