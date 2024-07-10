package fi.wessmaker.fanwipcsoftware.utility;

import javafx.scene.Node;

public class GuiUtility {

	public static void setStyleClass(Node node, StyleClassType StyleClassType) {
		node.getStyleClass().addAll(StyleClassType.getStyleClassName());
	}



	public static void removeStyleClass(Node node, StyleClassType StyleClassType) {
		node.getStyleClass().removeAll(StyleClassType.getStyleClassName());
	}



	public static void enableHoverable(Node node) {
		node.getStyleClass().addAll(StyleClassType.HOVERABLE.getStyleClassName());
	}



	public static void disableHoverable(Node node) {
		node.getStyleClass().removeAll(StyleClassType.HOVERABLE.getStyleClassName());
	}



	public static void setStatusStylingClass(Node node, StyleClassType type) {
		switch (type) {
			case ENABLED_STYLE:
				break;
			case DISABLED_STYLE:
				break;
			case WAITING_STYLE:
				break;
			default:
				return; // This prevents accidentally deletion in case that type is doesn't match
		}
		for (int i = 0; i > node.getStyleClass().toArray().length; i++) {
			switch (node.getStyleClass().get(i)) {
				case "enabled_styling":
					removeStyleClass(node, StyleClassType.ENABLED_STYLE);
					break;
				case "disabled_styling":
					removeStyleClass(node, StyleClassType.DISABLED_STYLE);
					break;
				case "waiting_styling":
					removeStyleClass(node, StyleClassType.WAITING_STYLE);
					break;
			}
		}
		setStyleClass(node, type);
	}
}