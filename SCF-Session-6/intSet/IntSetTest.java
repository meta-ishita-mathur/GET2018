package intSet;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest
{
	IntSet in = new IntSet(new int[]{1, 3, 2, 2, 4, 3, 5});
	
	@Test
	public void testFirstPositiveMember()
	{
		boolean memberFound = in.isMember(3);
		assertEquals(true, memberFound);
	}
	
	@Test
	public void testSecondPositiveMember()
	{
		boolean memberFound = in.isMember(7);
		assertEquals(false, memberFound);
	}
	
	@Test
	public void testFirstNegativeMember()
	{
		boolean memberFound = in.isMember(6);
		assertNotEquals(true, memberFound);
	}
	
	@Test
	public void testSecondNegativeMember()
	{
		boolean memberFound = in.isMember(2);
		assertNotEquals(false, memberFound);
	}
	
	@Test
	public void testPositiveSize()
	{
		int arraySize = in.size();
		assertEquals(5, arraySize);
	}
	
	@Test
	public void testNegativeSize()
	{
		int arraySize = in.size();
		assertNotEquals(7, arraySize);
	}
	
	@Test
	public void testFirstPositiveSubSet()
	{
		IntSet subArray = new IntSet(new int[]{2, 6});
		boolean subSet = in.isSubSet(subArray);
		assertEquals(false, subSet);
	}
	
	@Test
	public void testSecondPositiveSubSet()
	{
		IntSet subArray = new IntSet(new int[]{2, 3, 4});
		boolean subSet = in.isSubSet(subArray);
		assertEquals(true, subSet);
	}
	
	@Test
	public void testFirstNegativeSubSet()
	{
		IntSet subArray = new IntSet(new int[]{2, 4});
		boolean subSet = in.isSubSet(subArray);
		assertNotEquals(false, subSet);
	}
	
	@Test
	public void testSecondNegativeSubSet()
	{
		IntSet subArray = new IntSet(new int[]{4, 9});
		boolean subSet = in.isSubSet(subArray);
		assertNotEquals(true, subSet);
	}
	
	@Test
	public void testNullSubSet()
	{
		IntSet subArray = new IntSet(new int[]{});
		boolean subSet = in.isSubSet(subArray);
		assertEquals(true, subSet);
	}
	
	@Test
	public void testComplementPositive()
	{
		int[] complement = in.getComplement();
		assertArrayEquals(new int[]{6, 7, 8, 9, 10}, complement);
	}
	
	@Test
	public void testUnion()
	{
		IntSet firstObject = new IntSet(new int[]{1, 2, 3, 4, 5});
		IntSet secondObject = new IntSet(new int[]{1, 2, 6, 8});
		IntSet ins = new IntSet(new int[]{});
		int[] union = ins.getUnion(firstObject, secondObject);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 8}, union);
	}
}
