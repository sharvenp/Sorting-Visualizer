package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.SortStratergy;
import main.SortStratergyFactory;
import main.SortingModel;

public class SortButtonHandler implements EventHandler<ActionEvent> {

	private SortingModel model;
	private String selectedAlgoritm;
	private int size;
	private double delay;
	
	public SortButtonHandler(SortingModel model, ComboBox<String> sortingAlgorithm, TextField arraySize, TextField delayInput) {
		this.model = model;
		
		this.selectedAlgoritm = sortingAlgorithm.getValue();
		this.size = Integer.parseInt(arraySize.getText());
		this.delay = Double.parseDouble(delayInput.getText());
	}
	
	@Override
	public void handle(ActionEvent e) {

		SortStratergy sortStratergy = SortStratergyFactory.getStratergy(this.selectedAlgoritm);
		sortStratergy.setDelay(delay);
		sortStratergy.generateArray(this.size);
	}

}
