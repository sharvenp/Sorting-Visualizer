package controllers;

import algorithms.CurrentSortStratergy;
import algorithms.NullSort;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Handles the SortButton action.
 * 
 * @author sharvenp
 *
 */
public class StopButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent e) {
		if (CurrentSortStratergy.getInstance().getCurrentStratergy().getClass() != NullSort.class) {
			CurrentSortStratergy.getInstance().getCurrentStratergy().stopSorting();
		}
	}

}
