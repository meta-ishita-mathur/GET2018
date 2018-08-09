package searches;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest
{
	Search searchObject = new Search();
	
	@Test
	public void testPositiveLinearSearch()
	{
		int linearIndex = searchObject.linearSearch(new int[]{1, 2, 3, 4, 5, 6}, 3);
		assertEquals(2, linearIndex);
	}
	
	@Test
	public void testPositiveBinarySearch()
	{	
		int binaryIndex = searchObject.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 0, 5, 3);
		assertEquals(2, binaryIndex);
	}
	
	@Test
	public void testPositiveBinarySearchSecond()
	{	
		int binaryIndex = searchObject.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 0, 5, 1);
		assertEquals(0, binaryIndex);
	}
	
	@Test
	public void testNegativeLinearSearch()
	{
		int linearIndex = searchObject.linearSearch(new int[]{1, 2, 3, 4, 5, 6}, 7);
		assertEquals(-1, linearIndex);
	}
	
	@Test
	public void testNegativeBinarySearch()
	{
		int binaryIndex = searchObject.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 0, 5, 7);
		assertEquals(-1, binaryIndex);	
	}
	
	@Test
	public void testLinearException()
	{
		try
		{
			searchObject.linearSearch(new int[]{}, 0);
		}
		catch(AssertionError error)
		{
			assertEquals("Array is empty", error.getMessage());
		}
	}
	
	@Test
	public void testBinaryException()
	{
		try
		{
			searchObject.binarySearch(new int[]{}, 0, 0, 0);
			
		}
		catch(AssertionError error)
		{
			assertEquals("Array is empty", error.getMessage());
		}
	}
}
