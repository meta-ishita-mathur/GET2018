package dataSructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueue
{
	ArrayImplementationOfQueue queueUsingArray = new ArrayImplementationOfQueue(5);
	LinkedListImplementationOfQueue queueUsingLinkedList = new LinkedListImplementationOfQueue();
	
	@Test
	public void testPushArray()
	{
		queueUsingArray.push(3);
		queueUsingArray.push(6);
		assertEquals(3, queueUsingArray.peek());
	}
	
	@Test
	public void testPushArrayNegative()
	{
		queueUsingArray.push(3);
		queueUsingArray.push(6);
		assertNotEquals(6, queueUsingArray.peek());
	}
	
	@Test
	public void testPopArray()
	{
		queueUsingArray.push(3);
		queueUsingArray.push(6);
		assertEquals(3, queueUsingArray.pop());
		assertEquals(6, queueUsingArray.peek());
	}
	
	@Test
	public void testPopArrayNegative()
	{
		queueUsingArray.push(3);
		queueUsingArray.push(6);
		assertNotEquals(6, queueUsingArray.pop());
		assertEquals(6, queueUsingArray.peek());
	}
	
	@Test
	public void testPushArrayIfFull()
	{
		try
		{
			queueUsingArray.push(3);
			queueUsingArray.push(6);
			queueUsingArray.push(5);
			queueUsingArray.push(7);
			queueUsingArray.push(2);
			queueUsingArray.push(9);
		}	
		catch(AssertionError e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void testPopAllPresentInArray()
	{
		try
		{
			queueUsingArray.push(3);
			queueUsingArray.push(6);
			queueUsingArray.pop();
			queueUsingArray.pop();
			queueUsingArray.pop();
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}	
	}
	
	@Test
	public void testDeleteAllArray()
	{
		queueUsingArray.push(3);
		queueUsingArray.push(6);
		queueUsingArray.push(7);
		queueUsingArray.push(2);
		queueUsingArray.push(9);
		queueUsingArray.pop();
		queueUsingArray.pop();
		queueUsingArray.pop();
		queueUsingArray.pop();
		assertEquals(9, queueUsingArray.pop());
	}
	
	@Test
	public void testDeleteAllArrayNegative()
	{
		queueUsingArray.push(3);
		queueUsingArray.push(6);
		queueUsingArray.push(7);
		queueUsingArray.push(2);
		queueUsingArray.push(9);
		queueUsingArray.pop();
		queueUsingArray.pop();
		queueUsingArray.pop();
		queueUsingArray.pop();
		assertNotEquals(3, queueUsingArray.pop());
	}
	
	@Test
	public void testPushLinkedList()
	{
		queueUsingLinkedList.push(3);
		queueUsingLinkedList.push(6);
		assertEquals(3, queueUsingLinkedList.peek());
	}
	
	@Test
	public void testPushLinkedListNegative()
	{
		queueUsingLinkedList.push(3);
		queueUsingLinkedList.push(6);
		assertNotEquals(6, queueUsingLinkedList.peek());
	}
	
	@Test
	public void testPopLinkedList()
	{
		queueUsingLinkedList.push(3);
		queueUsingLinkedList.push(6);
		assertEquals(3, queueUsingLinkedList.pop());
		assertEquals(6, queueUsingLinkedList.peek());
	}
	
	@Test
	public void testPopLinkedListNegative()
	{
		queueUsingLinkedList.push(3);
		queueUsingLinkedList.push(6);
		assertNotEquals(6, queueUsingLinkedList.pop());
		assertEquals(6, queueUsingLinkedList.peek());
	}
	
	@Test
	public void testPopAllPresentInLinkedList()
	{
		try
		{
			queueUsingLinkedList.push(3);
			queueUsingLinkedList.push(6);
			queueUsingLinkedList.pop();
			queueUsingLinkedList.pop();
			queueUsingLinkedList.peek();
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}	
	}

	@Test
	public void testDeleteAllLinkedList()
	{
		try
		{
			queueUsingLinkedList.pop();
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void testNoElementLinkedList()
	{
		assertTrue(queueUsingLinkedList.isEmpty());
	}
	
	@Test
	public void testNoElementLinkedListNegative()
	{
		queueUsingLinkedList.push(2);
		assertFalse(queueUsingLinkedList.isEmpty());
	}
}
