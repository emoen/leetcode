package technical.search;

public class OneBillionUsers {

	public static void main(String[] args) {
		new OneBillionUsers().toTest();
	}

	public void toTest() {
		float[] test_1 = { 1.1f, 1.2f, 1.3f };
		int expected_1 = 79;
		int output_1 = getBillionUsersDay(test_1);
		System.out.print(expected_1 + " ");
		System.out.println(output_1);

		float[] test_2 = { 1.01f, 1.02f };
		int expected_2 = 1047;
		int output_2 = getBillionUsersDay(test_2);
		System.out.print(expected_2 + " ");
		System.out.println(output_2);
	}

	int getBillionUsersDay(float[] growthRates) {
		// Write your code here
		float[] xs = growthRates;
		float maxx = 0;
		for (int i = 0; i < xs.length; i++) {
			if (maxx < xs[i])
				maxx = xs[i];
		}
		double t = 9 * Math.log(10) / Math.log(maxx);
		return (int) Math.ceil(t);
	}
}
