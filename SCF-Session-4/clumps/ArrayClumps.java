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
	public int countClumps(int[] inputArray, int arrayLength)
	{
		int occur = 0, count = 0;
		
		if (arrayLength == 0)
			throw new AssertionError("Array is empty");
		
		for(int i = 0; i < arrayLength; i++)
		{
			for(int j = i + 1; j < arrayLength; j++)
			{
				if(inputArray[i] == inputArray[j])
					occur++;
				else
				{
					if(occur > 0)
					   count++;
					i = j - 1;
					occur = 0;
					break;
				}
			}
			if (i == arrayLength - 1)
			{
				if(occur > 0)
					count++;
			}
		}
		return count;
	}
}
