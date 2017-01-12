/*
 * evaluating a postfix expressin using stack
 * convert postfix to infix
 * eg: ab+cd-* => (a+b) * (c-d)
 * doesn't consider paranthesis
 * works only for 1 digit numbers
 * postfix to infix
 */

public class PostfixEvaluation {

	/*
	 * expects a valid expression if expression is "" it returns -99999 expects
	 * valid arithmetic operations
	 */
	public double evaluate(String expr) {

		if (expr.equals(""))
			return -99999;

		DoubleStack stack = new DoubleStack(1000);

		for (int index = 0; index < expr.length(); index++) {

			char ch = expr.charAt(index);

			if (Character.isDigit(ch))
				stack.push(Double.parseDouble("" + ch));

			else if (isOperation(ch)) {

				double value2 = (double) stack.pop();
				double value1 = (double) stack.pop();
				double result = applyOperation(ch, value1, value2);

				// invalid operation
				if (result == -99999)
					return -99999;

				stack.push(result);

			} else {
				System.out.println("invalid arithmetic operation found");
				return -99999;

			}
		}

		double finalResult = stack.pop();

		return finalResult;
	}

	/*
	 * only 5 operations are valid
	 */
	public boolean isOperation(char ch) {
		return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%');
	}

	/*
	 * perform respective arithmetic operations
	 */
	public double applyOperation(char operation, double value1, double value2) {
		switch (operation) {
		case '+':
			return (value1 + value2);
		case '-':
			return (value1 - value2);
		case '/':
			return (value1 / value2);
		case '*':
			return (value1 * value2);
		case '%':
			return (value1 % value2);
		default:
			System.out.println("not a valid operation");
			return -99999;
		}
	}

}
