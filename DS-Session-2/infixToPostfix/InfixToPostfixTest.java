package infixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest
{
	InfixToPostfix objInfixToPostfix = new InfixToPostfix();

	@Test
	public void testPositive() 
	{
		String infix = "( 4 + 8 ) - ( 6 * 5 ) / ( ( 3 - 2 ) * ( 2 + 2 ) )";
		String postfix = objInfixToPostfix.infixToPostfix(infix);
		assertEquals("48+65*32-22+*/-", postfix);
	}
	
	@Test
	public void testNullInput()
	{
		try
		{
			String postfix = null;
			objInfixToPostfix.infixToPostfix(postfix);
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void testPositiveSecond() 
	{
		String infix = "( 4 <= 8 ) ! ( 6 >= 5 ) != ( ( 3 > 2 ) < ( 2 == 2 ) )";
		String postfix = objInfixToPostfix.infixToPostfix(infix);
		assertEquals("48<=65>=!32>22==<!=", postfix);
	}
	
	@Test
	public void testNegative() 
	{
		String infix = "( 4 + 8 ) && ( 6 - 5 ) || ( ( 3 - 2 ) * ( 2 + 2 ) )";
		String postfix = objInfixToPostfix.infixToPostfix(infix);
		assertEquals("48+65-&&32-22+*||", postfix);
	}


}
