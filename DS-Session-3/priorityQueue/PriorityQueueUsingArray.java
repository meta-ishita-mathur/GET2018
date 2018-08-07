package priorityQueue;

class Task
{
    String job;
    int priority;
 
    /** Constructor **/
    public Task(String job, int priority)
    {
        this.job = job;
        this.priority = priority; 
    }
}

public class PriorityQueueUsingArray
{
	private Task[] priorityQueue; 
    private int queueSize, capacity;
 
    /** Constructor **/
    public PriorityQueueUsingArray(int capacity)
    {    
        this.capacity = capacity + 1;
        priorityQueue = new Task[this.capacity];
        queueSize = 0;
    }
    
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return queueSize == 0;
    }
    
    /** function to check if full **/
    public boolean isFull()
    {
        return queueSize == capacity - 1;
    }
    
    /** function to get Size **/
    public int size()
    {
        return queueSize;
    }
    
    /** function to insert task **/
    public void insert(String job, int priority)
    {
    	int position;
        Task newJob = new Task(job, priority);
        
        if(isFull())
    		throw new AssertionError("Queue is full");
        
        priorityQueue[++queueSize] = newJob;
        position = queueSize;
        while (position != 1 && newJob.priority > priorityQueue[position/2].priority)
        {
            priorityQueue[position] = priorityQueue[position/2];
            position /= 2;
        }
        priorityQueue[position] = newJob;    
    }
    
    /** function to remove task **/
    public String remove()
    {
        int parent = 1, child = 2;
        Task item, temp;
        if (isEmpty() )
            throw new AssertionError("Queue is empty");
 
        item = priorityQueue[1];
        temp = priorityQueue[queueSize--];
 
        while (child <= queueSize)
        {
            if (child < queueSize && priorityQueue[child].priority < priorityQueue[child + 1].priority)
                child++;
            if (temp.priority >= priorityQueue[child].priority)
                break;
 
            priorityQueue[parent] = priorityQueue[child];
            parent = child;
            child *= 2;
        }
        priorityQueue[parent] = temp;
 
        return item.job;
    }
}