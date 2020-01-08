package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import stratergies.CurrentSortStratergy;

public class StopButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent e) {
		if (CurrentSortStratergy.getInstance().getCurrentStratergy() != null) {
			CurrentSortStratergy.getInstance().getCurrentStratergy().stopSorting();
		}
	}

}
