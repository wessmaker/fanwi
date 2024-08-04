module fi.wessmaker.fanwipcsoftware {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires transitive javafx.graphics;    //This had to be added for visual studio
	

	opens fi.wessmaker.fanwipcsoftware to javafx.fxml;
    opens fi.wessmaker.fanwipcsoftware.GUI to javafx.fxml;
    opens fi.wessmaker.fanwipcsoftware.GUI.infopanel to java.fxml;
    exports fi.wessmaker.fanwipcsoftware.utility;
    exports fi.wessmaker.fanwipcsoftware;
    exports fi.wessmaker.fanwipcsoftware.GUI;
    exports fi.wessmaker.fanwipcsoftware.GUI.infopanel;


        
    
}