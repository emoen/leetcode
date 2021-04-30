package technical.heap;

public class LargestTripletProduct {

	public static void main(String[] args) {
		new LargestTripletProduct().toTest();
	}

	public void toTest() {
		int[] arr_1 = { 1, 2, 3, 4, 5 };
		int[] expected_1 = { -1, -1, 6, 24, 60 };
		int[] output_1 = findMaxProduct(arr_1);

		print(expected_1);
		print(output_1);

		int[] arr_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { -1, -1, 56, 56, 140, 140 };
		int[] output_2 = findMaxProduct(arr_2);
		print(expected_2);
		print(output_2);

		int[] arr_3 = { 3, 2, 1, 4, 5, 2, 3, 1, 5, 6, 7, 8, 2, 4, 1, 3, 5, 3, 2, 4, 1, 7 };
		int[] expected_3 = { -1, -1, 6, 24, 60, 60, 60, 60, 100, 150, 210, 336, 336, 336, 336, 336, 336, 336, 336, 336,
				336, 392 };
		int[] output_3 = findMaxProduct(arr_3);
		print(expected_3);
		print(output_3);
		
		int[] arr_4 = { -3, -2, -1, -4, -5, -2, -3, -1, -5, -6, -7, -8, -2, -4, -1, -3, -5, -3, -2, -4, -1, -7 };
		int[] expected_4 = { -1, -1, -6, -6, -6, -4, -4, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] output_4 = findMaxProduct(arr_4);
		print(expected_4);
		print(output_4);
	}

	public int[] findMaxProduct(int[] arr) {
		int[] output = new int[arr.length];
		int[] triplet = new int[3];

		for (int i = 0; i < arr.length; i++) {
			if (i < 2) {
				output[i] = -1;
				triplet[i] = arr[i];
				if (i == 1) {
					if (triplet[0] < triplet[1]) {
						int tmp = triplet[0];
						triplet[0] = triplet[1];
						triplet[1] = tmp;
					}
				}
			} else if (i == 2) {
				if (triplet[0] < arr[2]) {
					swap3(triplet, arr[2]);
				} else if (triplet[1] < arr[2]) {
					swap(triplet, arr[2]);
				} else
					triplet[2] = arr[2];
				output[i] = triplet[0] * triplet[1] * triplet[2];
			} else {
				if (triplet[0] < arr[i]) {
					swap3(triplet, arr[i]);
				} else if (triplet[1] < arr[i]) {
					swap(triplet, arr[i]);
				} else if (triplet[2] < arr[i]) {
					triplet[2] = arr[i];
				}
				output[i] = triplet[0] * triplet[1] * triplet[2];
			}
		}
		return output;
	}

	public void swap3(int[] triplet, int t) {
		triplet[2] = triplet[1];
		triplet[1] = triplet[0];
		triplet[0] = t;
	}

	public void swap(int[] triplet, int t) {
		triplet[2] = triplet[1];
		triplet[1] = t;
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
