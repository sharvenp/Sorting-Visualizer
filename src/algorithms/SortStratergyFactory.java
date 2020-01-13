package algorithms;

/**
 * Factory for generating a SortStratergy.
 * 
 * @author sharvenp
 *
 */
public class SortStratergyFactory {

	/**
	 * Set the current SortStratergy based on the given name.
	 * 
	 * @param stratergyString the name of the stratergy.
	 */
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
			case "Merge":
				stratergy = new MergeSort();
				break;
			default:
				stratergy = new NullSort();
				break;
		}		
		
		CurrentSortStratergy.getInstance().setStratergy(stratergy);
	}
	
}
