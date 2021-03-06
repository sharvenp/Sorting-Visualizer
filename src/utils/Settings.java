package utils;

import javafx.scene.paint.Color;

/**
 * Global settings for the application.
 * 
 * @author sharvenp
 *
 */
public class Settings {

	// Canvas Appearance
	public static int canvasWidth = 800;
	public static int canvasHeight = 500;
	
	// Sorting Algorithms
	public static String[] algorithms = {"Bubble", "Selection", "Insertion", "Merge"};
	
	// Bar Appearance
	public static Color backgroundColor = Color.BLACK;
	public static Color defaultColor = Color.rgb(255, 100, 100);
	public static Color sortedColor = Color.rgb(100, 255, 100);
	public static Color borderColor = Color.BLACK;
	public static double borderStroke = 0.3;
	
	// Generator settings
	public static long generationDelay = 5;
	
	// Tone settings
	public static double toneVolume = 0.05;
	public static int toneDuration = 100;
	public static double maxFrequency = 10000;
}
