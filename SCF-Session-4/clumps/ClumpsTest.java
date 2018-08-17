package clumps;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClumpsTest 
{
	ArrayClumps clump = new ArrayClumps();
	
	@Test
	public void firstClumpTest() 
	{
		int clumpNumber = clump.countClumps(new int[]{1, 2, 2, 3, 4, 4});
		assertEquals(2, clumpNumber);
	}
	
	@Test
	public void secondClumpTest() 
	{
		int clumpNumber = clump.countClumps(new int[]{1, 1, 2, 1, 1});
		assertEquals(2, clumpNumber);
	}
	
	@Test
	public void thirdClumpTest() 
	{
		int clumpNumber = clump.countClumps(new int[]{1, 1, 1, 1, 1});
		assertEquals(1, clumpNumber);
	}
	
	@Test
	public void testException()
	{
		try
		{
			clump.countClumps(new int[]{});
		}
		catch(AssertionError error)
		{
			assertEquals("Array is empty", error.getMessage());
		}
	}
}
