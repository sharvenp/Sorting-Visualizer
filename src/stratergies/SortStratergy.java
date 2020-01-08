package stratergies;

import utils.Observable;
import java.util.Random;

//public abstract class SortStratergy extends Observable implements Runnable {
public abstract class SortStratergy extends Observable {

	protected double[] sortingArray;
	protected long delay;
	protected int sortStatus = 0;
	
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
	
	public long getDelay() {
		return this.delay;
	}
	
	public double[] getArray() {
		return this.sortingArray;
	}
	
	public int getSortStatus() {
		return this.sortStatus;
	}
	
//	@Override
//	public void run() {
	public void runAlgorithm() {
		this.sortStatus = 1;
		this.sort();
		this.sortStatus = 2;
		this.notifyObservers();
	}
	
	public abstract void sort();
}
