package fi.wessmaker.fanwipcsoftware.utility;

public enum StyleClassType {

	HOVERABLE("hoverable"),
	ENABLED_STYLE("enabled_style"),
	DISABLED_STYLE("disabled_style"),
	WAITING_STYLE("waiting_style");


	final String styleClassName;


	private StyleClassType(String styleClassName) {
		this.styleClassName = styleClassName;
	}



	public String getStyleClassName() {
		return this.styleClassName;
	}
}
