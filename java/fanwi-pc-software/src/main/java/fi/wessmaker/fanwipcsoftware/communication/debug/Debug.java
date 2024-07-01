package fi.wessmaker.fanwipcsoftware.communication.debug;

public class Debug {
	private static boolean debug = false;
	
	static char[] dividerList = {'*', '/', '-', '+'};
	static int dividerId = 0;
	
	
	private static void printDivider(){
		for (int i = 0; i < 40; i++){
			System.out.print(dividerList[dividerId]);
		}
		dividerId++;
		if (dividerId == 4) dividerId = 0;
	}
	
	
	public static void print(String customText){
		if (debug){
			System.out.println();
			printDivider();
			System.out.println("DEBUG:");
			System.out.println(customText);
		}
		
	}
	
	public static void print(Object value, String customText){
		if (debug){
			System.out.println();
			printDivider();
			System.out.println();
			System.out.println("DEBUG:");
			System.out.println(
					value.toString() +
					", " +
					customText
			);
		}
	}
	
	public static void setDebug(boolean debugging){
		debug = debugging;
		System.out.println("Debugging: " + debugging);
	}
}
