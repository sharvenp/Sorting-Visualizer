package utils;

import java.util.Random;

import algorithms.CurrentSortStratergy;
import algorithms.SortStratergy;

public class ArrayGenerator {

	public static boolean isGenerating = false;
	
	/**
	 * Generate a shuffled array with given size.
	 * 
	 * @param size the size of the array.
	 */
	public static void initArray(int size) {
		SortStratergy.sortingArray = new double[size];
	}
	
	public static void generateShuffledArray(int size, boolean showGeneration) {
			
		System.out.println("Generating Array of size " + size);
		isGenerating = true;
		
		for (int i = 0; i < size; i++) {
			SortStratergy.sortingArray[i] = i+1;
		}
		
		Random r = new Random();
		
		for (int i = 0; i < size; i++) {
			
			if (showGeneration)
				CurrentSortStratergy.getInstance().getCurrentStratergy().updateCanvas(Settings.generationDelay);
			
			int ri = r.nextInt(size);
			double temp = SortStratergy.sortingArray[ri];
			SortStratergy.sortingArray[ri] = SortStratergy.sortingArray[i];
			SortStratergy.sortingArray[i] = temp;
		}
		
		for (int i = 0; i < size; i++) {
			System.out.println(SortStratergy.sortingArray[i]);
		}
		
		isGenerating = false;
	}
	
}
