package main;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import stratergies.SortStratergy;
import utils.Observable;
import utils.Observer;

public class CanvasPanel extends Canvas implements Observer {

	private GraphicsContext gc;
	
	public CanvasPanel() {
		super(Settings.canvasWidth, Settings.canvasHeight);
		this.gc = this.getGraphicsContext2D();
		
		this.resetCanvas();
	}

	private void resetCanvas() {
		this.gc.setFill(Settings.backgroundColor);
		this.gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	@Override
	public void update(Observable o) {
		this.resetCanvas();
		this.renderArray((SortStratergy) o);
	}
	
	private void renderArray(SortStratergy stratergy) {
		double[] array = stratergy.getArray();
		double rectangleWidth = (double) Settings.canvasWidth / (double) array.length;
		double maxHeight = Double.MIN_VALUE;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxHeight)
				maxHeight = array[i];
		}
		
		if (stratergy.getSortStatus() == 2) {
			this.gc.setFill(Settings.sortedColor);
		} else {
			this.gc.setFill(Settings.barColor);			
		}
		
		Color barColor = Settings.barColor;
		
		if (stratergy.getSortStatus() == 2) {
			barColor = Settings.sortedColor;
		}
		
		for (int i = 0; i < array.length; i++) {
			double x = i * rectangleWidth;
			double heightPercentage = array[i] / maxHeight;
			double y = Settings.canvasHeight * (1d - heightPercentage);
			
			this.gc.setFill(Settings.borderColor);
			this.gc.fillRect(x - Settings.borderStroke, y - Settings.borderStroke, 
					rectangleWidth + Settings.borderStroke, (Settings.canvasHeight * heightPercentage) + Settings.borderStroke);
			
			this.gc.setFill(barColor);
			this.gc.fillRect(x, y, rectangleWidth, Settings.canvasHeight * heightPercentage);
			
		}
	}
	
}
