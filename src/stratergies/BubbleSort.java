package stratergies;

import javafx.scene.paint.Color;
import main.Settings;
import utils.ToneGenerator;

public class BubbleSort extends SortStratergy {

	private int i1 = -1;
	private int i2 = -1;
	
	@Override
	public void sort() {
		for (int j = 0; j < sortingArray.length - 2; j++) {
			for (int i = 0; i < sortingArray.length - 1 - j; i++) {
				if (sortingArray[i] > sortingArray[i+1]) {
					double temp = sortingArray[i+1];
					sortingArray[i+1] = sortingArray[i];
					sortingArray[i] = temp;
				}
				this.i1 = i;
				this.i2 = i + 1;
				super.updateCanvas();
//				ToneGenerator.generateTone(sortingArray[i]);
			}
		}
	}
	
	public void renderArray() {
			
		Color barColor = Color.rgb(255, 100, 100);
		
		if (this.getSortStatus() == 2) {
			barColor = Settings.sortedColor;
		}
		
		for (int i = 0; i < sortingArray.length; i++) {
			
			if ((i == this.i1 || i == this.i2) && this.sortStatus != 2) {
				this.panel.renderRectangle(i, sortingArray[i], Color.rgb(100, 100, 255));
				continue;
			}
			
			this.panel.renderRectangle(i, sortingArray[i], barColor);
		}
	}

}
