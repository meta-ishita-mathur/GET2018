package dataSructure;

/**
 * Class for the array implementation of the Stack class
 * @author Ishita_Mathur
 *
 */
public class ArrayImplementationOfStack implements Stack
{
	int stackArray[];
	int size, index = 0;
	
	//constructor
	public ArrayImplementationOfStack(int size)
	{
		this.size = size;
		stackArray = new int[size];
	}
	
	/**
     	* method to add a value at the top of the stack
     	* @param element
     	*/
	@Override
	public void push(int element)
	{
		if(index == size)
			throw new AssertionError("Stack overflow");
		
		stackArray[index] = element;
		index++;
	}
	
	/**
     	* method to check if the stack is empty
     	* @return boolean value
     	*/
	@Override
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if (index == 0)
			empty = true;
		
		return empty;
	}

	/**
     	* method to remove a value from the top of the stack
     	* @return value that is removed
     	*/
	@Override
	public int pop()
	{
		if (isEmpty())
			throw new AssertionError("Stack is empty");
		return stackArray[--index];
	}
	
	/**
     	* method to view the value at the top of the stack
     	* @return value at top of stack
     	*/
	@Override
	public int peek()
	{
		if(!isEmpty())
			return stackArray[--index];
		else
			throw new AssertionError("Stack is empty");
	}
}
