package main;

import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import stratergies.SortStratergy;
import utils.DelayCreator;
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
		this.gc.setFill(Color.BLACK);
		this.gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	@Override
	public void update(Observable o) {
		DelayCreator.delay(((SortStratergy) o).getDelay());
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
		
		for (int i = 0; i < array.length; i++) {
			double x = i * rectangleWidth;
			double heightPercentage = array[i] / maxHeight;
			double y = Settings.canvasHeight * (1d - heightPercentage);
			this.gc.fillRect(x, y, rectangleWidth, Settings.canvasHeight * heightPercentage);
		}
	}
	
}
