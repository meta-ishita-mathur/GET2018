package priorityQueue;

/**
 * this class implements the PriorityQueue interface
 * @author Ishita_Mathur
 *
 */
public class PriorityQueueArray implements PriorityQueue
{
	private Job[] priorityQueue;
	private int rear, front, maxSize;

	//constructor
	public PriorityQueueArray(int maxSize)
	{
		this.maxSize = maxSize;
		priorityQueue = new Job[maxSize];
		rear = -1;
		front = -1;
	}

	/**
	 * method to add a job in the queue
	 * @param job
	 * @return true if added, false otherwise
	 */
	public void enqueue(Job jobObj)
	{
		int position = -1;
		if(isFull())
			throw new AssertionError("The queue is full!");
		else
		{
			if(rear == -1)
			{
				front++;
				rear++;
			}
			else
				rear = (rear + 1) % maxSize;

			for(int i = front; i <= (rear - 1) % maxSize; i++)
			{
				if(jobObj.getPriority() > priorityQueue[i].getPriority())
				{
					position = i;
					break;
				}
			}
			if(position != -1)
			{
				for(int i = (rear - 1) % maxSize; i >= position; i--)
				{
					priorityQueue[(i + 1) % maxSize] = priorityQueue[i];
				}
				priorityQueue[position] = jobObj;
			}
			else
				priorityQueue[rear] = jobObj;
		}
	}

	/**
	 * method to remove an element from the queue
	 * @return the removed job
	 */
	public Job dequeue()
	{
		Job jobObj = null;

		if(!isEmpty())
		{
			if(front == rear)
			{
				jobObj = priorityQueue[front];
				front = -1;
				rear = -1;
			}
			else
			{
				jobObj = priorityQueue[front];
				front = (front + 1) % maxSize;
			}
		}
		else
			throw new AssertionError("The queue is empty!");

		return jobObj;
	}

	/**
	 * method to check if the queue is empty
	 * @return boolean value
	 */
	public boolean isEmpty()
	{
		boolean isEmpty = false;

		if(rear == -1 && front == -1)
			isEmpty = true;

		return isEmpty;
	}

	/**
	 * method to check if the queue is full
	 * @return boolean value
	 */
	public boolean isFull()
	{
		return (rear + 1) % maxSize == front;
	}
}
