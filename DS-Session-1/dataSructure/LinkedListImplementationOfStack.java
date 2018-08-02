package dataSructure;

/**
 * this class is used to create a node for the linked list
 * @author Ishita_Mathur
 *
 */
class StackNode
{
	int data;
	StackNode next;
}

/**
 * Class for the linked list implementation of the Stack class
 * @author Ishita_Mathur
 *
 */
public class LinkedListImplementationOfStack implements Stack
{
	private StackNode top;
	
	//constructor
	public LinkedListImplementationOfStack()
	{
		this.top = null;
	}
	
	/**
     	* method to add a value at the top of the stack
     	* @param element
     	*/
	@Override
	public void push(int element)
	{
		StackNode node = new StackNode();
		node.data = element;
		node.next = top;
		top = node;
	}
	
	/**
     	* method to remove a value from the top of the stack
     	* @return value that is removed, and throws assertion error if stack is empty
     	*/
 	@Override
	public int pop()
	{
		int element;
		if(isEmpty())
			throw new AssertionError("Stack underflow");
		
		element = top.data;
		top = top.next;
		
		return element;
	}
	
 	/**
     	* method to view the value at the top of the stack
     	* @return value at top of stack
     	*/
	@Override
	public int peek()
	{
		if(!isEmpty())
			return top.data;
		else
			throw new AssertionError("Stack is empty");
	}
	
	/**
     	* method to check if the stack is empty
     	* @return boolean value
     	*/
 	@Override
	public boolean isEmpty()
	{
		return top == null;
	}
}
