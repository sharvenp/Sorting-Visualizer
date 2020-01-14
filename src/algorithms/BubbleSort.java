package algorithms;

import javafx.scene.paint.Color;
import utils.Settings;

public class BubbleSort extends SortStratergy {

	private int i1 = -1;
	private int i2 = -1;
	
	@Override
	public void sort() {
		for (int j = 0; j < sortingArray.length - 2; j++) {
			for (int i = 0; i < sortingArray.length - 1 - j; i++) {
				
				if (this.sortStatus == 2)
					return;
				
				this.i1 = i;
				this.i2 = i + 1;
				
				if (sortingArray[i] > sortingArray[i+1]) {
					
					super.updateCanvas(this.delay);
					
					double temp = sortingArray[i+1];
					sortingArray[i+1] = sortingArray[i];
					sortingArray[i] = temp;
					
					super.updateCanvas(this.delay);
				}
				super.updateCanvas(this.delay);
			}
		}
	}
	
	@Override
	public void renderArray() {
			
		Color barColor = Color.rgb(255, 100, 100);
		
		if (this.sortStatus == 2) {
			barColor = Settings.sortedColor;
		}
		
		for (int i = 0; i < sortingArray.length; i++) {
		
			Color currColor = barColor;
			
			if ((i == this.i1 || i == this.i2) && this.sortStatus != 2) {
				currColor = Color.rgb(100, 100, 255);
			}
			
			this.panel.renderRectangle(i, sortingArray[i], currColor);
		}
	}

}
