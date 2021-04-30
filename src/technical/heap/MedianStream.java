package technical.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import datastructure.heap.MedianHeap;

public class MedianStream {
	public static void main(String[] args) {
		new MedianStream().toTest();
	}

	public void toTest() {
		int[] arr_1 = { 5, 15, 1, 3 };
		int[] expected_1 = { 5, 10, 5, 4 };
		int[] output_1 = findMedian(arr_1,true);
		print(expected_1);
		print(output_1);

		int[] arr_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { 2, 3, 4, 3, 4, 3 };
		int[] output_2 = findMedian(arr_2,true);
		print(expected_2);
		print(output_2);
		int[] ttt = heapMedian(arr_2);
		print(ttt);
		
		Random rand = new Random();
		int nn=100000;
		int[] arr3 = new int[nn];
		for (int j = 0; j < nn; j++){
		    arr3[j] = rand.nextInt((100) );
		}
		
		long startTime = System.nanoTime();
		int[] t = findMedian(arr_2,true);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("collection:"+duration);
		// time complexity: O(n^2*log n) - java collections.sort() uses mergesort O(nlogn) => O(nlog n)*O(n)
		
		startTime = System.nanoTime();
		int[] tt = findMedian(arr_2,false);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("insert:"+duration);
		// time complexity:  O(n^2)
		
		startTime = System.nanoTime();
		int[] tttd = heapMedian(arr_2);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("heap:"+duration);
		// time complexity:  O(n log n)
	}
	
	public int[] heapMedian(int[] arr) {
		int n = arr.length;
		int[] output = new int[n];
		MedianHeap medianInsertDelete = new MedianHeap(n);
		for (int i = 0; i < n; i++) {
			medianInsertDelete.insert(arr[i]);
			output[i] = medianInsertDelete.findMedian();
		}
		return output;
	}
    

	int[] findMedian(int[] arr, boolean useCollection) {
		int n = arr.length;
		int[] output = new int[n];
		List<Integer> subarray = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			if (!useCollection) {
				int j=0;
				while (j < subarray.size() && arr[i] < subarray.get(j)) j++;
				if (j==subarray.size()) subarray.add(arr[i]);
				else subarray.add(j, arr[i]);
			} else {
				subarray.add(arr[i]);
				Collections.sort(subarray); 
			}
			int middleIndex = Math.floorDiv(i + 1, 2);
			if ((i + 1) % 2 == 0) { // even
				output[i] = Math.floorDiv(subarray.get(middleIndex) + subarray.get(middleIndex - 1), 2);
			} else { // odd
				output[i] = subarray.get(middleIndex);
			}
		}
		return output;
	}
	
	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
