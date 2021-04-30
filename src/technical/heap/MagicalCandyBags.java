package technical.heap;

import java.util.Arrays;


public class MagicalCandyBags {
	public static void main(String[] args) {
		System.out.println(3%2);
		new MagicalCandyBags().toTest();
	}
	
	public void toTest() {
	    int n_1 = 5, k_1 = 3;
	    int[] arr_1 = {2, 1, 7, 4, 2};
	    int expected_1 = 14;
	    int output_1 = maxCandies(arr_1, k_1);
	    System.out.println(expected_1);
	    System.out.println(output_1);

	    int n_2 = 9, k_2 = 3;
	    int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
	    int expected_2 = 228;
	    int output_2 = maxCandies(arr_2, k_2);
	    System.out.println(expected_2);
	    System.out.println(output_2);
	    
	    int[] arr_3 =  {2, 1, 7, 4, 2};
	    int output_3 = maxCandies(arr_3, 3);
	    System.out.println(" "+output_3);
		int[] arr_4 =  {19, 78, 76, 72, 48, 8, 24, 74, 29};
		int output_4 = maxCandies(arr_4, 3);
		System.out.println(" "+output_4);
	    
	}
	
	  int maxCandies(int[] arr, int k) {
		  Arrays.sort(arr);
		  int candy = 0;
		  int bag = arr.length-1;
		  for (int i=0; i<k; i++) {
			  candy += arr[bag];
			  arr[bag] = Math.floorDiv(arr[bag], 2);
//			  Arrays.sort(arr);
			  arr = bubbleDown_EatenMagicalCandyBag(arr);
		  }
		  return candy;
	  }
	  
	  public int[] bubbleDown_EatenMagicalCandyBag(int[] arr) {
		  int prev = arr.length-1;
		  int tmp = arr[arr.length-1];
		  
		  while ( prev > 0 && arr[prev] < arr[prev-1] ) {
			  arr[prev] = arr[prev-1];
			  arr[prev-1] = tmp;
			  prev--;
		  }		  
		  return arr;
	  }
}
