package technical.greedy;

import java.util.Random;

public class ElementSwapping {
	public static void main(String[] args) {
		new ElementSwapping().toTest();
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

	public void toTest() {
		int n_1 = 3, k_1 = 2;
		int[] arr_1 = { 5, 3, 1 };
		int[] expected_1 = { 1, 5, 3 };
		int[] output_1 = findMinArray(arr_1, k_1);
		printIntegerArray(output_1);
		printIntegerArray(expected_1);

		int n_2 = 5, k_2 = 3;
		int[] arr_2 = { 8, 9, 11, 2, 1 };
		int[] expected_2 = { 2, 8, 9, 11, 1 };
		int[] output_2 = findMinArray(arr_2, k_2);
		System.out.println("*********");
		printIntegerArray(output_2);
		printIntegerArray(expected_2);
		
	    int k_3=6;
	    int[] arr_3 = { 8, 9, 11, 2, 1 };
	    int[] expected_3 = { 1, 8, 2, 9, 11 };
	    int[] output_3 = findMinArray(arr_3, k_3);
		System.out.println("*********");
		printIntegerArray(output_3);
		printIntegerArray(expected_3);
	    
	    int k_4=7;
	    int[] arr_4 = { 8, 9, 11, 2, 1 };
	    int[] expected_4 = {1, 2, 8, 9, 11};
	    int[] output_4 = findMinArray(arr_4,k_4);
		System.out.println("*********");
		printIntegerArray(output_4);
		printIntegerArray(expected_4);
		
		int[] arr_5 = {7, 6, 9, 2, 1}; 
		int[] exp={6, 7, 9, 2, 1} ;
		output_2 = findMinArray(arr_5, 1);
		System.out.println("*********");
		printIntegerArray(output_2);
		printIntegerArray(exp);
		
		Random rand = new Random(1234);
		int nn=10;
		int[] arr3 = new int[nn];
		for (int j = 0; j < nn; j++){
		    arr3[j] = rand.nextInt((100) );
		}
		System.out.println("*********");
		printIntegerArray(arr3);
		int[] output_5 = findMinArray(arr3, 53);
		printIntegerArray(output_5);
		
		//21, 53, 93, 83, 84, 99, 4,20 
	}
	
	public int findMinarg( int[] arr, int minIndex, int maxIndex) {
		int min = Integer.MAX_VALUE;
		int minarg = -1;
		if(maxIndex >= arr.length) maxIndex = arr.length-1;
		for(int i=minIndex;i<=maxIndex;i++) {
			if (min > arr[i]) {
				min = arr[i];
				minarg=i;
			}
		}
		return minarg;
	}

	int[] findMinArray(int[] arr, int k) {
		//swaps, each involving a pair of _consecutive_ elements in the sequence.
		int n = arr.length;
		int minFromBelow = 0;
		for(int i=0;i<k;i++) {
			int minarg = findMinarg(arr, minFromBelow, k-i+minFromBelow);
			int j=0;
			while(minFromBelow+j < n && minarg == minFromBelow+j) { //next lex entry to be minimized cannot be reached
				j++;
				minarg = findMinarg(arr, minFromBelow+j, k-i+minFromBelow+j); //try minimize j+1'th best entry 
			}
			if(minFromBelow+j >=n) return arr;
			int tmp = arr[minarg-1]; //swap
			arr[minarg-1] = arr[minarg];
			arr[minarg] = tmp;
			if (minarg-1 == minFromBelow) minFromBelow++;
		}
		return arr;
	}
}
