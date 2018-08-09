package N_Queens;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest
{
	NQueenProblem nQueen = new NQueenProblem();

	/**
	 * Test case for n = 4 (solution exists)
	 */
	@Test
	public void testNQueensPositive() 
	{    
		boolean result = nQueen.nQueens(4);
		assertTrue(result);
	}

	/**
	 * Test case for n = 2 (solution does'nt exist)
	 */
	@Test
	public void testNQueensNegative() 
	{    
		boolean result = nQueen.nQueens(2);
		assertFalse(result);
	}
}
