package fi.wessmaker.fanwipcsoftware.utility;

public enum StyleClassType {

	HOVERABLE("hoverable"), 
	ENABLED_STYLE("enabled_style"), 
	DISABLED_STYLE("disabled_style"), 
	WAITING_STYLE("waiting_style");


	final String styleClassName;


	StyleClassType(String name) {
		this.styleClassName = name;
	};



	public String getStyleClassName() {
		return this.styleClassName;
	}
}
