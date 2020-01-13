package algorithms;

import utils.DelayCreator;
import utils.Settings;
import utils.ToneGenerator;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import main.CanvasPanel;

/**
 * Represents a sorting algorithm. 
 * 
 * @author sharvenp
 *
 */
public abstract class SortStratergy {

	public static double[] sortingArray = null;
	
	protected long delay;
	protected int sortStatus = 0;
	protected CanvasPanel panel;
	
	public void setPanel(CanvasPanel panel) {
		this.panel = panel;
		this.updateCanvas(0);
	}
	
	public void setDelay(long delay) {
		this.delay = delay;
	}
	
	public int getSortStatus() {
		return this.sortStatus;
	}
	
	/**
	 * Run the sorting algorithm.
	 */
	public void runAlgorithm() {
		this.sortStatus = 1;
		this.sort();
		this.stopSorting();
		this.updateCanvas(0);
	}
	
	public void updateCanvas(long delay) {
		
		// Run render code after all GUI code has run.
		Platform.runLater(new Runnable() 
        {
            @Override
            public void run() 
            {
            	panel.clearCanvas();
            	renderArray();
            }
        });
			
		DelayCreator.delay(delay);
	}
	
	public void stopSorting() {
		this.sortStatus = 2;
	}
	
	/**
	 * Sort the array based on the stratergy.
	 */
	public abstract void sort();
	
	/**
	 * Render the array on the canvas.
	 */
	public void renderArray() {
		Color barColor = Settings.defaultColor;
		
		if (this.sortStatus == 2) {
			barColor = Settings.sortedColor;
		}
		
		for (int i = 0; i < sortingArray.length; i++) {
		
			this.panel.renderRectangle(i, sortingArray[i], barColor);
		}
	}
	
}
