package technical.stack;

import java.util.LinkedList;

public class BalancedBrackets {
	public static void main(String[] args) {
		new BalancedBrackets().toTest();
	}

	public void toTest() {
	    String s_1 = "{[(])}";
	    boolean expected_1 = false;
	    boolean output_1 = isBalanced(s_1);
	    System.out.println(expected_1+" "+output_1);
	
	    String s_2 = "{{[[(())]]}}";
	    boolean expected_2 = true;
	    boolean output_2 = isBalanced(s_2);
	    System.out.println(expected_2+" "+output_2);
	}
    
    
	private LinkedList<Character> stack = new LinkedList<Character>();
	boolean isBalancedStack(String s) {
		stack = new LinkedList<Character>();
		for(int i=0;i<s.length();i++) {
			if (isOpen( s.charAt(i) ) ) {
				stack.addFirst( s.charAt(i) );
			} else if(!stack.isEmpty() && isClosed(s.charAt(i) ) ) {
				char d = stack.pop(); //pops first
				char e = s.charAt(i);
				String closing = d+""+e;
				if (!closing.equals("()") && !closing.equals("[]") && !closing.equals("{}"))  return false;
			} else return false;
		}
		return true;
	}
	
	private boolean isOpen(char c) {return "{([".indexOf(c) > -1;};
	private boolean isClosed(char c) {return "})]".indexOf(c) > -1;};

	boolean isBalanced(String s) {
		// Write your code here
		// can assume only brackets..otherwise make substring
		// Time Complexity: O(n/2)
		// Space Complexity: O(1)
		System.out.println(isBalancedStack(s));
		int n = s.length();
		int halfEven = Math.floorDiv(n, 2);
		if (halfEven % 2 != 0)
			return false;
		for (int i = 0; i < halfEven; i++) {
			if (s.charAt(i) != s.charAt(i))
				return false;
		}
		return true;
	}
	
	
}
