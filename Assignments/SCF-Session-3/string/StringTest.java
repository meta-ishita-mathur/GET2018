package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest
{
	MyString object = new MyString();

	/**
	 * For equal strings
	 */
	@org.junit.Test
	public void testingStringEqualityPositive()
	{
		int equal = object.compareStrings("Game of Thrones","Game of Thrones");
		assertEquals(1, equal);
	}

	/**
	 * For unequal strings
	 */
	@org.junit.Test
	public void testingStringEqualityNegative()
	{
		int equal = object.compareStrings("Game of Thrones", "Game of thrones");
		assertEquals(0, equal);
	}	

	/**
	 * For reversing the string
	 */
	@org.junit.Test
	public void testingStringReverse()
	{
		String reverse = object.reverseString("Game of Thrones");
		assertEquals("senorhT fo emaG", reverse);
	}	

	/**
	 * For converting the uppercase to lowercase and vice versa
	 */
	@org.junit.Test
	public void testingStringChangeCase()
	{
		String stringCase = object.caseString("Game of Thrones");
		assertEquals("gAME OF tHRONES", stringCase);
	}

	/**
	 * For finding largest word 
	 */
	@org.junit.Test
	public void testingStringLargest()
	{
		String largest = object.largestWord("Game of Thrones");
		assertEquals("Thrones", largest);
	}

	/**
	 * For two words having same length, returns last word
	 */
	@org.junit.Test
	public void testingStringlargestFromLast()
	{
		String largest = object.largestWord("I live in Pune");
		assertEquals("Pune", largest);
	}	

}
