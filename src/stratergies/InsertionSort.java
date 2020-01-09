package stratergies;

import javafx.scene.paint.Color;
import main.Settings;

public class InsertionSort extends SortStratergy {

	@Override
	public void sort() {
	 int n = sortingArray.length; 
        for (int i = 1; i < n; ++i) { 
            double key = sortingArray[i]; 
            int j = i - 1; 
  
            while (j >= 0 && sortingArray[j] > key) { 
            	sortingArray[j + 1] = sortingArray[j]; 
                j = j - 1; 
            } 
            sortingArray[j + 1] = key; 
            
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
			
			this.panel.renderRectangle(i, sortingArray[i], currColor);
		}
	}

}
