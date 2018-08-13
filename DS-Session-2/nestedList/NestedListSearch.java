package nestedList;

import java.util.LinkedList;
import java.util.List;

/**
 * class to find the value at the specified position from the nested list
 * @author Ishita_Mathur
 *
 */
public class NestedListSearch
{
	NestedListImplementation nestedList; //to store the nested list
	Long value; //to store the retrieved value

	/**
	 * constructor
	 * @param nestedList
	 */
	public NestedListSearch(NestedListImplementation nestedList) 
	{
		this.nestedList = nestedList;
	}

	/**
	 * method that returns the value from the specified position in the nested list
	 * @param position, which is a String containing {H, T}
	 * @return value
	 * @throws AssertionError if the position specified is wrong
	 */
	public long getValue(String position)
	{
		getValue(nestedList.getNestedList(), position);
		return value;
	}

	/**
	 * helper method that returns the value from the specified position in the nested list
	 * @param nestedList
	 * @param position
	 * @throws AssertionError if the position specified is wrong
	 */
	private void getValue(List<Object> nestedList, String position)
	{
		int lengthOfString = position.length();

		if(lengthOfString > 1)
		{
			if(position.charAt(0) == 'H' || position.charAt(0) == 'h')
			{
				if(nestedList.get(0) instanceof List)
					getValue((List)nestedList.get(0), position.substring(1));
				else
					throw new AssertionError("Wrong input");
			}
			else if(position.charAt(0) == 'T' || position.charAt(0) == 't')
			{
				if(nestedList.get(1) instanceof List)
				{
					List<Object> newList = new LinkedList<>(nestedList);
					newList.remove(0);
					getValue(newList, position.substring(1));
				}
				else
					throw new AssertionError("Wrong input");
			}
			else
				throw new AssertionError("Wrong input");
		}
		else
		{
			if(position.charAt(0) == 'H' || position.charAt(0) == 'h')
			{
				if(nestedList.get(0) instanceof Long)
					value = (Long)nestedList.get(0);
				else
					throw new AssertionError("Wrong input");
			}
			else if(position.charAt(0) == 'T' || position.charAt(0) == 't')
			{
				if(nestedList.get(1) instanceof Long)
					value = (Long)nestedList.get(1);
				else
					throw new AssertionError("Wrong input");
			}
			else
				throw new AssertionError("Wrong input");
		}	
	}
}