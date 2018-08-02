package dataSructure;

/**
 * this class is used to create a node for the linked list
 * @author Ishita_Mathur
 *
 */
class Node
{ 
	int data;
	Node next;
	
	//constructor
	public Node(int element)
    	{
        	data = element;
        	next = null;
    	}
}

/**
 * Class for the linked list implementation of the Queue class
 * @author Ishita_Mathur
 *
 */
public class LinkedListImplementationOfQueue implements Queue
{
	Node front, rear;
	
	//constructor
	public LinkedListImplementationOfQueue()
	{
		this.front = null;
		this.rear = null;
	}

	/**
     	 * method to add a value at the rear of the queue
     	 * @param element
     	 */
	@Override
	public void push(int element)
	{
		Node newNode = new Node (element);
		
		if (isEmpty())
            		front = rear = newNode;
        	else
        	{
            		rear.next = newNode;
            		rear = newNode;
        	}
	}

	/**
     	* method to remove a value from the front of the queue
     	* @return value that is removed, and throws an AssertionError if queue is empty
     	*/
	@Override
	public int pop()
	{
		int element;
		
		if(isEmpty())
            		throw new AssertionError("Queue is Empty");
        	else
        	{
            		element = front.data;
            		front = front.next;
            		return element;
        	}
	}

	/**
	 * @return value at the front of queue, and AssertionError if queue is empty 
	 */
	@Override
	public int peek()
	{
		if(isEmpty())
			throw new AssertionError("Queue is Empty");
        	else
            		return front.data;
	}

	/**
     	* method to check if the queue is empty
     	* @return boolean value
     	*/
	@Override
	public boolean isEmpty()
	{
		boolean status = false;
		if (front == null || rear == null)
            		status = true;
        	return status;
	}
	
	/**
     	* method to check if the queue is full
     	* @return boolean value
     	*/
	@Override
	public boolean isFull()
	{
		return false;
	}
}
