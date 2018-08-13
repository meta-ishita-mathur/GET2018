package nestedList;

/**
 * interface for performing operations on a nested list of long integers
 * @author Ishita_Mathur
 *
 */
public interface NestedList
{
	/**
	 * returns the sum of all values in the nested list
	 * @return sum
	 */
	public long sumOfList();

	/**
	 * returns the largest value in the nested list
	 * @return largest value
	 */
	public long largestValue();

	/**
	 * searches for a value in the nested list
	 * @param value
	 * @return true if value is present, false otherwise
	 */
	public boolean searchValue(long value);	
}
