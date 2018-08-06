package PostfixEvaluation;

/**
 * Class for the linked list implementation of the Stack class
 * @author Ishita_Mathur
 *
 * @param <E> defines the type of value to be stored in the stack
 */
public class StackLinkedList<E> implements Stack<E> 
{
	Node<E> top = null;
	
	/**
     * method to add a value at the top of the stack
     * @param value
     * @return true if element is inserted, false otherwise
     */
	public boolean push(E value)
	{ 
		if(top == null)
		{
			top = new Node<E>(value);
			top.setLink(null);
		}
		else
		{
			Node<E> newNode = new Node<E>(value);
			newNode.setLink(top);
			top = newNode;
		}
		
		return true;
	}
	
	
	/**
     * method to remove a value from the top of the stack
     * @return value that is removed, and throws assertion error if stack is empty
     */
	public E pop() throws AssertionError
	{
	    E val;
	    
		if(!isEmpty())
		{
		    val = top.getValue();
	        Node<E> popNode=top;
	        top=popNode.getLink();
	        popNode.setLink(null);
		}
		else
		    throw new AssertionError("The stack is empty!");
		
		return val;
	}
	
	
	/**
     * method to view the value at the top of the stack
     * @return value at top of stack
     */
	public E peek() throws AssertionError
	{
		if(!isEmpty())
			return top.getValue();
		else
		    throw new AssertionError("The stack is empty");
	}
	
	
	/**
     * method to check if the stack is empty
     * @return boolean value
     */
	public boolean isEmpty()
	{
		return top == null;
	}
}
