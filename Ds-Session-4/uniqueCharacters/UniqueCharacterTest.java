package uniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterTest {

	/**
	 * test case for countUniqueCharacters when string contains only characters
	 */
	@Test
	public void countUniqueCharactersTestFirst() {

		String string = "Ishita";
		assertEquals(5, CountUniqueCharacters.countUniqueCharacters(string));
	}


	/**
	 * test case for countUniqueCharacters when string contains characters, numbers as well as special characters
	 */
	@Test
	public void countUniqueCharactersTestSecond() {

		String string = "Ishita#1213";
		assertEquals(9, CountUniqueCharacters.countUniqueCharacters(string));
	}


	/**
	 * test case for countUniqueCharacters when string contains words with spaces
	 */
	@Test
	public void countUniqueCharactersTestThird() {

		String string = "Ishita Mathur";
		assertEquals(9, CountUniqueCharacters.countUniqueCharacters(string));
	}

	/**
	 * test case for countUniqueCharacters when string contains words with spaces
	 */
	@Test
	public void countUniqueCharactersNegativeTest() {

		String string = "Ishita Mathur";
		assertNotEquals(10, CountUniqueCharacters.countUniqueCharacters(string));
	}
	
	/**
	 * test case for countUniqueCharacters when string is null
	 */
	@Test(expected = NullPointerException.class)
	public void countUniqueCharactersTestFourth() {

		CountUniqueCharacters.countUniqueCharacters(null);
	}
}