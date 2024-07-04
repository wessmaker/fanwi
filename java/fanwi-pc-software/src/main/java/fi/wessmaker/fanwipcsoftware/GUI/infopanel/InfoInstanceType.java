package fi.wessmaker.fanwipcsoftware.GUI.infopanel;

import java.security.cert.TrustAnchor;

/**
 * Stores different infoinstance types
 * <p>
 * Add new field to this enum
 * -> automaticly create new infoinstance in GUI
 * <p\>
 */
public enum InfoInstanceType {

	SPEED("Speed", -1, false),
	TEMPERATURE("Temp", -1f, false),
	OFFSET("Offset", -1, false),
	CONNECTION("Connection",false, true),
	TEMPERATURE_DRIVEN("Temp driven", false, true),
	SPINNING("Spinning", false, true);


	private final String text;

	private Object defaultValue;

	private boolean booleanValue;


	InfoInstanceType(String text, Object defaultValue, boolean booleanValue) {
		this.text = text;
		this.defaultValue = defaultValue;
		this.booleanValue = booleanValue;
	};



	public String getText() {
		return this.text;
	}



	public Object getDefaultValue() {
		return this.defaultValue;
	}



	public Boolean isBooleanValue() {
		return this.booleanValue;
	}
}
