package clumps;

/**
 * Contains a method to calculate the number of clumps in an array.
 * @author Ishita Mathur
 *
 */
public class ArrayClumps 
{
	/**
	 * This method returns the number of clumps in an array.
	 * @param inputArray, should contain a series of 2 or more adjacent elements of the same value
	 * @param arrayLength > 0
	 * @return the count of clumps in the array.
	 */
	public int countClumps(int[] inputArray)
	{
		int count = 0, clump;
		
		if (inputArray.length == 0)
			throw new AssertionError("Array is empty");
		
		for(int i = 0; i < inputArray.length; i++)
		{
			clump = inputArray[i];
			
			if(i + 1 != inputArray.length && inputArray[i + 1] == clump)
			{
				count++;
				while(i != inputArray.length && inputArray[i] == clump)
				{
					i++;
				}
				i--;
			}
		}
		return count;
	}
}
