package technical.string;

public class RotateChiper {

	public static void main(String[] args) {
		new RotateChiper().toTest();
	}

	public void toTest() {
	    String input_1 = "All-convoYs-9-be:Alert1.";
	    int rotationFactor_1 = 4;
	    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
	    String output_1 = rotationalCipher(input_1, rotationFactor_1);
	    System.out.println(expected_1);
	    System.out.println(output_1);
	}

	public String rotationalCipher(String input, int rotationFactor) {
		int n = input.length();
		char[] c = new char[input.length()];
		int int_A = 'A';
		int int_Z = 'Z';
		
		int int_a = 'a';
		int int_z = 'z';
		
		int int_0 = '0';
		int int_9 = '9';
		
		System.out.println("A"+int_A);
		System.out.println("Z"+int_Z);
		System.out.println("a"+int_a);
		System.out.println("z"+int_z);
		System.out.println("0"+int_0);
		System.out.println("9"+int_9);
		for ( int i=0; i<n;i++){
			char cc = input.charAt(i); 
			int cc_int = cc;
			int c_int = 0;
			if (cc_int >= int_A && cc_int <= int_Z) {
				c_int = ( (cc_int - int_A + rotationFactor) % 26 ) + int_A;
				c[i] = (char)c_int;
			} else if (cc_int >= int_a && cc_int <= int_z) {
				c_int = ( (cc_int - int_a + rotationFactor) % 26 ) + int_a; 
				c[i] = (char)c_int;
			} else if (cc_int >= int_0 && cc_int <= int_9) {
				c_int = ( (cc_int - int_0 + rotationFactor) % 10 ) + int_0; 
				c[i] = (char)c_int;
			} else {
				c[i] = cc;
			}
		}
		return new String(c);
	}
}
