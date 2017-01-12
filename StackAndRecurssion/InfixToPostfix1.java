/*
 * convert infix expression to postfix expression
 * version-1 doesn't consider paranthesis
 */
public class InfixToPostfix1 {

	/*
	 * returns true is op1 has precedence over op2 eg: precedence(*,+) = TRUE
	 */
	public boolean precedence(char op1, char op2) {
		if (((op1 == '*' || op1 == '/') && (op2 == '*' || op2 == '/'))
				|| ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
				|| ((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-')))
			return true;
		else
			return false;
	}

	/*
	 * only 4 operations are valid
	 */
	public boolean isOperation(char ch) {
		return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
	}

	/*
	 * converts infix expression to postfix
	 */
	public String covertToPostfix(String expr) {

		StringBuffer result = new StringBuffer("");
		CharStack stack = new CharStack(1000);

		for (int index = 0; index < expr.length(); index++) {

			char ch = expr.charAt(index);

			if (Character.isLetterOrDigit(ch))
				result.append(ch);
			else if (isOperation(ch)) {

				while (!stack.isEmpty() && precedence(stack.stackTop(), ch)) {
					result.append(stack.pop());
				}

				stack.push(ch);
			} else
				return "not a valid expression";
		}

		while (!stack.isEmpty())
			result.append(stack.pop());

		return result.toString();
	}
}
