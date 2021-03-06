package controllers;


import algorithms.CurrentSortStratergy;
import algorithms.NullSort;
import algorithms.SortStratergy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
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

	private CanvasPanel panel;
	private TextField arraySizeInput;
	private CheckBox showGenerationBox;
	
	public GenerateButtonHandler(CanvasPanel panel, TextField arraySize, CheckBox showGenerationBox) {
		this.panel = panel;
		this.arraySizeInput = arraySize;
		this.showGenerationBox = showGenerationBox;
	}
	
	@Override
	public void handle(ActionEvent e) {
		
		final int size;
		
		try {
			size = Integer.parseInt(this.arraySizeInput.getText());
			@SuppressWarnings("unused")
			int a = 1 / size; // Zero check
		} catch (Exception exception) {
			AlertBox.showAlert("Invalid Input", "", "Invalid input for the array size.", AlertBox.errorType());
			return;
		}
		
		SortStratergy stratergy = new NullSort();
		stratergy.setPanel(this.panel);
		CurrentSortStratergy.getInstance().setStratergy(stratergy);
		ArrayGenerator.initArray(size);
		
		if (this.showGenerationBox.isSelected()) {
			// Run array generation on another thread to render it on the canvas
			Runnable task = new Runnable() {
				@Override
				public void run() {
					ArrayGenerator.generateShuffledArray(size, showGenerationBox.isSelected());
				}
			};
			
	        Thread backgroundThread = new Thread(task);
	        backgroundThread.setDaemon(true);
	        backgroundThread.start();
		} else {
			ArrayGenerator.generateShuffledArray(size, showGenerationBox.isSelected());
		}
		
	}

}
