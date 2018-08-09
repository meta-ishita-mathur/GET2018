package split;

import static org.junit.Assert.*;

public class SplitArrayTest 
{
	SplitArray splitArray = new SplitArray();
	
	@org.junit.Test
	public void testPositive() 
	{	
		int indexSplit = splitArray.split(new int[]{1, 1, 1, 2, 1}, 5);
		assertEquals(3, indexSplit);
	}
	
	@org.junit.Test
	public void secondTestNegative() 
	{	
		int indexSplit = splitArray.split(new int[]{1, 1, 1, 2, 1}, 5);
		assertNotEquals(2, indexSplit);
	}
	
	@org.junit.Test
	public void testNegative()
	{
		int indexSplit = splitArray.split(new int[]{2, 1, 1, 2, 1}, 5);
		assertEquals(-1, indexSplit);
	}
	
	@org.junit.Test
	public void testException()
	{
		try
		{
			splitArray.split(new int[]{}, 0);
		}
		catch(AssertionError error)
		{
			assertEquals("Array is empty", error.getMessage());
		}
	}
}
