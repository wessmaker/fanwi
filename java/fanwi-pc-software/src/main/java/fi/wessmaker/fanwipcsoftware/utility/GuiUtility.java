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


	/**
	 *  Checks for predefined coloring style if those are set and removes if found.
	 * <p>
	 * Sets selected coloring style after removal
	 * <p>
	 * Doesn't affect other styleclasses
	 * <p>
	 * Sets predefined styleclass to node
	 * @return used defined styleClassType -> true <p>
	 * used wrong styleClassType -> false
	 */
	public static void setStatusColoring(Node node, StyleClassType styleClassType){
		for (int i = 0; i < node.getStyleClass().size(); i++){
			switch (node.getStyleClass().get(i)) {
				case StyleClassType.ENABLED_STYLE_STYLE.getStyleClassName():
					removeStyleClass(node, StyleClassType.ENABLED_STYLE);
					break;
				case StyleClassType.DISABLED_STYLE.getStyleClassName():
					removeStyleClass(node, StyleClassType.DISABLED_STYLE);
					break;
				case: StyleClassType.WAITING_STYLE.getStyleClassName()
					removeStyleClass(node, StyleClassType.WAITING_STYLE);
					break;
			}
		}
		switch (styleClassType) {
			case StyleClassType.ENABLED_STYLE_STYLE.getStyleClassName():
				setStyleClass(node, StyleClassType.ENABLED_STYLE);
				return true;
				break;
			case StyleClassType.DISABLED_STYLE.getStyleClassName():
				setStyleClass(node, StyleClassType.DISABLED_STYLE);
				return true;
				break;
			case: StyleClassType.WAITING_STYLE.getStyleClassName()
				setStyleClass(node, StyleClassType.WAITING_STYLE);
				return true;
				break;
			default:
				return false;
				break;
		}
	}
}