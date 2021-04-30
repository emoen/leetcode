package technical.recursion;

import technical.TreeAvgAtLevel;

public class EncryptedWords {
	public static void main(String[] args) {
		new TreeAvgAtLevel().toTest();
	}

	public void toTest() {
		String s_1 = "abc";
		String expected_1 = "bac";
		String output_1 = findEncryptedWord(s_1);
		System.out.println(expected_1 + " " + output_1);

		String s_2 = "abcd";
		String expected_2 = "bacd";
		String output_2 = findEncryptedWord(s_2);
		System.out.println(expected_2 + " " + output_2);
	}

	private StringBuffer encrypted = null;

	private void encrypt(String a) {
		if (a.length() <= 2)
			encrypted.append(a);
		else {
			int floor = Math.floorDiv(a.length(), 2);
			if (a.length() % 2 == 0)
				floor = floor - 1;
			encrypted.append(a.charAt(floor));
			encrypt(a.substring(0, floor));
			encrypt(a.substring(floor + 1, a.length()));
		}
	}

	String findEncryptedWord(String s) {
		// Write your code here
		encrypted = new StringBuffer();
		encrypt(s);
		return encrypted.toString();
	}
}
