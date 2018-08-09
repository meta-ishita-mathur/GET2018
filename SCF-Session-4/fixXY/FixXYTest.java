package fixXY;

import static org.junit.Assert.*;

import org.junit.Test;

public class FixXYTest
{
	ArrayFixXY fix = new ArrayFixXY();
	@Test
	public void fixPositiveTest()
	{
		int[] newArray = fix.fixXY(new int[]{5, 4, 9, 4, 9, 5}, 4, 5);
		assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9}, newArray);
	}
	
	@Test
	public void testExceptionEmpty()
	{
		try
		{
			fix.fixXY(new int[]{}, 0, 0);
		}
		catch(AssertionError error)
		{
			assertEquals("Array is empty", error.getMessage());
		}
	}
	
	@Test
	public void testExceptionUnequal()
	{
		try
		{
			fix.fixXY(new int[]{5, 4, 9, 4, 9}, 4, 5);
		}
		catch(AssertionError error)
		{
			assertEquals("Unequal number of X and Y", error.getMessage());
		}
	}
	
	@Test
	public void testExceptionAdjacentX()
	{
		try
		{
			fix.fixXY(new int[]{5, 4, 4, 5, 9}, 4, 5);
		}
		catch(AssertionError error)
		{
			assertEquals("Two adjacent X values", error.getMessage());
		}
	}
	
	@Test
	public void testExceptionLastIndexX()
	{
		try
		{
			fix.fixXY(new int[]{5, 4, 5, 9, 4}, 4, 5);
		}
		catch(AssertionError error)
		{
			assertEquals("X is at last position", error.getMessage());
		}
	}
}
