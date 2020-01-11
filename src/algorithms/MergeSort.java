package algorithms;

import javafx.scene.paint.Color;
import utils.Settings;

public class MergeSort extends SortStratergy {

	private int low = -1;
	private int high = -1;
	private int mid = -1;
	
	@Override
	public void sort() {
		
		this.sort(0, sortingArray.length - 1);

	}
	
    void merge(int l, int m, int r) 
    { 
    	if (this.sortStatus == 2)
    		return;
  
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        double L[] = new double [n1]; 
        double R[] = new double [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = sortingArray[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = sortingArray[m + 1+ j]; 
  
  
        int i = 0, j = 0; 
  
        int k = l; 

        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                sortingArray[k] = L[i]; 
                i++; 
            } 
            else
            { 
                sortingArray[k] = R[j]; 
                j++; 
            } 
            k++; 
            
            this.updateCanvas(this.delay);
        } 
  
        while (i < n1) 
        { 
            sortingArray[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            sortingArray[k] = R[j]; 
            j++; 
            k++; 
        } 
        
    } 
  
    void sort(int l, int r) 
    { 
    	
    	if (this.sortStatus == 2)
    		return;
    	
    	if (l < r) 
        { 
            
    		int m = (l+r)/2; 
        	this.mid = m;
        	
        	this.low = l;
        	this.high = r;
        	
        	this.updateCanvas(this.delay);
  
            sort(l, m); 
            
            this.mid = m;
        	
        	this.low = l;
        	this.high = r;
            
            this.updateCanvas(this.delay);
            
            sort(m+1, r); 
            
            this.mid = m;
        	
        	this.low = l;
        	this.high = r;
            
            
            this.updateCanvas(this.delay);
            
            merge(l, m, r); 
        } 
    }

	@Override
	public void renderArray() {
		
		Color barColor = Color.rgb(255, 100, 100);
		
		if (this.sortStatus == 2) {
			barColor = Settings.sortedColor;
		}
		
		for (int i = 0; i < sortingArray.length; i++) {
		
			Color currColor = barColor;
			
			if (this.sortStatus != 2) {				
				
				if (this.low <= i && i <= this.high) {
					currColor = Color.rgb(100, 100, 255);
				}
				
				if (i == this.mid) {
					currColor = Color.rgb(255, 255, 100);
				}
			}
			
			this.panel.renderRectangle(i, sortingArray[i], currColor);
		}

	}

}
