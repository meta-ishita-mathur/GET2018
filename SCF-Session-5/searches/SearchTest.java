package searches;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest
{
	Search searchObject = new Search();
	
	@Test
	public void testPositive()
	{
		int linearIndex = searchObject.linearSearch(new int[]{1, 2, 3, 4, 5, 6}, 3);
		assertEquals(2, linearIndex);
		
		int binaryIndex = searchObject.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 0, 5, 3);
		assertEquals(2, binaryIndex);
	}
	
	@Test
	public void testNegative()
	{
		int linearIndex = searchObject.linearSearch(new int[]{1, 2, 3, 4, 5, 6}, 7);
		assertEquals(-1, linearIndex);
		
		int binaryIndex = searchObject.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 0, 5, 7);
		assertEquals(-1, binaryIndex);	
	}
	
	@Test(expected = AssertionError.class)
	public void testLinearException()
	{
		int linearIndex = searchObject.linearSearch(new int[]{}, 0);
		assertEquals(0, linearIndex);
	}
	
	@Test(expected = AssertionError.class)
	public void testBinaryException()
	{
		int binaryIndex = searchObject.binarySearch(new int[]{}, 0, 0, 0);
		assertEquals(0, binaryIndex);
	}

	
	

}
