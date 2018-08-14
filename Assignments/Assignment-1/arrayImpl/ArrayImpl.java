package arrayImpl;

class Stack
{
	int arr[];
	int size,index=0;
	
	public Stack(int size)
	{
		this.size=size;
		arr = new int[size];
	}
	
	public boolean isFull()
	{
		if(index==size)
			return true;
		else
			return false;
	}
	public void push(int element)
	{
		if(isFull())
		{
			System.out.println("Stack overflow");
		}
		arr[index]=element;
		index++;
	}
	
	public boolean isEmpty()
	{
		if (index==0)
			return true;
		else
			return false;
	}
	
	
	public int pop()
	{
		if (isEmpty())
		{
			System.out.println("Stack is empty");
		}
		return arr[--index];
	}
}
public class ArrayImpl 
{
	public static void main(String[] args)
	{
		Stack stack = new Stack(5);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		System.out.println("Pop elements from stack: ");
		
		while (!stack.isEmpty())
		{
			System.out.printf("%d", stack.pop());
		}
		
	}

}
