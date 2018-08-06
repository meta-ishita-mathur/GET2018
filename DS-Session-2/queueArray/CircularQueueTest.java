package queueArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest
{
	CircularQueue queueUsingArray = new CircularQueue(5);

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
			assertEquals("Queue Overflow", e.getMessage());
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
			assertEquals("Queue Underflow", e.getMessage());
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
	public void testCircular()
	{
		queueUsingArray.push(3);
		queueUsingArray.push(6);
		queueUsingArray.push(7);
		queueUsingArray.push(2);
		queueUsingArray.push(9);
		assertEquals(3, queueUsingArray.pop());
		assertEquals(6, queueUsingArray.pop());
		assertEquals(7, queueUsingArray.pop());
		assertEquals(2, queueUsingArray.pop());
		assertEquals(9, queueUsingArray.pop());
		queueUsingArray.push(9);
		assertEquals(9, queueUsingArray.pop());
	}
}
