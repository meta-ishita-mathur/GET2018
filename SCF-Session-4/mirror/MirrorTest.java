package mirror;

import static org.junit.Assert.*;

import org.junit.Test;

public class MirrorTest 
{
	MaxMirror mirror = new MaxMirror();
	
	@Test
	public void firstMaxTest() 
	{
		int maxCount = mirror.maxMirror(new int[]{1, 2, 3, 9, 8, 3, 2, 1}, 8);
		assertEquals(3, maxCount);
	}
	
	@Test
	public void firstMaxTestNegative() 
	{
		int maxCount = mirror.maxMirror(new int[]{1, 2, 3, 9, 8, 3, 2, 1}, 8);
		assertNotEquals(4, maxCount);
	}
	
	@Test
	public void secondMaxTest() 
	{
		int maxCount = mirror.maxMirror(new int[]{7, 1, 4, 9, 7, 4, 1}, 7);
		assertEquals(2, maxCount);
	}
	
	@Test
	public void ThirdMaxTest() 
	{
		int maxCount = mirror.maxMirror(new int[]{1, 2, 1, 4}, 4);
		assertEquals(3, maxCount);
	}
	
	@Test
	public void FourthMaxTest() 
	{
		int maxCount = mirror.maxMirror(new int[]{1, 4, 5, 3, 5, 4, 1}, 7);
		assertEquals(7, maxCount);
	}
	
	@Test
	public void testException()
	{
		try
		{
			mirror.maxMirror(new int[]{}, 0);
		}
		catch(AssertionError error)
		{
			assertEquals("Array is empty", error.getMessage());
		}
	}
}
