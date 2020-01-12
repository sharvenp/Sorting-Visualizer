package controllers;

import algorithms.CurrentSortStratergy;
import algorithms.SortStratergy;
import algorithms.SortStratergyFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import main.CanvasPanel;
import utils.AlertBox;
import utils.ArrayGenerator;

/**
 * Handles the SortButton action.
 * 
 * @author sharvenp
 *
 */
public class SortButtonHandler implements EventHandler<ActionEvent> {

	private CanvasPanel canvasPanel;
	private ComboBox<String> sortingAlgorithm;
	private TextField arraySizeInput;
	private Slider delayInput;
	
	public SortButtonHandler(CanvasPanel canvasPanel, ComboBox<String> sortingAlgorithm, TextField arraySize, Slider delayInput) {
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
		
		long delay = (long) (this.delayInput.getValue());
		
		if (CurrentSortStratergy.getInstance().getCurrentStratergy() == null) 
			SortStratergyFactory.setCurrentStratergy(selectedAlgoritm);
		
		if (size != 0 && CurrentSortStratergy.getInstance().getCurrentStratergy() != null && 
				CurrentSortStratergy.getInstance().getCurrentStratergy().getSortStatus() != 1) {

			if (SortStratergy.sortingArray == null || CurrentSortStratergy.getInstance().getCurrentStratergy().getSortStatus() == 2)
				ArrayGenerator.generateShuffledArray(size);
			
			SortStratergyFactory.setCurrentStratergy(selectedAlgoritm);
			final SortStratergy sortStratergy = CurrentSortStratergy.getInstance().getCurrentStratergy();
			sortStratergy.setDelay(delay);
			sortStratergy.setPanel(this.canvasPanel);
			
			// Run sorting on another thread.
			
			Runnable task = new Runnable() {
				@Override
				public void run() {
					sortStratergy.runAlgorithm();
				}
			};
			
	        Thread backgroundThread = new Thread(task);
	        backgroundThread.setDaemon(true);
	        backgroundThread.start();
			
		}
	}
}
