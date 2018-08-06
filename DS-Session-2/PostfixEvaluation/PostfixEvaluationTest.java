package PostfixEvaluation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluationTest 
{
	PostfixEvaluation postfixObj = new PostfixEvaluation();
	
	@Test
	public void firstPositiveTest()
	{
		String postfix = "5 3 + 8 2 - *";
		double result = postfixObj.evaluatePostfix(postfix);
		assertEquals(48, result, 0.001);
	}

	@Test
	public void secondPositiveTest()
	{
		String postfix = "3 4 + 2 * 7 /";
		double result = postfixObj.evaluatePostfix(postfix);
		assertEquals(2, result, 0.001);
	}
	
	@Test
	public void testNullInput()
	{
		try
		{
			String postfix = null;
			postfixObj.evaluatePostfix(postfix);
		}
		catch(AssertionError e)
		{
			assertEquals("Invalid Input!", e.getMessage());
		}
	}
	
	@Test
	public void testInvalidInput()
	{
		try
		{
			String postfix = "5 3 + 8 2 - >";
			postfixObj.evaluatePostfix(postfix);
		}
		catch(AssertionError e)
		{
			assertEquals("Invalid expresion! Expression must contain only integers and operators!", e.getMessage());
		}
	}

	@Test
	public void testMissingOperatorInput()
	{
		try
		{
			String postfix = "5 3 + 8 2 -";
			postfixObj.evaluatePostfix(postfix);
		}
		catch(AssertionError e)
		{
			assertEquals("Missing operator", e.getMessage());
		}
	}
	
	@Test
	public void testDivideByZero()
	{
		try
		{
			String postfix = "3 4 + 2 * 0 /";
			postfixObj.evaluatePostfix(postfix);
		}
		catch(ArithmeticException e)
		{
			assertEquals("Divide by zero exception", e.getMessage());
		}
	}
	
	@Test
	public void firstNegativeTest()
	{
		String postfix = "5 3 + 8 2 - *";
		double result = postfixObj.evaluatePostfix(postfix);
		assertNotEquals(4, result, 0.001);
	}
}