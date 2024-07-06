package fi.wessmaker.fanwipcsoftware.GUI;

import fi.wessmaker.fanwipcsoftware.FanwiApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FanGridPaneController implements Initializable {

	@FXML
	private HBox controlBox1;

	@FXML
	private HBox controlBox2;

	@FXML
	private HBox controlBox3;

	@FXML
	private HBox controlBox4;

	@FXML
	private HBox controlBox5;

	@FXML
	private VBox controlContainer;

	@FXML
	private GridPane fanGridPane;


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
			fanGridPane.add(fanImageView, 1, 0);
			fanGridPane.getStylesheets()
					.add(String.valueOf(FanwiApplication.class.getResource("stylesheet/fan-block.css")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return fanGridPane;
	}
}