package stratergies;

import utils.DelayCreator;
import utils.Observable;

import java.util.Random;

import javafx.application.Platform;


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
	
	public double[] getArray() {
		return this.sortingArray;
	}
	
	public int getSortStatus() {
		return this.sortStatus;
	}
	
	public void runAlgorithm() {
		this.sortStatus = 1;
		this.sort();
		this.sortStatus = 2;
		this.notifyCanvas();
	}
	
	public void notifyCanvas() {
		Platform.runLater(new Runnable() 
        {
            @Override
            public void run() 
            {
            	notifyObservers();	
            }
        });
			
		DelayCreator.delay(this.delay);
	}
	
	public abstract void sort();
}
