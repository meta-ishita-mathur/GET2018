package dataSructure;

class Node
{
	int data;
	Node next;
};

public class LinkedListImplementationOfStack implements Stack
{
	private Node top;
	
	public LinkedListImplementationOfStack()
	{
		this.top = null;
	}
	
	@Override
	public void push(int element)
	{
		Node node = new Node();
		node.data = element;
		node.next = top;
		top = node;
	}

	@Override
	public int pop()
	{
		int element;
		if(top == null)
			throw new AssertionError("Stack underflow");
		
		element = top.data;
		top = top.next;
		
		return element;
	}
	
	@Override
	public int peek()
	{
		if(!isEmpty())
			return top.data;
		else
			throw new AssertionError("Stack is empty");
	}

	@Override
	public boolean isEmpty()
	{
		return top == null;
	}
}