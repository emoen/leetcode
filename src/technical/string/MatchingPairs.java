package technical.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MatchingPairs {
	public static void main(String[] args) {
		new MatchingPairs().toTest();
	}

	public void toTest() {
		String s_1 = "abtceq";
		String t_1 = "abczdt";
		int expected_1 = 3;
		int output_1 = matchingPairs(s_1, t_1);
		int out1 = matchingPairs2(s_1, t_1);
		System.out.print(expected_1+" ");
		System.out.println(output_1);

		String s="ax"; String t ="ay";int expected=0;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="axb"; t="ayb"; expected=1;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="axa"; t="aya"; expected=2;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="abx"; t="abb"; expected=2;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="abb"; t="axb";; expected=2;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="ax"; t="ya";; expected=1;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="aa"; t="ab";; expected=1;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="abc"; t="adb"; expected=2;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="aa"; t="aa"; expected=2;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
		s="abd"; t="abc"; expected=1;
		System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
	    s= "abcd"; t = "abcd";expected=2;
	    System.out.println(matchingPairs2(s,t)+" "+expected+" "+matchingPairs(s,t));
				
		String s_2 = "axa";
		String t_2 = "aya";
		int expected_2 = 2;
		int output_2 = matchingPairs(s_2, t_2);
		System.out.print(expected_2+" ");
		System.out.println(output_2);

		String s_3 = "abcd";
		String t_3 = "adcb";
		int expected_3 = 4;
		int output_3 = matchingPairs(s_3, t_3);
		System.out.print(expected_3+" ");
		System.out.println(output_3);
	}

	public int matchingPairs(String s, String t) {
		// Write your code here
		// solution 1 - brute force
		// 1. find all chars which differ
		// 2. permute all 2 cycles of different chars and
		// 3. maximize equal chars
		int n = s.length();
		List<Integer> idxc = new ArrayList<Integer>();
		int max = 0;
		boolean sContainsDuplicate = false;
		boolean tDuplicate = false;
		Set<Character> sSet = new HashSet<Character>();
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++) {
			if (tMap.containsKey( t.charAt(i) ) ) {
				Integer count = tMap.get(t.charAt(i));
				count++;
				tMap.put(t.charAt(i), count);
			} else tMap.put(t.charAt(i), 1);
		}
		for (int i = 0; i < n; i++) {
			if (!sContainsDuplicate) {
				if (sSet.contains(s.charAt(i)) ) sContainsDuplicate=true;
				else sSet.add(s.charAt(i));
			}
			if ( !tDuplicate && tMap.get(s.charAt(i))!=null && tMap.get(s.charAt(i)).intValue() > 1 ) tDuplicate=true;
			if (s.charAt(i) != t.charAt(i))
				idxc.add(i);
			else
				max++;
		}
		if (idxc.size() == 0) {
			if (!sContainsDuplicate) return n - 2;
			else return n;
		}
		int found_1_2 = 0;
		int diff = idxc.size();
		for (int i = 0; i < diff; i++) {
			for (int j = i + 1; j < diff; j++) {
				if (s.charAt(idxc.get(i)) == t.charAt(idxc.get(j))) {
					found_1_2 = 1;
					if (s.charAt(idxc.get(j)) == t.charAt(idxc.get(i))) {
						found_1_2 = 2;
						return max + 2;
					}
				} else if (s.charAt(idxc.get(j)) == t.charAt(idxc.get(i))) {
					found_1_2 = 1;
				}
			}
		}
		if (idxc.size()==1 && found_1_2==0 && !sContainsDuplicate && !tDuplicate) return max-1;
		return max + found_1_2;
	}
	
	public int matchingPairs2(String s, String t) {
		Set<Character> countSet = new HashSet<Character>();
		Set<Character> countSetT = new HashSet<Character>();
		Set<Character> misMatchSetS = new HashSet<Character>();
		Set<Character> misMatchSetT = new HashSet<Character>();
		boolean isRepeatedIns = false;
		boolean isRepeatedInt = false;
		int matching = 0;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			if (ch1 != ch2) {
				set.add(ch1 + "" + ch2);
				misMatchSetS.add(ch1);
				misMatchSetT.add(ch2);
			} else
				matching++;

			if (!isRepeatedIns) {
				if (countSet.contains(ch1)) {
					isRepeatedIns = true;
				} else {
					countSet.add(ch1);
				}
			}
			if ( !isRepeatedInt && s.contains(ch2+"") ) {
				if (countSetT.contains(ch2)) {
					isRepeatedInt = true;
				} else {
					countSetT.add(ch2);
				}
			}
		}

		for (String pair : set) {
			String reverse = pair.charAt(1) + "" + pair.charAt(0);
			if (set.contains(reverse)) {
				return matching + 2;
			}
		}
		for (Character ch : misMatchSetS) {
			if (misMatchSetT.contains(ch))
				return matching + 1;
		}
		
		if (isRepeatedIns) return matching;
		else if ( isRepeatedInt ) return matching;
		else if (misMatchSetS.size() == 1) return matching-1; 
		
		if (s.length()<=2) return 0;
		else return matching - 2;
	}
}
