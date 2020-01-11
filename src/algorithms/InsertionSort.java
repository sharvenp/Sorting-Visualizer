package algorithms;

import javafx.scene.paint.Color;
import utils.Settings;

public class InsertionSort extends SortStratergy {

	private int currJ = -1;
	private int currI = -1;
	private int currJ1 = -1;
	
	@Override
	public void sort() {
	 int n = sortingArray.length; 
        for (int i = 1; i < n; ++i) { 
        	
        	if (this.sortStatus == 2)
        		return;
        	
        	this.currI = i;
        	
            double key = sortingArray[i]; 
            int j = i - 1; 
            
            this.currJ = j;
  
            while (j >= 0 && sortingArray[j] > key) { 
            	sortingArray[j + 1] = sortingArray[j]; 
                j = j - 1; 
                this.currJ = j;
                this.updateCanvas(this.delay);
            } 
            
            sortingArray[j + 1] = key; 
            this.currJ1 = j + 1;
            
            this.updateCanvas(this.delay);
        } 
	}

	@Override
	public void renderArray() {
		Color barColor = Color.rgb(255, 100, 100);
		
		if (this.getSortStatus() == 2) {
			barColor = Settings.sortedColor;
		}
		
		for (int i = 0; i < sortingArray.length; i++) {
			
			Color currColor = barColor;
			
			if (this.sortStatus != 2) {
				if (i == this.currJ) {
					currColor = Color.rgb(255, 100, 255);
				} else if (i == this.currI) {
					currColor = Color.rgb(100, 100, 255);
				} else if (i == this.currJ1) {
					currColor = Color.rgb(255, 255, 100);
				}
			}
			
			this.panel.renderRectangle(i, sortingArray[i], currColor);
		}
	}

}
