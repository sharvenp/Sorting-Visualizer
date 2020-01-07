package utils;

import java.util.ArrayList;

public class Observable {

	ArrayList<Observer> observers = new ArrayList<>();
	
	public void notifyObservers() {
		for (Observer o : this.observers) {
			o.update(this);
		}
	}
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
}
