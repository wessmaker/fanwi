package fi.wessmaker.fanwipcsoftware.GUI;

import fi.wessmaker.fanwipcsoftware.GUI.infopanel.InfoInstance;
import fi.wessmaker.fanwipcsoftware.GUI.infopanel.InfoInstanceController;
import fi.wessmaker.fanwipcsoftware.GUI.infopanel.InfoInstanceType;
import fi.wessmaker.fanwipcsoftware.communication.debug.Debug;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
    private VBox infoVBox;

    @FXML
    private ToggleButton debugButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Debug.setDebugging(debugButton.isSelected());
        InfoInstanceController infoInstanceController = new InfoInstanceController();
        infoInstanceController.initializeInfoPane(infoVBox);

        

        FanGridPaneController fanGridPaneController = new FanGridPaneController();
        contentGridPane.add(fanGridPaneController.getFanGridPane(), 1, 1);
        debugButton.setSelected(true);
    }



    @FXML
    void mouseClick(MouseEvent event) {
        debugButton.setOnMouseClicked(mouseClickEvent -> {
            Debug.setDebugging(debugButton.isArmed());
            System.out.println("Debugging: " + Debug.isDebugging());
        });
    }
}
