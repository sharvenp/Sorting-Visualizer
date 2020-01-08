package stratergies;

import javafx.scene.paint.Color;
import main.Settings;

public class SelectionSort extends SortStratergy {

	@Override
	public void sort() {
		int n = sortingArray.length; 
		  
        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) {
                if (sortingArray[j] < sortingArray[min_idx]) 
                    min_idx = j; 
            }
  
            double temp = sortingArray[min_idx]; 
            sortingArray[min_idx] = sortingArray[i]; 
            sortingArray[i] = temp; 
            
            this.updateCanvas();
        } 
	}

	@Override
	public void renderArray() {
		Color barColor = Color.rgb(255, 100, 100);
		
		if (this.getSortStatus() == 2) {
			barColor = Settings.sortedColor;
		}
		
		for (int i = 0; i < sortingArray.length; i++) {
			this.panel.renderRectangle(i, sortingArray[i], barColor);
		}
	}
}
