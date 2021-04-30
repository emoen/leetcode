package technical.graphs;



public class MinimizingPermutations {
	public static void main(String[] args) {
		new MinimizingPermutations().toTest();
	}

	public void toTest() {
		int n_1 = 5;
		int[] arr_1 = { 1, 2, 5, 4, 3 };
		int expected_1 = 1;
		int output_1 = minOperations(arr_1);
		System.out.println(expected_1 + " " + output_1);

		int n_2 = 3;
		int[] arr_2 = { 3, 1, 2 };
		int expected_2 = 2;
		int output_2 = minOperations(arr_2);
		System.out.println(expected_2 + " " + output_2);
	}

	int minOperations(int[] arr) {
		return 0;

	}
}
