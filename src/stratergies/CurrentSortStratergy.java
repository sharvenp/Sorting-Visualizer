package stratergies;

public class CurrentSortStratergy {

	private SortStratergy currentStratergy = null;
	private static CurrentSortStratergy instance = null;

	
	public static CurrentSortStratergy getInstance() {
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
