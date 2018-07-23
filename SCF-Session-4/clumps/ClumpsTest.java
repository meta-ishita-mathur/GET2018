package clumps;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClumpsTest 
{
	ArrayClumps clump = new ArrayClumps();
	
	@Test
	public void firstClumpTest() 
	{
		int clumpNumber = clump.countClumps(new int[]{1, 2, 2, 3, 4, 4}, 6);
		assertEquals(2, clumpNumber);
	}
	@Test
	public void negativeClumpTest() 
	{
		int clumpNumber = clump.countClumps(new int[]{1, 2, 2, 3, 4, 4}, 6);
		assertNotEquals(6, clumpNumber);
	}
	
	@Test
	public void secondClumpTest() 
	{
		int clumpNumber = clump.countClumps(new int[]{1, 1, 2, 1, 1}, 5);
		assertEquals(2, clumpNumber);
	}
	
	@Test
	public void thirdClumpTest() 
	{
		int clumpNumber = clump.countClumps(new int[]{1, 1, 1, 1, 1}, 5);
		assertEquals(1, clumpNumber);
	}
	
	@Test(expected = AssertionError.class)
	public void testException()
	{
		int clumpNumber = clump.countClumps(new int[]{}, 0);
		assertEquals(0, clumpNumber);
	}
	

}
