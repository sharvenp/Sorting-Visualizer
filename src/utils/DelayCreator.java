package utils;

public class DelayCreator {

	/**
	 * Create a delay with the given miliseconds.
	 * 
	 * @param milis duration of the delay.
	 */
	public static void delay(long milis) {
		try {
		    Thread.sleep(milis);
		}
		catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
}
