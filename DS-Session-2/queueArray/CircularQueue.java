package queueArray;

/**
 * class for the array implementation of the Queue class
 * @author Ishita_Mathur
 *
 */
public class CircularQueue implements Queue
{
	private int capacity;
	int queueArray[];
	int front = 0, rear = -1, currentSize = 0;

	//constructor
	public CircularQueue(int capacity)
	{
		this.capacity = capacity;
		queueArray = new int[this.capacity];
	}
	
	/**
	 * method to add a value at the rear of the queue
	 * @param element to add
	 * @return AssertionError if queue is full
	 */
	public void push(int element)
	{
		if(isFull())
			throw new AssertionError("Queue Overflow");
		else
		{
			rear++;
			if(rear == capacity)
				rear = 0;
			queueArray[rear] = element;
			currentSize++;
		}
	}

	/**
	 * method to remove a value from the front of the queue
	 * @return value that is removed, and throws an AssertionError if queue is empty
	 */
	public int pop()
	{
		int popElement;
		if (isEmpty())
			throw new AssertionError("Queue Underflow");
		else
		{
			front++;
			currentSize--;
			if(front == capacity)
			{
				popElement = queueArray[front - 1];
				front = 0;
				return popElement;
			}
			else
				return queueArray[front - 1];
		}
	}

	/**
	 * @return the value at front of queue
	 */
	public int peek()
	{
		return queueArray[front];
	}

	/**
	 * method to check if the queue is empty
	 * @return boolean value
	 */
	public boolean isEmpty()
	{
		boolean status = false;
		if (currentSize == 0)
			status = true;
		return status;
	}

	/**
	 * method to check if the queue is full
	 * @return boolean value
	 */
	public boolean isFull()
	{
		boolean status = false;
		if (currentSize == capacity)
			status = true;
		return status;
	}
}