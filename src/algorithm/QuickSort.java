package algorithm;

public class QuickSort {
	static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	 
	/** Takes last element as pivot, places the pivot element at its correct position in sorted array, 
	  * and places all smaller than pivot to left of pivot and all greater el. to right of pivot  **/
	static int partition(int[] arr, int low, int high) {
	    int pivot = arr[high];
	    int i = (low - 1);	    // Index of smaller element and indicates the right position of pivot found so far
	 
	    for(int j = low; j <= high - 1; j++) {
	        if (arr[j] < pivot) { //If current element is smaller than the pivot
	            i++;              // Increment index of smaller element
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}

	/** arr[]: Array to be sorted,
	  * low:   Starting index,
	  * high:  Ending index  **/
	static void quickSort(int[] arr, int low, int high) {
	    if (low < high) {
	        int pi = partition(arr, low, high); // pi is partitioning index, arr[p] is now at right place
	        quickSort(arr, low, pi - 1); // Separately sort elements before partition and after partition
	        quickSort(arr, pi + 1, high);
	    }
	}
	
	public static void main(String[] args)
	{
	    int[] arr = { 10, 7, 8, 9, 1, 5 };
	    int n = arr.length;
	     
	    quickSort(arr, 0, n - 1);
	    System.out.println("Sorted array: ");
	    for(int i = 0; i < n; i++)
	        System.out.print(arr[i] + " ");
	         
	    System.out.println();
	}
}
