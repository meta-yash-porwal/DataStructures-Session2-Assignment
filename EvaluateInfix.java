
/**
 * this class evaluate a infix expression using Stack
 * @author yash.porwal_metacube
 *
 */
public class EvaluateInfix {
	/**
	 * Method evaluates the expression on the basis of precedence of operators
	 * @param expression: contains the expressions to evaluate
	 * @return result after evaluation
	 */
	public static int evaluate(String expression) {
		StackInfix values=new StackInfix(expression.length());
		char[] tokens = expression.toCharArray();

	
		StackInfix operators=new StackInfix(expression.length());
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
 
			// Current token is a number, push it to stack of values
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new
						StringBuffer();

				// If more than 1 digits in number
				while (i < tokens.length && 
						tokens[i] >= '0' && 
						tokens[i] <= '9') {
					sbuf.append(tokens[i++]);
				}

				values.push(Integer.parseInt(sbuf.toString()));
				//as above i was incremented at last so i will point to the next character, so we perform i--
				i--;
			}

			else if (tokens[i] == '(')
				operators.push(tokens[i]);

			//to solve entire brace
			else if (tokens[i] == ')') {
				while (operators.peek() != '(') {
					values.push(applyOp(operators.pop(), values.pop(), 
							values.pop()));
				}
				
				operators.pop();
			}
 
			// Current token is an operator.
			else if (tokens[i] == '+' || 
					tokens[i] == '-' ||
					tokens[i] == '*' || 
					tokens[i] == '/' ||
					tokens[i] == '<' ||
					tokens[i] == '>' 
					) {
				//checks precedence of the top of 'operators' and if precedence is greater applies operator on 2 elements in values stack
				while (!operators.isEmpty() && 
						hasPrecedence(tokens[i],(char) operators.peek()
								)) {
					values.push(applyOp(operators.pop(), values.pop(), 
							values.pop()));
					}

				operators.push(tokens[i]);
			}
		}

		//entire expression has been parsed, apply remaining 'operators' to remaining values
		while (!operators.isEmpty()) {
			values.push(applyOp(operators.pop(), values.pop(), 
					values.pop()));
		}
		
		return values.pop();
	}

	/**
	 * Returns true if 'op2'-operator2 has higher or same precedence as 'op1'-operator one otherwise returns false
	 * @param op1: operator 1
	 * @param op2: operator 2
	 * @return true if precedence of 'op2' is more than 'op1'
	 */
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		if ((op1 == '*' || op1 == '/' || op1 == '+' || op1 == '-')&& (op2 == '<' || op2 =='>' ))
			return false;
		else
			return true;
	}
 
	/**
	 * Method to apply an operator 'op' on operands 'a' and 'b'
	 * @param op: operator
	 * @param b: second value
	 * @param a: first value
	 * @return result 
	 */
	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new 
				UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		case '<':
			if( a<b)
				return 1;
			else
				return 0;
		case '>':
			if( a>b)
				return 1;
			else
				return 0;

		}
		return 0;
	}

	// main method
	public static void main(String[] args) {
		System.out.println("Evaluation of 10 + (2 * 6 > 3) is = "
				+ EvaluateInfix.evaluate("10 + (2 * 6 > 3)"));
		System.out.println("Evaluation of 100 * 2 + 12 =  "
				+ EvaluateInfix.evaluate("100 * 2 + 12"));
		System.out.println("Evaluation of 100 * ( 2 + 12 ) =  "
				+ EvaluateInfix.evaluate("100 * ( 2 + 12 )"));
		System.out.println("Evaluation of 100 * ( 2 + 12 ) / 14 =  "
				+ EvaluateInfix.evaluate("100 * ( 2 + 12 ) / 14"));
		System.out.println("Evaluation of 2 * 6 > 3 =  "
				+ EvaluateInfix.evaluate("2 * 6 > 3"));
	}
}