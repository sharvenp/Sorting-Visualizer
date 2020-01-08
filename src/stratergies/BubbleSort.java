package stratergies;

public class BubbleSort extends SortStratergy {

	@Override
	public void sort() {
		boolean sorted = false;
		
		while (!sorted) {
			
			sorted = true;
			
			for (int i = 0; i < this.sortingArray.length - 1; i++) {
				if (this.sortingArray[i] > this.sortingArray[i+1]) {
					double temp = this.sortingArray[i+1];
					this.sortingArray[i+1] = this.sortingArray[i];
					this.sortingArray[i] = temp;
					sorted = false;
				}
				super.notifyCanvas();
			}
		}
	}

}
