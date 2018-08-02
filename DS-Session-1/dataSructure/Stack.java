package dataSructure;

/**
 * Interface representing the data structure Stack
 * Stack is based on Last In First Out approach
 * @author Ishita_Mathur
 *
 */
public interface Stack
{
	/**
     	* method to add a value at the top of the stack
     	* @param element
     	*/
	public void push(int element);
	
	/**
     	* method to remove a value from the top of the stack
     	* @return value that is removed
     	*/
	public int pop();
	
	/**
     	* method to view the value at the top of the stack
     	* @return value at top of stack
     	*/
	public int peek();
	
	/**
     	* method to check if the stack is empty
     	* @return boolean value
     	*/
	public boolean isEmpty();
}
