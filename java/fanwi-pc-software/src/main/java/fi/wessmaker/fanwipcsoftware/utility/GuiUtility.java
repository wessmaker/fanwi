package fi.wessmaker.fanwipcsoftware.utility;

import javafx.scene.Node;

public class GuiUtility {

	static void setStyleClass(Node node, StyleClassType StyleClassType) {
		node.getStyleClass().addAll(StyleClassType.getStyleClassName());
	}
}
