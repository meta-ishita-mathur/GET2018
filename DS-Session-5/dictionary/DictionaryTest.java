package dictionary;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DictionaryTest
{
	/**
	 * test case for addEntry
	 */
	@Test
	public void addEntryTest()
	{
		try
		{
			Dictionary dictionary = new BSTDictionary("C:\\Users\\ishita\\workspace\\DS-Session5");

			assertTrue(dictionary.addEntry(new DictionaryEntry("hi", "hello")));
			assertTrue(dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore")));
			assertTrue(dictionary.addEntry(new DictionaryEntry("abc", "hello")));
			assertFalse(dictionary.addEntry(new DictionaryEntry("hi", "world"))); //duplicate key
		}
		catch(AssertionError error)
		{
			assertEquals("Duplicate entry", error.getMessage());
		}
	}

	/**
	 * test case for deleteEntry
	 */
	@Test
	public void deleteEntryTest()
	{    
		Dictionary dictionary = new BSTDictionary("C:\\Users\\ishita\\workspace\\DS-Session5");

		dictionary.addEntry(new DictionaryEntry("hi", "hello"));
		dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore"));
		dictionary.addEntry(new DictionaryEntry("abc", "hello"));
		assertTrue(dictionary.deleteEntry("hi"));
		assertTrue(dictionary.deleteEntry("prakalpa"));

		try
		{
			assertFalse(dictionary.deleteEntry("hi")); //key is already deleted
			assertFalse(dictionary.deleteEntry("mango")); //key does not exist
		}
		catch(AssertionError error)
		{
			assertEquals("The given key is not present in the dictionary", error.getMessage());
		}

		try
		{
			assertFalse(dictionary.deleteEntry(null)); //key is null
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid input", error.getMessage());
		}
	}

	/**
	 * test case for getValue
	 */
	@Test
	public void getValueTest()
	{
		Dictionary dictionary = new BSTDictionary("C:\\Users\\ishita\\workspace\\DS-Session5");

		try
		{
			assertEquals("a", dictionary.getValue("good"));
			assertEquals("b", dictionary.getValue("rat"));
			assertEquals(null, dictionary.getValue(null)); //key is null
			assertEquals(null, dictionary.getValue("hi")); //key does not exist
			dictionary.deleteEntry("good");
			dictionary.deleteEntry("rat");
			dictionary.deleteEntry("hire");
			assertEquals(null, dictionary.getValue("good")); //dictionary is empty
		}
		catch(AssertionError error)
		{
			assertEquals("The dictionary is empty!", error.getMessage());
		}
	}

	/**
	 * test case to get all the entries in sorted form
	 */
	@Test
	public void sortedListTestFirst()
	{
		Dictionary dictionary = new BSTDictionary("C:\\Users\\ishita\\workspace\\DS-Session5");
		ArrayList<DictionaryEntry> sortedList = dictionary.getSortedList();
		ArrayList<DictionaryEntry> expectedList = new ArrayList<DictionaryEntry>();

		dictionary.addEntry(new DictionaryEntry("hi", "hello"));
		dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore"));
		dictionary.addEntry(new DictionaryEntry("abc", "hello"));

		expectedList.add(new DictionaryEntry("abc", "hello"));
		expectedList.add(new DictionaryEntry("good", "a"));
		expectedList.add(new DictionaryEntry("hi", "hello"));
		expectedList.add(new DictionaryEntry("hire", "c"));
		expectedList.add(new DictionaryEntry("prakalpa", "rathore"));
		expectedList.add(new DictionaryEntry("rat", "b"));

		for(int i = 0; i < sortedList.size(); i++)
		{
			assertEquals(expectedList.get(i).getKey(), sortedList.get(i).getKey());
		}
	}

	/**
	 * test case to get entries in sorted form between firstKey and secondKey
	 */
	@Test
	public void sortedListTestSecond()
	{
		Dictionary dictionary = new BSTDictionary("C:\\Users\\ishita\\workspace\\DS-Session5");
		ArrayList<DictionaryEntry> sortedList = dictionary.getSortedList("a", "r");
		ArrayList<DictionaryEntry> expectedList = new ArrayList<DictionaryEntry>();

		dictionary.addEntry(new DictionaryEntry("hi", "hello"));
		dictionary.addEntry(new DictionaryEntry("prakalpa", "rathore"));
		dictionary.addEntry(new DictionaryEntry("abc", "hello"));

		expectedList.add(new DictionaryEntry("abc", "hello"));
		expectedList.add(new DictionaryEntry("good", "a"));
		expectedList.add(new DictionaryEntry("hi", "hello"));
		expectedList.add(new DictionaryEntry("hire", "c"));
		expectedList.add(new DictionaryEntry("prakalpa", "rathore"));       

		for(int i = 0; i < sortedList.size(); i++)
		{
			assertEquals(expectedList.get(i).getKey(), sortedList.get(i).getKey());
		}
	}
}
