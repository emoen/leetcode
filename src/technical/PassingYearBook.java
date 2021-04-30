package technical;

import java.util.ArrayList;
import java.util.List;

public class PassingYearBook {
	public static void main(String[] args) {
		new PassingYearBook().toTest();
	}
	
	public void doPrint(int[] a) {for(int i=0;i<a.length;i++) {System.out.print(a[i]);} System.out.println("");}
	public void toTest() {
	
	    int[] arr_1 = {2, 1};
	    int[] expected_1 = {2, 2};
	    int[] output_1 = findSignatureCounts(arr_1);
	    doPrint(expected_1);
	    doPrint(output_1);
	    
	    int[] arr_2 = {1, 2};
	    int[] expected_2 = {1, 1};
	    int[] output_2 = findSignatureCounts(arr_2);
	    doPrint(expected_2);
	    doPrint(output_2);
	    
	    int[] arr_3 = {5,3,9,4,1,8,6,2,7}; //cycle 1: (1,5) cycle 2: (2,3,9,7,6,8), cycle3: (4)
	    int[] expected_3 = {2, 6, 6, 1, 2, 6, 6, 6 ,6};
	    int[] output_3 = findSignatureCounts(arr_3);
	    doPrint(expected_3);
	    doPrint(output_3);
	}
	
	public int[] findSignatureCounts(int[] a) {
		int n = a.length;
		List<Integer> hasBeenCycled = new ArrayList<Integer>();
		int[] signed = new int[n];
		int[] cycle = new int[n];
		for( int i=0; i< n ; i++) {
			if (!hasBeenCycled.contains(i) ) {
				int start = a[i]-1;
				int next = a[start]-1;
				hasBeenCycled.add(start);
				int cycleCount = 1;
				cycle = new int[n];
				cycle[cycleCount-1] = start;
				while ( start != next ) {
					cycleCount++;
					cycle[cycleCount-1] = next;
					hasBeenCycled.add(next);
					next = a[next]-1;
				}
				for (int j=0; j<=cycleCount-1;j++) {
					signed[cycle[j]] =cycleCount;
				}
			}
		}
		return signed;
	}
}
