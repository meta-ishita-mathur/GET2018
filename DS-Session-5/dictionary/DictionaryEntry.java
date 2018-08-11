package dictionary;

/**
 * class for creating an entry, i.e key-value pair
 * @author Ishita_Mathur
 *
 */
public class DictionaryEntry
{
	final String key, value;

	/**
	 * constructor
	 * @param key
	 * @param value
	 */
	public DictionaryEntry(String key, String value)
	{    
		this.key = key;
		this.value = value;
	}

	/**
	 * getter method for key
	 * @return key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * getter method for value
	 * @return value
	 */
	public String getValue()
	{
		return value;
	}
}
