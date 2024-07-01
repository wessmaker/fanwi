package fi.wessmaker.fanwipcsoftware;

import fi.wessmaker.fanwipcsoftware.GUI.infopanel.InfoInstance;
import fi.wessmaker.fanwipcsoftware.communication.debug.Debug;
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
import fi.wessmaker.fanwipcsoftware.GUI.FanGridPaneController;

public class MainWindowController implements  Initializable{
    
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
    

    FanGridPaneController fanGridPaneController;
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Debug.setDebug(debugButton.isSelected());
        fanGridPaneController = new FanGridPaneController();
        fan1ContentGridPane.getChildren().add(fanGridPaneController.getFanGridPane());
        debugButton.setSelected(true);
       
       
       InfoInstance infoInstance = new InfoInstance("hello", "Hello");
       GridPane gridPane = infoInstance.getInstance();
       infoVBox.getChildren().add(gridPane);
       
       InfoInstance infoInstance2 = new InfoInstance("test2", "testingvalue");
       GridPane gridPane2 = infoInstance2.getInstance();
       infoVBox.getChildren().add(gridPane2);
        
    }
    
    
    @FXML
    void mouseClick(MouseEvent event) {
        debugButton.setOnMouseClicked(mouseClickEvent ->{
            if (debugButton.isSelected()){
                Debug.setDebug(true);
            }else {
                Debug.setDebug(false);
            }
        });
    }
}
