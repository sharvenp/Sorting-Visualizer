package stratergies;

import utils.Observable;
import java.util.Random;

public abstract class SortStratergy extends Observable {

	private double[] sortingArray;
	private double delay;
	
	public void generateShuffledArray(int size) {
		
		this.sortingArray = new double[size];
		
		for (int i = 0; i < sortingArray.length; i++) {
			sortingArray[i] = i+1;
		}
		
		Random r = new Random();
		
		for (int shuffleCycles = 0; shuffleCycles < 10000; shuffleCycles++) {
			int randomIndex1 = r.nextInt(this.sortingArray.length);
			int randomIndex2 = r.nextInt(this.sortingArray.length);
			double temp = this.sortingArray[randomIndex1];
			this.sortingArray[randomIndex1] = this.sortingArray[randomIndex2];
			this.sortingArray[randomIndex2] = temp;
		}
	}
	
	public void setDelay(double delay) {
		this.delay = delay;
	}
	
	public double[] getArray() {
		return this.sortingArray;
	}
	
	public abstract void sort();
}