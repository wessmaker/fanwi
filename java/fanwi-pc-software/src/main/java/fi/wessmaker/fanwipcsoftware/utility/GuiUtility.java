package fi.wessmaker.fanwipcsoftware.utility;

import javafx.scene.Node;

public class GuiUtility {

	public static void setStyleClass(Node node, StyleClassType StyleClassType) {
		node.getStyleClass().addAll(StyleClassType.getStyleClassName());
	}



	public static void removeStyleClass(Node node, StyleClassType StyleClassType) {
		node.getStyleClass().removeAll(StyleClassType.getStyleClassName());
	}
}
