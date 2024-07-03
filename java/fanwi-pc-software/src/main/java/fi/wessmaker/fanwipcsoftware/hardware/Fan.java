package fi.wessmaker.fanwipcsoftware.hardware;

import fi.wessmaker.fanwipcsoftware.communication.debug.Debug;

public class Fan {

	private int speed;

	private int offset;

	private double temperature;

	private int realSpeed;

	private int realOffset;

	private boolean spinning;

	private boolean tempControlled;

	private boolean realSpinning;

	private boolean realTempControlled;

	private static Fan fan;


	private Fan(int speed, int offset, double temperature, int realSpeed, int realOffset, boolean spinning, boolean tempControlled, boolean realSpinning, boolean realTempControlled) {
		this.speed = speed;
		this.offset = offset;
		this.temperature = temperature;
		this.spinning = spinning;
		this.tempControlled = tempControlled;
		this.realSpeed = realSpeed;
		this.realOffset = realOffset;
		this.realSpinning = realSpinning;
		this.realTempControlled = realTempControlled;
	}



	// Singleton
	public static Fan getInstance() {
		if (fan == null) {
			fan = new Fan(-1, -1, -1, -1, -1, false, false, false, false);
			Debug.print(fan, "FanReturned");
			return fan;
		} else {
			Debug.print(fan, "FanReturned");
			return fan;
		}
	}
	// TODO make use of return keyword so that setters can return if they made it or
	// not



	// These setters are for setting desirable values
	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public void setOffset(int offset) {
		this.offset = offset;
	}



	public void setSpinning(boolean spinning) {
		this.spinning = spinning;
	}



	public void setTempControlled(boolean tempControlled) {
		this.tempControlled = tempControlled;
	}



	// These are for real data
	public void setRealSpeed(int realSpeed) {
		this.realSpeed = realSpeed;
	}



	public void setRealOffset(int realOffset) {
		this.realOffset = realOffset;
	}



	public void setRealSpinning(boolean realSpinning) {
		this.realSpinning = realSpinning;
	}



	public void setRealTempControlled(boolean realTempControlled) {
		this.realTempControlled = realTempControlled;
	}



	// Get desired value data
	public int getSpeed() {
		return speed;
	}



	public int getOffset() {
		return offset;
	}
	
	public double getTemeprature(){
		return temperature;
	}

	public boolean isSpinning() {
		return spinning;
	}



	public boolean isTempControlled() {
		return tempControlled;
	}



	// Get real data
	public int getRealSpeed() {
		return realSpeed;
	}



	public int getRealOffset() {
		return realOffset;
	}



	public boolean isRealSpinning() {
		return realSpinning;
	}



	public boolean isRealTempControlled() {
		return realTempControlled;
	}
}
