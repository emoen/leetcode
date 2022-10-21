package leetcode.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * When to use hashmap:
 * Using HashMap makes sense only when unique keys are available for the data we want to store. 
 * We should use it when searching for items based on a key and quick access time is an important requirement.
 * @author endre
 *
 */
public class NonRepeatingCharacterFinder {

	/**
	 * Implementation with O(n) running time 
	 * 
	 * @param input
	 * @return
	 */
	public static char findFirstNonRepeatingCharacterBetter(String input) {
		
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
		
		for(int i=0; i < input.length(); i++) {
			Character next = input.charAt(i);
			counter.put(next, counter.getOrDefault(next, 0)+1);
		}
		
		for(int i=0; i < input.length(); i++) {
			if ( counter.get(input.charAt(i)) == 1) {
				return input.charAt(i);
			}
		}
		return 0;
	}
	

	/**
	 * Implementation with O(n^2) running time and overly complex
	 * 
	 * @param input
	 * @return
	 */
	public static char findFirstNonRepeatingCharacter(String input) {
		int index = 0;
		List<String> charactersFound = new ArrayList<String>();
		while (index < input.length()) {
			char pointing = input.charAt(index);
			int search = index + 1;

			while (search < input.length() && charactersFound.contains(pointing + "")) {
				index++;
				pointing = input.charAt(index);
				search = index + 1;
			}

			while (search < input.length() && input.charAt(search) != pointing) {
				search++;
			}
			if (search < input.length()) {
				charactersFound.add(pointing + "");
//				System.out.println("adding character pointing:" + charactersFound.toString());
			} else if (!charactersFound.contains(pointing + "")) {
//				System.out.println("char pointing:" + pointing + " charfound" + charactersFound.toString());
				return pointing;
			}
			index++;
		}
		return 0;
	}
	
	public static void main( String[] args ) {
		
		String example = "aaabbeccdfgfg";
		String example2 = "abbeccdfgfga";
		String example3 = "abbccddfgfga";
		String empty = "";
		
		char expectedE = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacterBetter(example);
		System.out.println(expectedE);
		assert expectedE=='e';
		
		expectedE = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacterBetter(example2);
		assert expectedE=='e';
				
		char expectedZero = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacterBetter(example3);
		assert expectedZero == '0';
		
		expectedZero = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacterBetter( empty );
		assert expectedZero == '0';
		
		// old implementation tests
		
		expectedE = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacter(example);
		assert expectedE=='e';
		
		expectedE = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacter(example2);
		assert expectedE=='e';
				
		expectedZero = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacter(example3);
		assert expectedZero == '0';
		
		expectedZero = NonRepeatingCharacterFinder.findFirstNonRepeatingCharacter( empty );
		assert expectedZero == '0';
	}
	
}
