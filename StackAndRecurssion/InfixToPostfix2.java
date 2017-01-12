/*
 * convert infix expression to postfix expression
 * version-2 consider paranthesis
 */
public class InfixToPostfix2 {

	/*
	 * returns true is op1 has precedence over op2 eg: precedence(*,+) = TRUE
	 */
	public boolean precedence(char op1, char op2) {
		if (((op1 == '*' || op1 == '/') && (op2 == '*' || op2 == '/'))
				|| ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
				|| ((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-'))
				// any op occurred before ')' bracket has higher precedence
				// except '('
				|| (op1 != '(' && op2 == ')'))
			return true;

		// '(' has highest precedence
		// after '(' was pushed on stack any operator inside '( )' has highest
		// precedence
		else if (op2 == '(' || op1 == '(')
			return false;
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
			else if (isOperation(ch) || ch == '(' || ch == ')') {

				while (!stack.isEmpty() && precedence(stack.stackTop(), ch)) {
					result.append(stack.pop());
				}

				if (stack.isEmpty() || ch != ')')
					stack.push(ch);
				else {
					stack.pop();
				}

			} else
				return "not a valid expression";
		}

		while (!stack.isEmpty())
			result.append(stack.pop());

		return result.toString();
	}
}
