package dataSructure;

public class ArrayImplementationOfStack implements Stack
{
	int arr[];
	int size, index = 0;
	
	public ArrayImplementationOfStack(int size)
	{
		this.size = size;
		arr = new int[size];
	}
	
	@Override
	public void push(int element)
	{
		if(index == size)
			throw new AssertionError("Stack overflow");
		
		arr[index] = element;
		index++;
	}
	
	@Override
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if (index == 0)
			empty = true;
		
		return empty;
	}

	@Override
	public int pop()
	{
		if (isEmpty())
			throw new AssertionError("Stack is empty");
		return arr[--index];
	}
	
	@Override
	public int peek()
	{
		if(!isEmpty())
			return arr[--index];
		else
			throw new AssertionError("Stack is empty");
	}
}