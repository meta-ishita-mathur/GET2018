package hexadecimalCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class HexadecimalTest
{
	ArithmeticFunctions object = new ArithmeticFunctions();

	/**
	 * To convert hexadecimal to decimal
	 */
	@org.junit.Test
	public void testingHexToDecCoversion()
	{
		int hexToDec = object.hexToDec("A");
		assertEquals(10, hexToDec);
	}

	/**
	 * To convert decimal to hexadecimal
	 */
	@org.junit.Test
	public void testingDecToHexConversion()
	{
		String decToHex = object.decToHex(11);
		assertEquals("B", decToHex);
	}

	/**
	 * To add two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalAddition()
	{
		String add = object.add("A", "B");
		assertEquals("15", add);
	}

	/**
	 * To subtract two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalSubtraction()
	{
		String substract = object.subtract("B", "A");
		assertEquals("1", substract);
	}	

	/**
	 * To multiply two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalMultiplication()
	{
		String multiply = object.multiply("A","B");
		assertEquals("6E", multiply);
	}

	/**
	 * To divide two hexadecimal number
	 */
	@org.junit.Test
	public void testingHexadecimalDivision()
	{
		String divide = object.divide("F", "B");
		assertEquals("1", divide);
	}	

	/**
	 * For first greater hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalGreaterPositive()
	{
		boolean result = object.greater("BA", "AB");
		assertEquals(true, result);
	}	

	/**
	 * For first smaller hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalGreaterNegative()
	{
		boolean result = object.greater("AB", "BA");
		assertEquals(false, result);
	}

	/**
	 * For first smaller hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalSmallerPositive()
	{
		boolean result = object.smaller("AB", "BA");
		assertEquals(true, result);
	}

	/**
	 * For first greater hexadecimal value
	 */
	@org.junit.Test
	public void testingFirstHexadecimalSmallerNegative()
	{
		boolean result = object.smaller("BA", "AB");
		assertEquals(false, result);
	}	

	/**
	 * For both equal hexadecimal value
	 */
	@org.junit.Test
	public void TestingBothHexadecimalEqualPositive()
	{
		boolean result = object.equality("BA", "BA");
		assertEquals(true, result);
	}
	
	/**
	 * For unequal hexadecimal value
	 */	
	@org.junit.Test
	public void TestingBothHexadecimalEqualNegative()
	{
		boolean result = object.equality("BA", "AB");
		assertEquals(false, result);
	}	
}
