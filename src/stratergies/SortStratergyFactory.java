package stratergies;

public class SortStratergyFactory {

	public static void setCurrentStratergy (String stratergyString) {
		
		SortStratergy stratergy = null;

		switch(stratergyString) {
			case "Selection":
				stratergy = new SelectionSort();
				break;
			case "Bubble":
				stratergy = new BubbleSort();
				break;
			case "Insertion":
				stratergy = new InsertionSort();
				break;
		}		
		
		CurrentSortStratergy.getInstance().setStratergy(stratergy);
	}
	
}
