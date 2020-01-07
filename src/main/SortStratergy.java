package main;

import utils.Observable;

public abstract class SortStratergy extends Observable {

	private double[] sortingArray;
	private double delay;
	
	public void generateShuffledArray(int size) {
		
		this.sortingArray = new double[size];
		
		for (int i = 0; i < sortingArray.length; i++) {
			sortingArray[i] = i+1;
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
