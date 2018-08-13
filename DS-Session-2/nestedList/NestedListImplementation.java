package nestedList;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * class to implement the NestedList interface
 * @author Ishita_Mathur
 *
 */
public class NestedListImplementation implements NestedList{

	List<Object> nestedList = new LinkedList<>();
	long sum = 0, max = Long.MIN_VALUE;

	/**
	 * constructor that creates the nested list from the provided json file
	 * @param fileLocation
	 */
	public NestedListImplementation(String fileLocation) 
	{
		JSONParser parser = new JSONParser();
		try 
		{
			Object object = parser.parse(new FileReader(fileLocation));
			JSONObject jsonObject = (JSONObject) object;

			nestedList = createNestedList(jsonObject);
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
	}

	/**
	 * getter method for the nested list
	 * @return nestedList
	 */
	public List<Object> getNestedList()
	{
		return nestedList;
	}

	/**
	 * returns the sum of all values in the nested list
	 * @return sum
	 */
	public long sumOfList()
	{
		return sum;
	}

	/**
	 * returns the largest value in the nested list
	 * @return largest value
	 */
	public long largestValue()
	{
		return max;
	}

	/**
	 * searches for a value in the nested list
	 * @param value
	 * @return true if value is present, false otherwise
	 */
	public boolean searchValue(long value)
	{
		return search(value, nestedList);
	}

	/**
	 * helper method for creating nested list from the given json object
	 * it also calculates the sum of all values and keeps track of the maximum value
	 * @param jsonObject
	 * @return nestedList
	 */
	private List<Object> createNestedList(JSONObject jsonObject)
	{
		LinkedList<Object> nestedList = new LinkedList<>();

		for(Object key: jsonObject.keySet())
		{
			if(jsonObject.get(key) instanceof Long)
			{
				long value = (Long)jsonObject.get(key);
				nestedList.addFirst(value);
				sum += value;
				if(value > max)
					max = value;
			}
			else
			{
				JSONObject newJson = (JSONObject)jsonObject.get(key);
				List<Object> list = createNestedList(newJson);
				nestedList.addFirst(list);
			}
		}
		return nestedList;
	}

	/**
	 * helper method to search a value in the nested list
	 * @param value to be searched
	 * @param list
	 * @return
	 */
	private boolean search(long value, List<Object> list)
	{
		boolean found = false;

		for(Object nestedListValue: list)
		{
			if(nestedListValue instanceof Long)
			{
				if(value == (Long)nestedListValue)
				{
					found = true;
					break;
				}
			}
			else 
			{
				found = search(value, (List)nestedListValue);
			}

			if(found)
				break;			
		}
		return found;
	}
}