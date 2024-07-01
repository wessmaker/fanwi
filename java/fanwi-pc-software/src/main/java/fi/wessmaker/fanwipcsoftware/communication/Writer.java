package fi.wessmaker.fanwipcsoftware.communication;

public class Writer {
	private boolean wifiConnection;
	private boolean bluetoothConnection;
	private boolean serialConnection;
	
	
	private static Writer writer;
	
	
	//This might feel reduntant but if there is later need for second fan, then only needs some refactoring
	public static Writer getInstance(){
		if(writer == null){
			writer = new Writer();
			return writer;
		}
		return writer;
	}
	
	
	private void sendData(byte[] data){
	
	}
	
	
	
	//Generally writing byte[]
	public void write(TransmitType messageType){
		byte[] data = messageType.getValue().toLowerCase().getBytes();
		sendData(data);
	}
	
	//This will take care of sending numeric values (int, double, float), those just have to be casted accordingly
	public void write(TransmitType messageType, double valueToSend){
		String dataString = messageType.getValue().toLowerCase() + String.format("%.2f", valueToSend);
		byte[] data = dataString.getBytes();
		sendData(data);
	}
	
	//bool values
	public void write(TransmitType messageType, boolean boolValue){
		String dataString = messageType.getValue().toLowerCase() + boolValue;
		byte[] data = dataString.getBytes();
	}
	
	
}
