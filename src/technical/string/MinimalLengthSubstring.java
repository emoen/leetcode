package technical.string;

import java.util.Arrays;

public class MinimalLengthSubstring {

	public static void main(String[] args) {
		new MinimalLengthSubstring().toTest();
	}
	
	public void toTest() {
	    String s_1 = "dcbefebce";
	    String t_1 = "fd";
	    int expected_1 = 5;
	    int output_1 = minLengthSubstring(s_1, t_1);
	    System.out.println(expected_1);
	    System.out.println(output_1);

	    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
	    String t_2 = "cbccfafebccdccebdd";
	    int expected_2 = -1;
	    int output_2 = minLengthSubstring(s_2, t_2);
	    System.out.println(expected_2);
	    System.out.println(output_2);
	    
	    String S = "ABAACBAB"; String T = "ABC";
	    int o = minLengthSubstring(S, T);
	    System.out.println(o);
	}

	int minLengthSubstring(String s, String t) {
		// Write your code here
	    //time complexity: O(n)+O(n)+O(n)=3*O(n)=O(n)
	    //space use: O(tn)+O(256+4)
		int sn = s.length();
		int tn = t.length();
		int min = sn;
		int max = 0;
		char tempt[] = t.toCharArray();
		Arrays.sort(tempt);
		t = String.valueOf(tempt);
		

		int[] freq_s = new int[128];
		int[] freq_t = new int[128];
		for (int i = 0; i < sn; i++) {
			char c = s.charAt(i);
			freq_s[c]++;
		}
		for (int i = 0; i < tn; i++) {
			char c = t.charAt(i);
			freq_t[c]++;
		}
		for (int i = 0; i < tn;) {
			char c = t.charAt(i);
			if (s.indexOf(c) == -1)
				return -1;
			else {
				int j = s.indexOf(c);
				int sCount = freq_s[(int)c];
				int tCount = freq_t[(int)c];
				System.out.println(c + " " + (int)c+ " "+ tCount + " " + sCount);
				if (tCount > sCount)
					return -1;
				if (j < min)
					min = j;
				if (j > max)
					max = j;
				if (tCount > 1) {
					int l = 0;
					for (int k = 0; k < tCount; k++) {
						l = s.indexOf(c + "", j + l);
						if (l < min)
							min = l;
						if (l > max)
							max = l;
					}
					i += tCount - 1;
				}
				i++;
			}
		}
		return max - min + 1;
	}
}
