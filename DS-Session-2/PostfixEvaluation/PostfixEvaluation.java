package PostfixEvaluation;

/**
 * this class evaluates the given postfix expression
 * @author Ishita_Mathur
 *
 */
public class PostfixEvaluation
{
	/**
     * this method evaluates the given postfix expression assuming that the given postfix expression has only integer constants
     * @param postfix
     * @return result of evaluation
     * @throws AssertionError if input is null or invalid or if at some point the denominator is 0
     */
	public double evaluatePostfix(String postfix)
	{
		Stack<Double> operandStack = new StackLinkedList<Double>();

		if(postfix == null)
			throw new AssertionError("Invalid Input!");

		String[] expressionToken = postfix.split(" ");

		for(String token: expressionToken)
		{
			// If the scanned character is an operand (number here), push it to the stack.
			if(isInteger(token))
				operandStack.push((double)Integer.parseInt(token));

			//  If the scanned character is an operator, pop two elements from stack apply the operator
			else if(isOperator(token))
			{
				double secondOperand = operandStack.pop();
				double firstOperand = operandStack.pop();
				
				switch(token)
				{
					case "+": operandStack.push(firstOperand + secondOperand);
							  break;

					case "-": operandStack.push(firstOperand - secondOperand);
						  	  break;

					case "/": if(secondOperand == 0)
							      throw new ArithmeticException("Divide by zero exception");
							  operandStack.push(firstOperand / secondOperand);
							  break;

					case "*": operandStack.push(firstOperand * secondOperand);
							  break;
				}
			}
			else
				throw new AssertionError("Invalid expresion! Expression must contain only integers and operators!");
		}
		
		double result = operandStack.pop();
		
		if(operandStack.isEmpty())
			return result;
		else
			throw new AssertionError("Missing operator");
	}

	/**
     * helper method to check if the given token is an integer or not
     * @param token
     * @return boolean value
     */
	public boolean isInteger(String token)
	{
		try
		{
			Integer.parseInt(token);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
     * helper method to check if the given token is an operator or not
     * @param token
     * @return boolean value
     */
    private boolean isOperator(String token)
    {
        boolean isOperator = false;
        
        if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))
            isOperator = true;
        
        return isOperator;
    }
}