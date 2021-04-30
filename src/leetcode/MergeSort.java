package leetcode;

public class MergeSort {
	
	public static void main(String[] args) {
		new MergeSort().toTest();
	}
	
	public void toTest() {
		int[] nums1 = {2,2,4,4};
		int[] nums2 = {2,2,4,4};
		double t =findMedianSortedArrays(nums1, nums2);
		System.out.println(3 % 2);
		System.out.println(t);
	}
	
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int n1 = nums1.length;
    	int n2 = nums2.length;
        int[] sorted = new int[n1 + n2];

        if ( n1 > n2) {
        	int[] tmp = nums2;
        	nums2 = nums1;
        	nums1 = tmp;
        	n1 = nums1.length;
			n2 = nums2.length;
        }
        int j = 0;
        int i = 0;
        for (; i < n1; i++) {
    		while ( j < n2 && nums1[i] >= nums2[j]) {
    			sorted[i+j] = nums2[j];
    			j++;
    		}
    		sorted[i+j] = nums1[i];
        }
        System.out.println(""+j); 
        for ( j=n1+j; j < n1+n2; j++)
        	sorted[j] = nums2[j-n1];
        
        int middle = Math.floorDiv(sorted.length, 2);
//        System.out.println(sorted[middle]);
//        System.out.println(sorted[middle-1]);
//        System.out.println(middle);
		if ( sorted.length % 2 == 0) return 0.5*(sorted[middle] + sorted[middle-1]);
		return sorted[middle];
    }
}
