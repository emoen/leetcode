package technical.sorting;

import java.util.Arrays;

public class BalancedSplit {
	public static void main(String[] args) {
		new BalancedSplit().toTest();
	}

	public void toTest() {
		int arr_1[] = { 2, 1, 2, 5 };
		boolean expected_1 = true;
		boolean output_1 = balancedSplitExists(arr_1);
		System.out.println(expected_1 + " " + output_1);

		int arr_2[] = { 3, 6, 3, 4, 4 };
		boolean expected_2 = false;
		boolean output_2 = balancedSplitExists(arr_2);
		System.out.println(expected_2 + " " + output_2);
		
		int arr3[] = { 1, 5, 7, 1};
		expected_2 = true;
		output_2 = balancedSplitExists(arr3);
		System.out.println(expected_2 + " " + output_2);
		
		int arr4[] = {12, 7, 6, 7, 6,2};
		expected_2 = false;
		output_2 = balancedSplitExists(arr4);
		System.out.println(expected_2 + " " + output_2);
		
		int arr5[] = { 20, 2 };
		expected_2 = false;
		output_2 = balancedSplitExists(arr5);
		System.out.println(expected_2 + " " + output_2);
		
		int arr6[] = { 5,7,20,12,5,7,6,14,5,5,6 };
		expected_2 = true;
		output_2 = balancedSplitExists(arr6);
		System.out.println(expected_2 + " " + output_2);
		
		int arr7[] = { 5,7,20,12,5,7,6,7,14,5,5,6 };
		expected_2 = false;
		output_2 = balancedSplitExists(arr7);
		System.out.println(expected_2 + " " + output_2);
		
		int arr8[] = { 1,1,1,1,1,1,1,1,1,1,1,1 };
		expected_2 = false;
		output_2 = balancedSplitExists(arr8);
		System.out.println(expected_2 + " " + output_2);
	}

	boolean balancedSplitExists(int[] arr) {
		int n=arr.length;
		Arrays.sort(arr);
		int leftSum = 0;
		for(int i=0;i<n;i++) { 
			leftSum += arr[i];
		}
		int rightSum =0;
		for(int i=n-1;i>0;i--) {
			leftSum -= arr[i];
			rightSum += arr[i];
			if ( leftSum==rightSum ) {
				if (arr[i-1]<arr[i]) return true;
			}
		}
		return false;
	}
}
