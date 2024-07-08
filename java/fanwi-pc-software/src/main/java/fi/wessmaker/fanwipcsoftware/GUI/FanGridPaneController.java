package fi.wessmaker.fanwipcsoftware.GUI;

import fi.wessmaker.fanwipcsoftware.FanwiApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class FanGridPaneController implements Initializable {

	@FXML
	private VBox controlContainer;

	@FXML
	private GridPane controlPane1;

	@FXML
	private GridPane controlPane2;

	@FXML
	private GridPane controlPane3;

	@FXML
	private GridPane controlPane4;

	@FXML
	private GridPane controlPane5;

	@FXML
	private GridPane fanGridPane;

	@FXML
	private Label offsetLabel;

	@FXML
	private Slider offsetSlider;

	@FXML
	private TextField offsetStatusField;

	@FXML
	private Label powerButton;

	@FXML
	private Label powerLabel;

	@FXML
	private Label powerStatusLabel;

	@FXML
	private Label resetButton;

	@FXML
	private Label resetLabel;

	@FXML
	private Label resetStatusLabel;

	@FXML
	private Label speedLabel;

	@FXML
	private Slider speedSlider;

	@FXML
	private TextField speedStatusField;

	@FXML
	private Label tempDrivenButton;

	@FXML
	private Label tempDrivenLabel;

	@FXML
	private Label tempDrivenStatusLabel;


	Label testLabel;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
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
			fanGridPane.add(fanImageView, 0, 0);
			fanGridPane.getStylesheets()
					.add(String.valueOf(FanwiApplication.class.getResource("stylesheet/fan-block.css")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return fanGridPane;
	}
}