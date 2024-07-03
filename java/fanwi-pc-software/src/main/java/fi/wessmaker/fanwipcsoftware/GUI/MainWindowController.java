package fi.wessmaker.fanwipcsoftware.GUI;

import fi.wessmaker.fanwipcsoftware.GUI.infopanel.InfoInstance;
import fi.wessmaker.fanwipcsoftware.communication.debug.Debug;
import fi.wessmaker.fanwipcsoftware.hardware.Fan;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController implements Initializable {

    @FXML
    private GridPane contentGridPane;

    @FXML
    private GridPane leftLowerGridPane;

    @FXML
    private MenuBar menuBar;
    
    @FXML
    private GridPane fan1ContentGridPane;

    @FXML
    private VBox infoVBox;

    @FXML
    private ToggleButton debugButton;

    private FanGridPaneController fanGridPaneController;
    private int instanceCount = 3;

    InfoInstance[] infoInstances;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Debug.setDebug(debugButton.isSelected());
        fanGridPaneController = new FanGridPaneController();
        fan1ContentGridPane.getChildren().add(fanGridPaneController.getFanGridPane());
        debugButton.setSelected(true);

        infoInstances = new InfoInstance[instanceCount];


        //TODO THESE DONT SHOW UP CORRECTLY IN GUI
        infoInstances[0] = new InfoInstance("Temperature", String.valueOf(Fan.getInstance().getTemeprature()));
        infoInstances[1] = new InfoInstance("Speed", String.valueOf(Fan.getInstance().getRealSpeed()));
        infoInstances[2] = new InfoInstance("offset", String.valueOf(Fan.getInstance().getOffset()));
        
        for(int i = 0; i < instanceCount; i++){
            infoVBox.getChildren().add(infoInstances[i].getInstance());
        }

        

    }



    @FXML
    void mouseClick(MouseEvent event) {
        debugButton.setOnMouseClicked(mouseClickEvent -> {
            if (debugButton.isSelected()) {
                Debug.setDebug(true);
            } else {
                Debug.setDebug(false);
            }
        });
    }
}
