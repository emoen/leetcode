package technical;

import java.util.Arrays;

public class CycleToMakeArrayEqual {
	
	public static void main(String[] args) {
		new CycleToMakeArrayEqual().toTest();
	}
	
	public void toTest() {

	    int[] array_a_1 = {1, 2, 3, 4};
	    int[] array_b_1 = {1, 4, 3, 2};
	    boolean expected_1 = true;
	    
	    boolean output_1 = areTheyEqual(array_a_1, array_b_1);
	    System.out.println(expected_1);
	    System.out.println(output_1);

	    int[] array_a_2 = {1, 2, 3, 4};
	    int[] array_b_2 = {1, 4, 3, 3};
	    boolean expected_2 = false;
	    boolean output_2 = areTheyEqual(array_a_2, array_b_2); 
	    System.out.println(expected_2);
	    System.out.println(output_2);
	}
	    
    public boolean areTheyEqual(int[] a1, int[] b1) {
    	if (a1.length != b1.length)return false;
    	
    	Arrays.sort(a1);
    	Arrays.sort(b1);
    	for (int i=0;i<a1.length;i++)
    		if (a1[i] != b1[i] ) return false;
    	
    	return true;
    }
}
