package priorityQueue;

public interface PriorityQueue
{

	public boolean enqueue(Job value);
	
	public Job dequeue();
	
	public boolean isEmpty();
	
	public boolean isFull();
}
