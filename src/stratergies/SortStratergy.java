package stratergies;

import utils.Observable;
import java.util.Random;

import main.Settings;

public abstract class SortStratergy extends Observable implements Runnable {

	protected double[] sortingArray;
	protected long delay;
	
	public void generateShuffledArray(int size) {
		
		this.sortingArray = new double[size];
		
		for (int i = 0; i < this.sortingArray.length; i++) {
			sortingArray[i] = i+1;
		}
		
		Random r = new Random();
		
		for (int i = 0; i < this.sortingArray.length; i++) {
			int ri = r.nextInt(this.sortingArray.length);
			double temp = this.sortingArray[ri];
			this.sortingArray[ri] = this.sortingArray[i];
			this.sortingArray[i] = temp;
		}
	}
	
	public void setDelay(long delay) {
		this.delay = delay;
	}
	
	public double[] getArray() {
		return this.sortingArray;
	}
}
