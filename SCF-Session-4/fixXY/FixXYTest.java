package fixXY;

import static org.junit.Assert.*;

import org.junit.Test;

public class FixXYTest 
{
	ArrayFixXY fix = new ArrayFixXY();
	@Test
	public void fixPositiveTest()
	{
		int[] newArray = fix.fixXY(new int[]{5, 4, 9, 4, 9, 5}, 6, 4, 5);
		assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9}, newArray);
	
	}
	
	@Test(expected = AssertionError.class)
	public void testExceptionEmpty()
	{
		int[] newArray = fix.fixXY(new int[]{}, 0, 0, 0);
		assertArrayEquals(new int[]{}, newArray);
	}
	
	@Test(expected = AssertionError.class)
	public void testExceptionUnequal()
	{
		int[] newArray = fix.fixXY(new int[]{5, 4, 9, 4, 9}, 5, 4, 5);
		assertArrayEquals(new int[]{}, newArray);
	}
	
	@Test(expected = AssertionError.class)
	public void testExceptionAdjacentX()
	{
		int[] newArray = fix.fixXY(new int[]{5, 4, 4, 5, 9}, 5, 4, 5);
		assertArrayEquals(new int[]{}, newArray);
	}
	
	@Test(expected = AssertionError.class)
	public void testExceptionLastIndexX()
	{
		int[] newArray = fix.fixXY(new int[]{5, 4, 5, 9, 4}, 5, 4, 5);
		assertArrayEquals(new int[]{}, newArray);
	}

}
