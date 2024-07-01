package fi.wessmaker.fanwipcsoftware.communication;

public enum TransmitType {
	
	//Basic types
	START("STR"),
	STOP("stp"),
	SPEED("spd"),
	TEMPERATURE_CONTROL("tmpctrl"),
	OFFSET("ofs");
	
	
	private final String value;
	
	
	TransmitType(String value) {
		this.value = value;
	}
	
	
	public String getValue(){
		return this.value;
	}
}
