package dataSructure;

public class ArrayImplementationOfQueue implements Queue
{
	int front, rear, size, capacity;
    int array[];
    
    public ArrayImplementationOfQueue(int capacity)
    {
        this.capacity = capacity;
        front = this.size = 0; 
        rear = capacity - 1;
        array = new int[this.capacity];
    }
    
	@Override
	public void push(int element)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int peek() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
