package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest
{
	PriorityQueue queue = new PriorityQueueArray(5);

	/**
	 * test case to enqueue a value in queue (return true when element is enqueued and returns false when queue is full)
	 */
	@Test
	public void PriorityQueueEnqueueTest()
	{
		try
		{
			queue.enqueue(new Job(1, 2));
			queue.enqueue(new Job(2, 5));
			queue.enqueue(new Job(3, 4));
			queue.enqueue(new Job(4, 1));
			queue.enqueue(new Job(5, 1));
			queue.enqueue(new Job(6, 5)); //the queue will already be full this time    
		}
		catch(AssertionError error)
		{
			assertEquals("The queue is full!", error.getMessage());
		}
	}

	/**
	 * test case to dequeue a value from the queue
	 */
	@Test
	public void PriorityQueueDequeueTest()
	{
		queue.enqueue(new Job(2, 2));
		queue.enqueue(new Job(3, 1));
		queue.enqueue(new Job(4, 5));
		assertEquals(4, queue.dequeue().getValue());
	}

	/**
	 * test case to dequeue a value from the queue when it is empty
	 */
	@Test
	public void PriorityQueueDequeueTestException()
	{
		try
		{
			PriorityQueue queue = new PriorityQueueArray(5);
			queue.enqueue(new Job(2, 2));
			queue.dequeue();
			queue.dequeue();
		}
		catch(AssertionError error)
		{
			assertEquals("The queue is empty!", error.getMessage());
		}
	}

	/**
	 * test case to check if the queue is empty when actually the queue is not empty
	 */
	@Test
	public void PriorityQueueIsEmptyTestFirst()
	{
		queue.enqueue(new Job(2, 2));
		assertFalse(queue.isEmpty());
	}

	/**
	 * test case to check if the queue is empty when actually the queue is empty
	 */
	@Test
	public void PriorityQueueIsEmptyTestSecond()
	{
		assertTrue(queue.isEmpty());
	}

	/**
	 * test case to check if the queue is full when actually the queue is full
	 */
	@Test
	public void PriorityQueueIsFullTestFirst()
	{
		queue.enqueue(new Job(2, 2));
		queue.enqueue(new Job(2, 2));
		queue.enqueue(new Job(2, 2));
		queue.enqueue(new Job(2, 2));
		queue.enqueue(new Job(2, 2));
		assertTrue(queue.isFull());
	}

	/**
	 * test case to check if the queue is full when actually the queue is not full
	 */
	@Test
	public void PriorityQueueIsFullTestSecond()
	{
		assertFalse(queue.isFull());

		queue.enqueue(new Job(2, 2));
		assertFalse(queue.isFull());

		try
		{
			queue.enqueue(new Job(2, 2));
			queue.enqueue(new Job(2, 2));
			queue.enqueue(new Job(2, 2));
			queue.enqueue(new Job(2, 2));
			queue.enqueue(new Job(2, 2));
			queue.dequeue();
			queue.dequeue();
		}
		catch(AssertionError error)
		{
			assertEquals("The queue is full!", error.getMessage());
		}
	}  
}
