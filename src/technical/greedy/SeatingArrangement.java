package technical.greedy;

import java.util.Arrays;
import java.util.Random;

public class SeatingArrangement {

	public static void main(String[] args) {
		new SeatingArrangement().toTest();
	}

	public void toTest() {
	    int[] arr_1 =  {5, 10, 6, 8};
	    int expected_1 = 4;
	    int output_1 = minOverallAwkwardness(arr_1);
	    System.out.print(expected_1+" ");
	    System.out.println(output_1);

	    int[] arr_2 = {1, 2, 5, 3, 7};
	    int expected_2 = 4;
	    int output_2 = minOverallAwkwardness(arr_2);
	    System.out.print(expected_2+" ");
	    System.out.println(output_2);
	    
	    int[] arr_3 =  {2,4,7,7}; 
	    int expected_3 = 5;
	    int output_3 = minOverallAwkwardness(arr_3);
	    System.out.print(expected_3+" ");
	    System.out.println(output_3);

	    int[] arr_4 = {1,2,3,4,5,6,7,8,9}; 
	    int expected_4 = 2;
	    int output_4 = minOverallAwkwardness(arr_4);
	    System.out.print(expected_4+" ");
	    System.out.println(output_4);
	    
		Random rand = new Random(1234);
		int nn=10;
		int[] arr5 = new int[nn];
		for (int j = 0; j < nn; j++){
		    arr5[j] = rand.nextInt((100) );
		}
		System.out.println("*********");
		printIntegerArray(arr5); 
	    int expected_5 = 56;
	    int output_5 = minOverallAwkwardness(arr5);
	    System.out.print(expected_5+" ");
	    System.out.println(output_5);
	}
	
	//overall awkwardness is the _maximum_ awkwardness 
	//Time complexity O(nlog n) from sorting
	public  int minOverallAwkwardness(int[] arr) {
		if (arr.length<=1) return 0;
		int n = arr.length;
	    Arrays.sort(arr);
	    int maxAwk = arr[1]-arr[0];
	    for(int i=0;i<n-2;i++) {
    		if (maxAwk < arr[i+2]-arr[i]) 
    			maxAwk = arr[i+2]-arr[i];
	    } 
	    if (maxAwk < arr[n-1]-arr[n-2]) maxAwk = arr[n-1]-arr[n-2];
	    return maxAwk;
	  }
	
	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.println("]");
	}
}
