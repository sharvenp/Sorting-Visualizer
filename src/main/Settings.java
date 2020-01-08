package main;

import javafx.scene.paint.Color;

public class Settings {

	// Canvas Appearance
	public static int canvasWidth = 800;
	public static int canvasHeight = 500;
	
	// Sorting Algorithms
	public static String[] algorithms = {"Bubble", "Selection", "Insertion"};
	
	// Bar Appearance
	public static Color backgroundColor = Color.BLACK;
	public static Color sortedColor = Color.rgb(100, 255, 100);
	public static Color borderColor = Color.BLACK;
	public static double borderStroke = 0.3;
	
	// Tone settings
	public static double toneVolume = 0.05;
	public static int toneDuration = 10;
	public static double maxFrequency = 10000;
}
