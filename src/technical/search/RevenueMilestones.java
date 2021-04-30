package technical.search;

import java.util.Arrays;

public class RevenueMilestones {
	public static void main(String[] args) {
		new RevenueMilestones().toTest();
	}

	public void toTest() {
		int revenues_1[] = { 100, 200, 300, 400, 500 };
		int milestones_1[] = { 300, 800, 1000, 1400 };
		int expected_1[] = { 2, 4, 4, 5 };
		int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
		printIntegerArray(output_1);
		printIntegerArray(expected_1);
		System.out.println();

		int revenues_2[] = { 700, 800, 600, 400, 600, 700 };
		int milestones_2[] = { 3100, 2200, 800, 2100, 1000 };
		int expected_2[] = { 5, 4, 2, 3, 2 };
		int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
		printIntegerArray(expected_2);
		printIntegerArray(output_2);
	}
	
	public int argmax(int[] milestones) {
		int max = Integer.MIN_VALUE;
		int argmax=-1;
		for(int i=0;i<milestones.length;i++) {
			if (milestones[i]>max) {
				max=milestones[i];
				argmax=i;
			}
		}
		return argmax;
	}

	int[] getMilestoneDays(int[] revenues, int[] milestones) {
		// Write your code here
		int n = revenues.length;
		int[] flag = new int[milestones.length];
		int cumsum = 0;
		int argmax = argmax(milestones);
		for(int i=0;i<n && flag[argmax]==0;i++) {
			cumsum += revenues[i];
			for(int j=0;j<milestones.length;j++) {
				if (flag[j] < 1 ) {
					if (cumsum >= milestones[j]) {
						flag[j] = i+1;
					}
				}
			}
		}
		return flag;
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
		System.out.print("]");
	}
}
