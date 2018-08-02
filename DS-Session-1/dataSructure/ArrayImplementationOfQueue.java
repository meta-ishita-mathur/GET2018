package dataSructure;

public class ArrayImplementationOfQueue implements Queue
{
	private int capacity;
    	int queueArray[];
    	int front = 0, rear = -1, currentSize = 0;
    
    	public ArrayImplementationOfQueue(int capacity)
    	{
        	this.capacity = capacity;
        	queueArray = new int[this.capacity];
    	}
    
	@Override
	public void push(int element)
	{
		if(isFull())
			throw new AssertionError("Queue Overflow");
		
		else
		{
            		rear++;
            		if(rear == capacity - 1)
                		rear = 0;
            		queueArray[rear] = element;
            		currentSize++;
        	}
	}

	@Override
	public int pop()
	{
		int popElement;
		if (isEmpty())
			throw new AssertionError("Queue Underflow");
		else
		{
			front++;
			currentSize--;
	        	if(front == capacity - 1)
	        	{
	        		popElement = queueArray[front - 1];
	        		front = 0;
	        		return popElement;
	        	}
	        	else
	        		return queueArray[front - 1];
	     	}
	}

	@Override
	public int peek()
	{
		return queueArray[front];
	}

	@Override
	public boolean isEmpty()
	{
		boolean status = false;
        	if (currentSize == 0)
            		status = true;
        	return status;
	}

	@Override
	public boolean isFull()
	{
		boolean status = false;
        	if (currentSize == capacity)
            		status = true;
        	return status;
	}
}
