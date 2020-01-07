package stratergies;

public class SortStratergyFactory {

	public static SortStratergy getStratergy (String stratergy) {
		
		switch(stratergy) {
			
			case "Selection":
				return new SelectionSort();
			case "Bubble":
				return new BubbleSort();
				
		}
		
		return null;
	}
	
}
