package fi.wessmaker.fanwipcsoftware.GUI.infopanel;

import java.util.ArrayList;

import javafx.scene.layout.VBox;

public class InfoInstanceController {

	private int infoInstanceCount;

	private ArrayList<InfoInstance> infoInstances = new ArrayList<>();


	public InfoInstanceController() {
	}



	public void initializeInfoPane(VBox vBox) {
		this.infoInstanceCount = 0;
		try {
			for (InfoInstanceType instance : InfoInstanceType.values()) {
				infoInstanceCount++;
				if (instance.isBooleanValue()) {
					infoInstances
							.add(new InfoInstance(instance.getText(), (boolean) instance.getDefaultValue(), instance));
				} else {
					infoInstances
							.add(new InfoInstance(instance.getText(), String.valueOf(instance.getDefaultValue()),
									instance));
				}
				vBox.getChildren().add(infoInstances.getLast().getNewInstance());
			}
		} catch (Exception e) {
		}
	} // TODO check if created instances count doesn't match with initial count and
		// then throw error



	public void setConnectionValue(boolean value) {
		getInfoInstanceByType(InfoInstanceType.CONNECTION).setValue(String.valueOf(value));
	}



	public void setSpinningValue(boolean value) {
		getInfoInstanceByType(InfoInstanceType.SPINNING).setValue(String.valueOf(value));
	}



	public void setTempDrivenValue(boolean value) {
		getInfoInstanceByType(InfoInstanceType.TEMPERATURE_DRIVEN).setValue(String.valueOf(value));
	}



	public void setSpeedValue(int value) {
		getInfoInstanceByType(InfoInstanceType.SPEED).setValue(String.valueOf(value));
	}



	public void setTempValue(int value) {
		getInfoInstanceByType(InfoInstanceType.TEMPERATURE).setValue(String.valueOf(value));
	}



	public void setOffsetValue(double value) {
		getInfoInstanceByType(InfoInstanceType.OFFSET).setValue(String.valueOf(value));
	}



	/**
	 * Searches infoInstances ArrayList for matching type and returns it if it's
	 * match
	 * 
	 * @return InfoInstance / null
	 */
	public InfoInstance getInfoInstanceByType(InfoInstanceType type) {
		for (InfoInstance instance : infoInstances) {
			if (instance.getInfoInstanceType() == type) {
				return instance;
			}
		}
		return null;
	}



	public int getInfoInstanceCount() {
		return this.infoInstanceCount;
	}
}
