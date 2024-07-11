package fi.wessmaker.fanwipcsoftware.GUI.infopanel;

/**
 * Stores different infoinstance types
 * <p>
 * Add new field to this enum
 * -> automaticly create new infoinstance in GUI
 * <p\>
 */
public enum InfoInstanceType {
	CONNECTION("Connection", false, true),
	OFFSET("Offset", 0, false),
	TEMPERATURE_DRIVEN("Temp driven", false, true),
	TEMPERATURE("Temp", 0, false),
	SPEED("Speed", 0, false),
	SPINNING("Spinning", false, true);

	
	private final String text;

	private Object defaultValue;

	private boolean booleanValue;


	InfoInstanceType(String text, Object value, boolean booleanValue) {
		this.text = text;
		this.defaultValue = value;
		this.booleanValue = booleanValue;
	};


	public String getText() {
		return this.text;
	}



	public Object getDefaultValue() {
		return this.defaultValue;
	}



	public boolean isBooleanValue() {
		return this.booleanValue;
	}
}
