package fi.wessmaker.fanwipcsoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FanwiApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(FanwiApplication.class.getResource("fxml/main-window.fxml"));

        System.out.println("FMXLOADER: ");
        System.out.println(fxmlLoader);
        
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
        scene.getStylesheets().add(FanwiApplication.class.getResource("stylesheet/main-window.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    public static void main(String[] args){
        
        System.out.println("PATH: ");
        System.out.println(FanwiApplication.class.getResource("fxml/main-window.fxml"));
        
        launch();
        
    }
    
}
