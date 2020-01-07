package controllers;

import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.CanvasPanel;
import stratergies.CurrentSortStratergy;
import stratergies.SortStratergy;
import stratergies.SortStratergyFactory;
import utils.AlertBox;

public class SortButtonHandler implements EventHandler<ActionEvent> {

	private CanvasPanel canvasPanel;
	private ComboBox<String> sortingAlgorithm;
	private TextField arraySizeInput;
	private TextField delayInput;
	
	public SortButtonHandler(CanvasPanel canvasPanel, ComboBox<String> sortingAlgorithm, TextField arraySize, TextField delayInput) {
		this.canvasPanel = canvasPanel;
		
		this.sortingAlgorithm = sortingAlgorithm;
		this.arraySizeInput = arraySize;
		this.delayInput = delayInput;
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
		
		long delay = 0;
		
		try {
			delay = Long.parseLong(this.delayInput.getText());
		} catch (Exception exception) {
			AlertBox.showAlert("Invalid Input", "", "Invalid input for the delay.", AlertBox.errorType());
			return;
		}
		
		if (CurrentSortStratergy.getInstance().getCurrentStratergy() == null) 
			SortStratergyFactory.setCurrentStratergy(selectedAlgoritm);
		
		if (size != 0 && CurrentSortStratergy.getInstance().getCurrentStratergy() != null && 
				CurrentSortStratergy.getInstance().getCurrentStratergy().getSortStatus() != 1) {

			SortStratergyFactory.setCurrentStratergy(selectedAlgoritm);
			SortStratergy sortStratergy = CurrentSortStratergy.getInstance().getCurrentStratergy();
			sortStratergy.setDelay(delay);
			sortStratergy.generateShuffledArray(size);
			
			sortStratergy.addObserver(this.canvasPanel);
			Thread t = new Thread(sortStratergy);
	        t.start();
		}
	}
}
