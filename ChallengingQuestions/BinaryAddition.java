public class BinaryAddition {

	// using Java's built-in functions
	public void quickBinaryAdd(String first, String second) {

		// parseInt(String, radix)
		// for binary, radix = 2
		int f = Integer.parseInt(first, 2);
		int s = Integer.parseInt(second, 2);

		int sum = f + s;

		System.out.println(Integer.toBinaryString(sum));
	}

	// basic implementation
	public void binaryAdd(String first, String second) {
		int sum = 0;
		int carry = 0;
		String result = "";

		int i, j;
		// iterate over binary string from least significant digit to most
		// significant digit
		for (i = first.length() - 1, j = second.length() - 1; i >= 0 && j >= 0; i--, j--) {
			sum = Integer.parseInt("" + first.charAt(i))
					+ Integer.parseInt("" + second.charAt(j)) + carry;
			carry = sum / 2;
			sum = sum % 2;
			result = result + sum;
		}

		// find the larger number and add it to result
		String larger = "";
		int l = 0;

		if (i < 0) {
			larger = second;
			l = j;
		} else if (j < 0) {
			larger = first;
			l = i;
		}

		// continue adding leftover bits from larger number to carry
		if (!larger.equals("")) {
			while (l >= 0) {
				sum = Integer.parseInt("" + larger.charAt(l--)) + carry;
				carry = sum / 2;
				sum = sum % 2;
				result = result + sum;
			}
		}
		
		// append carry to result
		if (carry > 0)
			result = result + carry;

		System.out.println((new StringBuffer(result)).reverse());
	}
}
