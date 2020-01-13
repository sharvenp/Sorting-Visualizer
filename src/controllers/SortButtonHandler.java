package controllers;

import algorithms.CurrentSortStratergy;
import algorithms.NullSort;
import algorithms.SortStratergy;
import algorithms.SortStratergyFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import main.CanvasPanel;
import utils.AlertBox;
import utils.ArrayGenerator;
import utils.DelayCreator;

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
	private CheckBox showGenerationBox;
	
	public SortButtonHandler(CanvasPanel canvasPanel, ComboBox<String> sortingAlgorithm, TextField arraySize, Slider delayInput, CheckBox showGenerationBox) {
		this.canvasPanel = canvasPanel;
		
		this.sortingAlgorithm = sortingAlgorithm;
		this.arraySizeInput = arraySize;
		this.delayInput = delayInput;
		this.showGenerationBox = showGenerationBox;
	}
	
	@Override
	public void handle(ActionEvent e) {

		if (!ArrayGenerator.isGenerating) {
			
			String selectedAlgoritm = this.sortingAlgorithm.getValue();
			
			final int size;
			
			try {
				size = Integer.parseInt(this.arraySizeInput.getText());
				@SuppressWarnings("unused")
				int a = 1 / size; // Zero check
			} catch (Exception exception) {
				AlertBox.showAlert("Invalid Input", "", "Invalid input for the array size.", AlertBox.errorType());
				return;
			}
			
			long delay = (long) (this.delayInput.getValue());
			
			if (CurrentSortStratergy.getInstance().getCurrentStratergy().getClass() == NullSort.class) 
				SortStratergyFactory.setCurrentStratergy(selectedAlgoritm);
			
			if (size != 0 && CurrentSortStratergy.getInstance().getCurrentStratergy().getClass() != NullSort.class && 
					CurrentSortStratergy.getInstance().getCurrentStratergy().getSortStatus() != 1) {
	
				if (SortStratergy.sortingArray == null || CurrentSortStratergy.getInstance().getCurrentStratergy().getSortStatus() == 2) {
					SortStratergy stratergy = new NullSort();
					stratergy.setPanel(this.canvasPanel);
					CurrentSortStratergy.getInstance().setStratergy(stratergy);
					ArrayGenerator.initArray(size);
					
					
					if (this.showGenerationBox.isSelected()) {
						// Run array generation on another thread to render it on the canvas
						Runnable task = new Runnable() {
							@Override
							public void run() {
								ArrayGenerator.generateShuffledArray(size, showGenerationBox.isSelected());
								DelayCreator.delay(1000);
								handle(e);
							}
						};
						
				        Thread backgroundThread = new Thread(task);
				        backgroundThread.setDaemon(true);
				        backgroundThread.start();
				        
				        return;
					} else {
						ArrayGenerator.generateShuffledArray(size, this.showGenerationBox.isSelected());
					}
				} 
				
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
}
