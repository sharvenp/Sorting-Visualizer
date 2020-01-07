package utils;

public class DelayCreator {

	public static void delay(long milis) {
		try {
		    Thread.sleep(milis);
		}
		catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
}
