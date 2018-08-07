package priorityQueue;

public class Job
{
	final int value;
	final int priority;
	
	public Job(int value, int priority)
	{	
		this.value = value;
		this.priority = priority;
	}

	public int getValue()
	{
		return value;
	}

	public int getPriority()
	{
		return priority;
	}
}