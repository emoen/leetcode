package technical.greedy;

import java.util.ArrayList;
import java.util.List;

public class SlowSum {
	public static void main(String[] args) {
		new SlowSum().toTest();
	}

	public void toTest() {
	    int[] arr_1 = {4, 2, 1, 3}; //4+3=7+2=9+(7)=9+1+(9+7)=26
	    int expected_1 = 26;
	    int output_1 = getTotalTime(arr_1);
	    System.out.println(expected_1+" "+output_1);
	
	    int[] arr_2 = {2, 3, 9, 8, 4};
	    int expected_2 = 88;
	    int output_2 = getTotalTime(arr_2);
	    System.out.println(expected_2+" "+output_2);
	    
	    int[] arr_3 = {5, 3, 7, 1};
	    expected_2 =  43; //7+5=12+3=15+(12)=15+1+(15+12)=43 
	    output_2 = getTotalTime(arr_3);
	    System.out.println(expected_2+" "+output_2);
	    
	    int[] arr_4 = {2, 1, 7, 1, 5, 3};
	    output_2 = getTotalTime(arr_4);
	    System.out.println(expected_2+" "+output_2);
	}

	class Tuple {
		public int max;
		public int argmax;
		public Tuple(int m, int a) {
			this.max = m;
			this.argmax = a;
		}
	}

	public Tuple max_argmax(List<Integer> arrl, int minus_argument) {
		// Collections.max(); is nice - but Collections.argmax(); is missing
		int max = Integer.MIN_VALUE;
		int argmax = minus_argument;
		int n = arrl.size();
		for (int i = 0;  i < n; i++) {
			if( i != minus_argument) {
				if (max < arrl.get(i)) {
					max = arrl.get(i);
					argmax = i;
				}
			}
		}
		return new Tuple(max, argmax);
	}

    //Choose _any_ two numbers and replace them with their sum
    //id est choose max two numbers
    // time O(n)
	int getTotalTime(int[] arr) {
		if (arr.length == 0)return 0;
		if (arr.length == 1)return arr[0];
		if (arr.length == 2)return arr[0] + arr[1];

		int n = arr.length;
		int cost = 0;
		List<Integer> arrl = new ArrayList<Integer>(arr.length);
		for(int i=0; i<n;i++) arrl.add(arr[i]);
		Tuple t = max_argmax(arrl, -1);
		Tuple t2 = max_argmax(arrl, t.argmax);
		cost = t.max + t2.max;
		//swap
		arrl.set(t.argmax, arrl.get(0));
		arrl.set(0, cost);
		
		if (t2.argmax != 0) arrl.remove(t2.argmax);
		else arrl.remove(t.argmax);
		t.argmax=0;
		while (arrl.size() > 1) {
			t2 = max_argmax(arrl, t.argmax);
			cost += arrl.get(0) + t2.max;
			arrl.set(t.argmax, arrl.get(0) + t2.max);
			arrl.remove(t2.argmax);
			
		}
		return cost;
	}
}
