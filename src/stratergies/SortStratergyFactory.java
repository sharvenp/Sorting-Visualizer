package stratergies;

public class SortStratergyFactory {

	public static SortStratergy getStratergy (String stratergy) {
		
		return new SelectionSort();
		
	}
	
}
