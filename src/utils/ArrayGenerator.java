package utils;

import java.util.Random;

import stratergies.SortStratergy;

public class ArrayGenerator {

	public static void generateShuffledArray(int size) {
			
		SortStratergy.sortingArray = new double[size];
		
		for (int i = 0; i < size; i++) {
			SortStratergy.sortingArray[i] = i+1;
		}
		
		Random r = new Random();
		
		for (int i = 0; i < size; i++) {
			int ri = r.nextInt(size);
			double temp = SortStratergy.sortingArray[ri];
			SortStratergy.sortingArray[ri] = SortStratergy.sortingArray[i];
			SortStratergy.sortingArray[i] = temp;
		}
	}
	
}
