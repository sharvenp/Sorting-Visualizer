package algorithms;

import utils.DelayCreator;
import utils.ToneGenerator;
import javafx.application.Platform;
import main.CanvasPanel;


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
	
	public void runAlgorithm() {
		this.sortStatus = 1;
		this.sort();
		this.stopSorting();
		this.updateCanvas(0);
	}
	
	protected void updateCanvas(long delay) {
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
	
	public abstract void sort();
	
	public abstract void renderArray();
	
}
