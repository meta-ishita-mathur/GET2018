package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest
{
	PriorityQueueUsingArray objPriorityQueue = new PriorityQueueUsingArray(3);

	@Test
	public void testPositive()
	{
		objPriorityQueue.insert("job1", 3);
		objPriorityQueue.insert("job2", 1);
		objPriorityQueue.insert("job3", 2);
		assertEquals("job1", objPriorityQueue.remove());
		assertEquals("job3", objPriorityQueue.remove());
		assertEquals("job2", objPriorityQueue.remove());
	}

	@Test
	public void testIsFull()
	{
		try
		{
			objPriorityQueue.insert("job1", 3);
			objPriorityQueue.insert("job2", 1);
			objPriorityQueue.insert("job3", 2);
			objPriorityQueue.insert("job4", 5);
		}
		catch(AssertionError e)
		{
			assertEquals("Queue is full", e.getMessage());
		}
	}
	
	@Test
	public void testIsEmptyNull()
	{
		try
		{
			objPriorityQueue.insert(null, 3);
		}
		catch(AssertionError e)
		{
			assertEquals("Queue is empty", e.getMessage());
		}
	}
	
	@Test
	public void testIsEmpty()
	{
		try
		{
			objPriorityQueue.insert("job1", 3);
			objPriorityQueue.insert("job2", 1);
			objPriorityQueue.insert("job3", 2);
			assertEquals("job1", objPriorityQueue.remove());
			assertEquals("job3", objPriorityQueue.remove());
			assertEquals("job2", objPriorityQueue.remove());
			objPriorityQueue.remove();
		}
		catch(AssertionError e)
		{
			assertEquals("Queue is empty", e.getMessage());
		}
	}
}