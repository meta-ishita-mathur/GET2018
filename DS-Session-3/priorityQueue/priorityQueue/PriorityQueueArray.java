package priorityQueue;

public class PriorityQueueArray implements PriorityQueue
{
	private Job[] priorityQueue;
	private int rear, front, maxSize;


	public PriorityQueueArray(int maxSize)
	{
		this.maxSize = maxSize;
		priorityQueue = new Job[maxSize];
		rear = -1;
		front = -1;
	}

	public void enqueue(Job jobObj)
	{
		int position = -1;
		if(isFull())
		{
			throw new AssertionError("The queue is full!");
		}
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

	public boolean isEmpty()
	{
		boolean isEmpty = false;

		if(rear == -1 && front == -1)
			isEmpty = true;

		return isEmpty;
	}

	public boolean isFull()
	{
		return (rear + 1) % maxSize == front;
	}
}
