package controllers;

import algorithms.CurrentSortStratergy;
import algorithms.SortStratergy;
import algorithms.SortStratergyFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.CanvasPanel;
import utils.AlertBox;
import utils.ArrayGenerator;

/**
 * Handles the GenerateButton action.
 * 
 * @author sharvenp
 *
 */
public class GenerateButtonHandler implements EventHandler<ActionEvent> {

	CanvasPanel panel;
	private ComboBox<String> sortingAlgorithm;
	private TextField arraySizeInput;
	
	public GenerateButtonHandler(CanvasPanel panel, ComboBox<String> sortingAlgorithm, TextField arraySize) {
		this.panel = panel;
		this.sortingAlgorithm = sortingAlgorithm;
		this.arraySizeInput = arraySize;
	}
	
	@Override
	public void handle(ActionEvent e) {
		
		String selectedAlgoritm = this.sortingAlgorithm.getValue();
		
		int size = 0;
		
		try {
			size = Integer.parseInt(this.arraySizeInput.getText());
			int a = 1 / size; // Zero check
		} catch (Exception exception) {
			AlertBox.showAlert("Invalid Input", "", "Invalid input for the array size.", AlertBox.errorType());
			return;
		}
		
		
		if (CurrentSortStratergy.getInstance().getCurrentStratergy() == null) 
			SortStratergyFactory.setCurrentStratergy(selectedAlgoritm);
		
		if (size != 0 && CurrentSortStratergy.getInstance().getCurrentStratergy() != null && 
				CurrentSortStratergy.getInstance().getCurrentStratergy().getSortStatus() != 1) {

			SortStratergyFactory.setCurrentStratergy(selectedAlgoritm);
			final SortStratergy sortStratergy = CurrentSortStratergy.getInstance().getCurrentStratergy();
			ArrayGenerator.generateShuffledArray(size);
			sortStratergy.setPanel(this.panel);
		}
		
	}

}
