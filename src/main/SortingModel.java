package main;

import stratergies.SortStratergy;
import utils.Observable;
import utils.Observer;

public class SortingModel extends Observable implements Observer {
	
	private double[] sortingArray;


	@Override
	public void update(Observable o) {
		this.sortingArray = ((SortStratergy) o).getArray();
		this.notifyObservers();
	}
	
	public double[] getArray() {
		return this.sortingArray;
	}
}
