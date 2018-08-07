package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest
{
	PriorityQueue priorityQueue;
	
	@Test
	public void testPositive()
	{
		priorityQueue = new PriorityQueueArray(4);
		
		priorityQueue.enqueue(new Job(2, 2));
		priorityQueue.enqueue(new Job(3, 1));
		priorityQueue.enqueue(new Job(5, 3));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
			
		priorityQueue.enqueue(new Job(3, 1));
		priorityQueue.enqueue(new Job(5, 2));
		priorityQueue.enqueue(new Job(4, 3));
		priorityQueue.enqueue(new Job(6, 4));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		priorityQueue.enqueue(new Job(7, 1));
		priorityQueue.enqueue(new Job(2, 2));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
	}
}
