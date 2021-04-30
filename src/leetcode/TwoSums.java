package leetcode;

import java.util.Arrays;


public class TwoSums {

	public static void main(String[] args) {
		new TwoSums().doTest();
	}

	public void doTest() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] t = twoSum(nums, target);
		
		nums = null;
		int[] nums2 = {3, 2, 4};
		target = 6;
		t = twoSum(nums2, target);
		System.out.println("t:"+Arrays.toString(t));
		
		int[] nums3 = {3, 2, 3};
		target = 6;
		t = twoSum(nums3, target);
		System.out.println("t:"+Arrays.toString(t));
		
		int[] nums4 = {0,4,3,0};
		target = 0;
		t = twoSum(nums4, target);
		System.out.println("t:"+Arrays.toString(t));
		
		int[] nums5 = {-3,4,3,90};
		target = 0;
		t = twoSum(nums5, target);
		System.out.println("t:"+Arrays.toString(t));
		
		int[] nums6 = {0,4,3,0};
		target = 0;
		t = twoSum(nums6, target);
		System.out.println("t:"+Arrays.toString(t));
		
		int[] nums7 = {-1,-2,-3,-4,-5};
		target = -8;
		t = twoSum(nums7, target);
		System.out.println("t:"+Arrays.toString(t));
	}

	public int[] twoSum(int[] nums, int target) {
		int[] output = new int[2];

		for(int j=0; j < nums.length; j++) {
			for (int k=j+1; k < nums.length; k++) {
				if (nums[j]+nums[k] == target) {
					output[0]=j;
					output[1]=k;
					return output;
				}
			}
		}
		return output;
	}
}

