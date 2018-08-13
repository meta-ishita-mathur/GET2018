package nestedList;

import static org.junit.Assert.*;
import org.junit.Test;

public class NestedListTest
{
	/**
	 * test cases for NestedListImplementation
	 */
	@Test
	public void nestedListImplementationTest()
	{
		NestedList nestedList = new NestedListImplementation("nestedListTest.json");

		assertEquals(207, nestedList.sumOfList()); //sum of list test
		assertEquals(99, nestedList.largestValue()); //largest value test
		assertTrue(nestedList.searchValue(99)); //positive test for search value
		assertFalse(nestedList.searchValue(12)); //negative test for search value
	}

	/**
	 * positive test case for getValue method of NestedListSearch
	 */
	@Test
	public void nestedListSearchTest1()
	{
		NestedListImplementation nestedList = new NestedListImplementation("nestedListTest.json");
		NestedListSearch search = new NestedListSearch(nestedList);
		assertEquals(1, search.getValue("thh"));
	}

	/**
	 * negative test case for getValue method of NestedListSearch when we get value while expecting list
	 */
	@Test
	public void nestedListSearchTest2()
	{
		try
		{
			NestedListImplementation nestedList = new NestedListImplementation("nestedListTest.json");
			NestedListSearch search = new NestedListSearch(nestedList);
			search.getValue("thht");
		}
		catch(AssertionError error)
		{
			assertEquals("Wrong input", error.getMessage());
		}
	}

	/**
	 * negative test case for getValue method of NestedListSearch when we get list while expecting value
	 */
	@Test
	public void nestedListSearchTest3()
	{
		try
		{
			NestedListImplementation nestedList = new NestedListImplementation("nestedListTest.json");
			NestedListSearch search = new NestedListSearch(nestedList);
			search.getValue("tt");
		}
		catch(AssertionError error)
		{
			assertEquals("Wrong input", error.getMessage());
		}
	}
}