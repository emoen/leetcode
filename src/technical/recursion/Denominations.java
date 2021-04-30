package technical.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Denominations {
	public static void main(String[] args) {
		new Denominations().toTest();
	}

	public void toTest() {
		int target_1 = 94;
		int arr_1[] = { 5, 10, 25, 100, 200 };
		boolean expected_1 = false;
		boolean output_1 = canGetExactChange(target_1, arr_1);
		System.out.println(expected_1 + " " + output_1);
		for(int i=0;i<instructions.size();i++) System.out.print(instructions.get(i));
		System.out.println("");

		int target_2 = 75;
		int arr_2[] = { 4, 17, 29 };
		boolean expected_2 = true;
		boolean output_2 = canGetExactChange(target_2, arr_2);
		System.out.println(expected_2 + " " + output_2);
	}

	private boolean isDen = false;
	private LinkedList<Integer> stack = new LinkedList<Integer>();
	private List<Integer> instructions = new ArrayList<Integer>();
	private void denominate(int t, int[] den) {
		for (int i = 0; !isDen && i < den.length; i++) {
			int subtract = t-den[den.length-1-i]; //t-den[i];
			int instr = den[den.length-1-i]; //den[i];
			stack.add(instr);
			if (subtract > 0) {
				denominate(subtract, den);
			} else if (subtract==0) {
				int stackSize = stack.size();
				for (int k=0;k<stackSize;k++) {
					Integer j = stack.pollFirst();
					System.out.println("stack:"+j);
					instructions.add(j);
				}
				instructions.add(instr);
				isDen = true;
				return;
			}
			if (!stack.isEmpty() ) {
				stack.removeLast();
			}
		}
		return;
	}

	boolean canGetExactChange(int targetMoney, int[] denominations) {
		isDen = false;
		stack = new LinkedList<Integer>();
		instructions = new ArrayList<Integer>();
		denominate(targetMoney, denominations);
		return isDen;
	}
}
