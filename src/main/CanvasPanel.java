package main;

import algorithms.SortStratergy;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import utils.Settings;

public class CanvasPanel extends Canvas {

	public CanvasPanel() {
		super(Settings.canvasWidth, Settings.canvasHeight);
		
		this.clearCanvas();
	}
	
	public void clearCanvas() {
		GraphicsContext gc = this.getGraphicsContext2D();
		
		gc.setFill(Settings.backgroundColor);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void renderRectangle(int index, double value, Color color) {
		
		GraphicsContext gc = this.getGraphicsContext2D();
		
		double rectangleWidth = (double) Settings.canvasWidth / (double) SortStratergy.sortingArray.length;
		double maxHeight = (double) (SortStratergy.sortingArray.length - 1);
		
		double x = index * rectangleWidth;
		double heightPercentage = SortStratergy.sortingArray[index] / maxHeight;
		double y = Settings.canvasHeight * (1d - heightPercentage);
		
		gc.setFill(Settings.borderColor);
		double strokePercentage = (100 / SortStratergy.sortingArray.length);
		if (strokePercentage > 1) {
			strokePercentage = 1d;
		}
		double stroke = Settings.borderStroke * strokePercentage;
		
		gc.fillRect(x - stroke, y - stroke, 
				rectangleWidth + stroke, 
				(Settings.canvasHeight * heightPercentage) + stroke);
		
		gc.setFill(color);
		gc.fillRect(x, y, rectangleWidth, Settings.canvasHeight * heightPercentage);
	}
	
}
