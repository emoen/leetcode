package technical;

import java.io.*;
import java.util.*;

public class PairSums {
	int numberOfWays(int[] arr, int k) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == k) {
					count++;
				}
			}
		}
		return count;
	}

	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() {
		int k_1 = 6;
		int[] arr_1 = { 1, 2, 3, 4, 3 };
		int expected_1 = 2;
		int output_1 = numberOfWays(arr_1, k_1);
		check(expected_1, output_1);

		int k_2 = 6;
		int[] arr_2 = { 1, 5, 3, 3, 3 };
		int expected_2 = 4;
		int output_2 = numberOfWays(arr_2, k_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new PairSums().run();
	}
}
