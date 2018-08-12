package queue;

/**
 * Interface representing the data structure Queue
 * Queue is based on First In First Out approach
 * @author Ishita_Mathur
 *
 * @param <E> defines the type of value to be stored in the stack
 */
public interface Queue<E> 
{
    /**
     * method to add a value at the rear of the queue
     * @param value
     * @return true if element is added to the queue, false otherwise
     */
    public boolean enqueue(E value);
    
    /**
     * method to remove a value from the front of the queue
     * @return value that is removed
     */
    public E dequeue();
    
    /**
     * method to check if the queue is empty
     * @return boolean value
     */
    public boolean isEmpty();
    
    /**
     * method to check if the queue is full
     * @return boolean value
     */
    public boolean isFull();   
}
