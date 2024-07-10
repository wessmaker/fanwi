package fi.wessmaker.fanwipcsoftware.utility;

public enum StyleClassType {

	HOVERABLE("hoverable");


	final String styleClassName;


	private StyleClassType(String styleClassName) {
		this.styleClassName = styleClassName;
	}



	public String getStyleClassName() {
		return this.styleClassName;
	}
}
