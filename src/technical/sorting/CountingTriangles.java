package technical.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountingTriangles {
	class Sides {
		int a;
		int b;
		int c;

		Sides(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		new CountingTriangles().toTest();
	}

	public void toTest() {
	    ArrayList<Sides> arr_1 = new ArrayList<>();
	    arr_1.add(new Sides(7, 6, 5));
	    arr_1.add(new Sides(5, 7, 6));
	    arr_1.add(new Sides(8, 2, 9));
	    arr_1.add(new Sides(2, 3, 4));
	    arr_1.add(new Sides(2, 4, 3));
	    int expected_1 = 3;
	    int output_1 = countDistinctTriangles(arr_1);
	    System.out.println(expected_1+" "+ output_1);

	    ArrayList<Sides> arr_2 = new ArrayList<>();
	    arr_2.add(new Sides(3, 4, 5));
	    arr_2.add(new Sides(8, 8, 9));
	    arr_2.add(new Sides(7, 7, 7));
	    int expected_2 = 3;
	    int output_2 = countDistinctTriangles(arr_2);
	    System.out.println(expected_2+" "+ output_2);
	}

	int countDistinctTriangles(ArrayList<Sides> arr) {
		// Write your code here
		int[] ss = new int[3]; // sortSides
		Set<String> setOfT = new HashSet<String>();
		int n = arr.size();
		int distinct = 0;
		for (int i = 0; i < n; i++) {
			ss = new int[3];
			ss[0] = arr.get(i).a;
			ss[1] = arr.get(i).b;
			ss[2] = arr.get(i).c;
			Arrays.sort(ss);
			String TasString = "" + ss[0] + ss[1] + ss[2];
			if (!setOfT.contains(TasString)) {
				setOfT.add(TasString);
				distinct++;
			}
		}
		return distinct;
	}
}
