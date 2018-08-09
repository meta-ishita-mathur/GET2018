package polynomial;

import static org.junit.Assert.*;
import org.junit.Test;

public class PolyTest
{
	/**
	 * Test case when input polynomial is null
	 */
	@Test
	public void polyFirstException() 
	{
		try
		{
			new Poly(null);
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid input", error.getMessage());
		}
	}

	/**
	 * Test case when input polynomial is empty
	 */
	@Test
	public void polySecondException()
	{
		try
		{
			new Poly(new int[][]{});
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid input", error.getMessage());
		}
	}

	/**
	 * Test case for evaluate(float value) when value is too large
	 */
	@Test
	public void evaluateTestFirst()
	{
		try
		{
			Poly polynomial = new Poly(new int[][]{{2, 200}, {3, 1}, {2, 0}});
			polynomial.evaluate(200f);
		}
		catch(AssertionError error)
		{
			assertEquals("Result is too large", error.getMessage());
		}
	}

	/**
	 * A positive Test case for evaluate(float x) 
	 */
	@Test
	public void evaluateTestSecond()
	{
		Poly polynomial = new Poly(new int[][]{{2, 2}, {3, 1}, {2, 0}, {4, 1}});
		double result = polynomial.evaluate(2f);
		assertEquals(24, result, 0.001);
	}

	/**
	 * Test case for degree()
	 */
	@Test
	public void degreeTest()
	{   
		Poly polynomial = new Poly(new int[][]{{2, 2}, {3, 1}, {2, 0}});
		int result = polynomial.degree();
		assertEquals(2, result);
	}

	/**
	 * Test case for addPoly(Poly firstPoly, Poly secondPoly)
	 */
	@Test
	public void addPolyTest()
	{  
		Poly firstPoly = new Poly(new int[][]{{2, 2}, {3, 1}, {2, 0}});
		Poly secondPoly = new Poly(new int[][]{{4, 3}, {3, 1}});

		Poly result = Poly.addPoly(firstPoly, secondPoly);
		assertArrayEquals(new int[][]{{2, 0}, {6, 1}, {2, 2}, {4, 3}}, result.getPolynomial());

		Poly thirdPoly = new Poly(new int[][]{{2, 2}});
		Poly fourthPoly = new Poly(new int[][]{{4, 3}, {3, 1}});

		result = Poly.addPoly(thirdPoly, fourthPoly);
		assertArrayEquals(new int[][]{{3, 1}, {2, 2}, {4, 3}}, result.getPolynomial());
	}

	/**
	 * Test case for multiplyPoly(Poly firstPoly, Poly secondPoly)
	 */
	@Test
	public void multiplyTest()
	{    
		Poly firstPoly = new Poly(new int[][]{{2, 2}, {3, 1}, {2, 0}});
		Poly secondPoly = new Poly(new int[][]{{4, 3}, {3, 1}});

		Poly result = Poly.multiplyPoly(firstPoly, secondPoly);
		assertArrayEquals(new int[][]{{8, 5}, {14, 3}, {12, 4}, {9, 2}, {6, 1}}, result.getPolynomial());
	}
}
