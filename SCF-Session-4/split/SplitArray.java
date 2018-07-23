package split;

/**
 * Contains method to split an array from a position
 * so that the sum of the numbers on one side is equal to the sum of the numbers on the other side
 * @author Ishita Mathur
 *
 */
public class SplitArray 
{
	/**
	 * This method finds the index of a place to split the input array so that the
	 * sum of the numbers on one side is equal to the sum of the numbers on the other side
	 * @param inputArray
	 * @param arrayLength > 0
	 * @return the index before which array is split
	 */
	public int split (int[] inputArray, int arrayLength)
	{
		int i, j, k, firstPart, lastPart, result = -1;
		
		if(arrayLength == 0)
			throw new AssertionError("Array is empty");
		
		for(i = 1; i <= arrayLength - 1; i++)
		{
			firstPart = 0;
			lastPart = 0;
			
			for(j = i - 1; j >= 0; j--)
				firstPart += inputArray[j];
			
			for(k = i; k < arrayLength; k++)
				lastPart += inputArray[k];
			
			if(firstPart == lastPart)
				result = i;
		}
		return result;
	}
}