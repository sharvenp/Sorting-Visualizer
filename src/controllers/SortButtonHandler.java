package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.SortingModel;
import stratergies.SortStratergy;
import stratergies.SortStratergyFactory;
import utils.AlertBox;

public class SortButtonHandler implements EventHandler<ActionEvent> {

	private SortingModel model;
	private ComboBox<String> sortingAlgorithm;
	private TextField arraySizeInput;
	private TextField delayInput;
	
	public SortButtonHandler(SortingModel model, ComboBox<String> sortingAlgorithm, TextField arraySize, TextField delayInput) {
		this.model = model;
		
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
		}
		
		long delay = 0;
		
		try {
			delay = Long.parseLong(this.delayInput.getText());
		} catch (Exception exception) {
			AlertBox.showAlert("Invalid Input", "", "Invalid input for the delay.", AlertBox.errorType());
		}
		
		SortStratergy sortStratergy = SortStratergyFactory.getStratergy(selectedAlgoritm);

		if (size != 0 && sortStratergy != null) {
			sortStratergy.setDelay(delay);
			sortStratergy.generateShuffledArray(size);
			
			sortStratergy.addObserver(this.model);
			Thread t = new Thread(sortStratergy);
	        t.start();
		}
	}
}
