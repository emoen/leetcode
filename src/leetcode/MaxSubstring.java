package leetcode;

public class MaxSubstring {
	public static void main(String[] args) {
		new MaxSubstring().toTest();
	}
	
	
	public void toTest() {
		String s = "abcabcbb";
		int m = lengthOfLongestSubstring(s);
		System.out.println(m);

		lengthOfLongestSubstring2(s);		
	}
	
    public int lengthOfLongestSubstring(String s) {
    	if (s.length()==0) return 0;
    	int start =0;
    	int end = start+1;
    	char[] substring = new char[s.length()];
    	substring[0] = s.charAt(0);
    	int max = 1;
    	while ( end < s.length() ) {
    		char next = s.charAt(end);
    		if ( !new String(substring).contains(next+"") ) {
    			end++;
    			if (end-start > max ) max = end-start;
    			for (int k=0; k<(end-start); k++) {
    				substring[k] = s.charAt( start + k); 
    			}
    		} else {
    			start++;
    			substring = new char[s.length()];
    			for (int k=0; k<end-start; k++) {
					substring[k] = s.charAt( start + k);
    			}
    		}
    	}
		
    	return max;
    }
    
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            System.out.println(chars[c]);
            chars[c]++;
            System.out.println(chars[c]);
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }
}
