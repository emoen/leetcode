package technical;

public class ContiguousSubarray {
	public static void main(String[] args) {
		new ContiguousSubarray().toTest();
	}

	public void toTest() {
		int[] arr = {3, 4, 1, 6, 2};
		int[] test = countSubarrays(arr);
		for(int i=0;i<test.length;i++) System.out.println(test[i]);
		int[] output = {1, 3, 1, 5, 1};
	}

	public int[] countSubarrays(int[] arr) {
		int n = arr.length;
		int[] output = new int[n];
		for(int i=0; i<n; i++) {
			//forward
			int j=i+1;
			int count =1;
			while (j < n && arr[j] < arr[i]) {
				count++;
				j++;
			}
			//backward
			j=i-1;
			while (j>=0 && arr[j] < arr[i]) {
				count++;
				j--;
			}
			output[i] = count;
		}
			
		return output;
	}
}
