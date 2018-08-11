package dictionary;

/**
 * class for creating nodes for the Binary Search Tree
 * @author Ishita_Mathur
 *
 */
public class BSTNode
{
	BSTNode left, right;
	DictionaryEntry data;

	/**
	 * constructor
	 * @param data
	 */
	public BSTNode(DictionaryEntry data)
	{      
		this.data = data;
	}

	/**
	 * getter method for left subtree
	 * @return left
	 */
	public BSTNode getLeft()
	{
		return left;
	}

	/**
	 * setter method for left subtree
	 * @param left
	 */
	public void setLeft(BSTNode left)
	{
		this.left = left;
	}

	/**
	 * getter method for right subtree
	 * @return
	 */
	public BSTNode getRight()
	{
		return right;
	}

	/**
	 * setter method for right subtree
	 * @param right
	 */
	public void setRight(BSTNode right)
	{
		this.right = right;
	}

	/**
	 * getter method for data
	 * @return data
	 */
	public DictionaryEntry getData()
	{
		return data;
	}

	/**
	 * setter method for data
	 * @param data
	 */
	public void setData(DictionaryEntry data)
	{
		this.data = data;
	}  
}
