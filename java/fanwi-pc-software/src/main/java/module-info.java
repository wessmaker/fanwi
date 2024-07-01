module fi.wessmaker.fanwipcsoftware {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	
	
	opens fi.wessmaker.fanwipcsoftware to javafx.fxml;
    opens fi.wessmaker.fanwipcsoftware.GUI to javafx.fxml;
    exports fi.wessmaker.fanwipcsoftware;
    exports fi.wessmaker.fanwipcsoftware.GUI;
}