package PostfixEvaluation;

/**
 * Interface representing the data structure Stack
 * Stack is based on Last In First Out approach
 * @author Ishita_Mathur 
 *
 * @param <E> defines the type of value to be stored in the stack
 */
public interface Stack<E>
{
	/**
	 * method to add a value at the top of the stack
	 * @param value
	 * @return true if element is inserted, false otherwise
	 */
	public boolean push(E value);


	/**
	 * method to remove a value from the top of the stack
	 * @return value that is removed
	 */
	public E pop();


	/**
	 * method to view the value at the top of the stack
	 * @return value at top of stack
	 */
	public E peek();


	/**
	 * method to check if the stack is empty
	 * @return boolean value
	 */
	public boolean isEmpty();
}