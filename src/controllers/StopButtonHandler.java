package controllers;

import algorithms.CurrentSortStratergy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StopButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent e) {
		if (CurrentSortStratergy.getInstance().getCurrentStratergy() != null) {
			CurrentSortStratergy.getInstance().getCurrentStratergy().stopSorting();
		}
	}

}
