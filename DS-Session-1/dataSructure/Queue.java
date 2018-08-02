package dataSructure;

/**
 * Interface representing the data structure Queue
 * Queue is based on First In First Out approach
 * @author Ishita_Mathur
 */
public interface Queue
{
	/**
     	* method to add a value at the rear of the queue
     	* @param element
     	*/
	public void push(int element);
	
	/**
     	* method to remove a value from the front of the queue
     	* @return value that is removed
     	*/
	public int pop();
	
	/**
	* reads the value at front of the queue
	* @return the value at front
	*/
	public int peek();
	
	/**
     	* method to check if the queue is empty
     	* @return boolean value true if empty else false
     	*/
	public boolean isEmpty();
	
	/**
     	* method to check if the queue is full
     	* @return boolean value true if full else false
     	*/
	public boolean isFull();
}
