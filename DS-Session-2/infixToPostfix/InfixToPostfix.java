package infixToPostfix;

import PostfixEvaluation.Stack;
import PostfixEvaluation.StackLinkedList;
/**
 * this class is used to convert an infix expression to postfix expression
 * @author Ishita_Mathur
 *
 */
public class InfixToPostfix
{
    /**
     * this method is used to convert an infix expression to postfix expression
     * @param infixExpression
     * @return postfixExpression
     * @throws AssertionError if input is null
     */
    public String infixToPostfix(String infixExpression)
    {
        Stack<String> stack = new StackLinkedList<String>();
        
        if(infixExpression == null)
            throw new AssertionError("Invalid Input!");
        
        String[] expressionTokens = infixExpression.split(" ");
        String postfixExpression = "";
        
        for(String token: expressionTokens)
        {
            if("(".equals(token))
                stack.push(token);
            else if(")".equals(token))
            {
                while(!("(".equals(stack.peek())))
                    postfixExpression += stack.pop();
                
                stack.pop();
            }
            else if(isOperator(token))
            {
                if(stack.isEmpty() || "(".equals(stack.peek()) || getPrecedence(token) > getPrecedence(stack.peek()))
                    stack.push(token);
                else 
                {
                    while(!stack.isEmpty() && !("(".equals(stack.peek())) && getPrecedence(token) <= getPrecedence(stack.peek()))
                        postfixExpression += stack.pop();
                    
                    stack.push(token);
                }
            }
            else
                postfixExpression += token;
        }
        
        while(!stack.isEmpty())
            postfixExpression += stack.pop();
       
        return postfixExpression;
    }
    
    /**
     * helper method to check if the given token is an operator or not
     * @param token
     * @return boolean value
     */
    private boolean isOperator(String token)
    {
        boolean isOperator = false;
        
        switch(token)
        {
            case "+":
            case "-":
            case "*":
            case "/":
            case "==":
            case "!=":
            case "<":
            case ">":
            case "<=":
            case ">=":
            case "&&":
            case "||":
            case "!": isOperator = true;
                      break;
            
            default: isOperator = false;
            
        }
        return isOperator;
    }
    
    
    /**
     * helper method used to get the precedence of the given operator
     * @param operator
     * @return precedence of the operator
     */
    private int getPrecedence(String operator)
    {
        int precedence = 0;
        
        switch(operator)
        {
            case "+": precedence = 5;
                      break;
                      
            case "-": precedence = 5;
                      break;
                      
            case "*": precedence = 6;
                      break;
                      
            case "/": precedence = 6;
                      break;
                      
            case "==": precedence = 3;
                       break;
                      
            case "!=": precedence = 3;
                       break;
                      
            case "<": precedence = 4;
                      break;
                      
            case ">": precedence = 4;
                      break;
                      
            case "<=": precedence = 4;
                       break;
                      
            case ">=": precedence = 4;
                       break;
                      
            case "&&": precedence = 2;
                       break;
                      
            case "||": precedence = 1;
                       break;
                      
            case "!": precedence = 7;
                      break;            
        }
        return precedence;
    }
}