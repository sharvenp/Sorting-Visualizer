package algorithms;

import javafx.scene.paint.Color;
import utils.Settings;

public class SelectionSort extends SortStratergy {

	private int minI = -1;
	private int currI = -1;
	private int findMinI = -1;
	
	@Override
	public void sort() {
		int n = sortingArray.length; 
		  
        for (int i = 0; i < n-1; i++) 
        { 
        	if (this.sortStatus == 2)
            	return;

        	this.currI = i;
        	this.findMinI = -1;
        	this.minI = i;
        	
            int min_idx = i; 
            
            for (int j = i+1; j < n; j++) {
            	this.findMinI = j;
            	
                if (sortingArray[j] < sortingArray[min_idx]) {
                    min_idx = j; 
                    this.minI = min_idx;
                }

                this.updateCanvas(this.delay);
            }
            
            double temp = sortingArray[min_idx]; 
            sortingArray[min_idx] = sortingArray[i]; 
            sortingArray[i] = temp; 
            
           
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
				if (this.minI == i) {
					currColor = Color.rgb(255, 255, 100);
				} else if (this.currI == i) {
					currColor = Color.rgb(100, 100, 255);
				} else if (this.findMinI == i) {
					currColor = Color.rgb(255, 100, 255);
				}
			}
			
			this.panel.renderRectangle(i, sortingArray[i], currColor);
		}
	}
}
