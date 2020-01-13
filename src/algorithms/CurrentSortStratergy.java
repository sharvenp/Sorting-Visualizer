package algorithms;

/**
 * Maintains reference to the current SortStratergy for global reference.
 * 
 * @author sharvenp
 *
 */
public class CurrentSortStratergy {

	private SortStratergy currentStratergy = new NullSort();
	private static CurrentSortStratergy instance = null;

	
	public static synchronized CurrentSortStratergy getInstance() {
		if (instance == null)
			instance = new CurrentSortStratergy();
		
		return instance;
	}
	
	public void setStratergy(SortStratergy stratergy) {
		this.currentStratergy = stratergy;
	}
	
	public SortStratergy getCurrentStratergy() {
		return this.currentStratergy;
	}
	
}
