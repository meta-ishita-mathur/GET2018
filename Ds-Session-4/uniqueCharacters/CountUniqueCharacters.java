package uniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * counts the number of unique characters in a string
 * @author Ishita_Mathur
 *
 */
public class CountUniqueCharacters
{
	static Map<String, Integer> cache = new HashMap<String, Integer>(); //used to cache the results

	/**
	 * method to count the number of unique characters in the given string
	 * @param string
	 * @return count of unique characters
	 * @throws NullPointerException if string is null
	 */
	public static int countUniqueCharacters(String string) throws NullPointerException
	{
		string = string.toUpperCase();
		int count = 0;

		if(cache.containsKey(string))         //check in cache
			count = cache.get(string);
		else
		{
			Set<Character> characterSet = new HashSet<Character>();

			for(Character characterOfString: string.toCharArray())
			{
				if(characterSet.add(characterOfString))
					count++;
			}

			cache.put(string, count);
		}

		return count;
	}
}