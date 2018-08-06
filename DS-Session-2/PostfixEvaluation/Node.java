package PostfixEvaluation;

/**
 * this generic class is used to create a node for the linked list
 * @author Ishita_Mathur
 *
 * @param <E> defines the type of value to be stored in the list
 */
public class Node<E> 
{
	 private E value;
	    private Node<E> link;
	    
	    //constructor
	    public Node(E val)
	    {
	        value = val;
	    }  
	    
	    public E getValue() {
	       
	        return value;
	    }

	    public void setValue(E value) {
	        this.value = value;
	    }

	    public Node<E> getLink() {
	        return link;
	    }

	    public void setLink(Node<E> link) {
	        this.link = link;
	    }
}