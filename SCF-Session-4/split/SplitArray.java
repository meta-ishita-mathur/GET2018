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
	 * @return the index before which array is split
	 */
	public int split (int[] inputArray)
	{
		int index = -1, mid = 1, sumLeft, sumRight;

		if(inputArray.length == 0)
			throw new AssertionError("Array is empty");
		
		while(mid<inputArray.length)
		{
			sumLeft = sumArray(inputArray, 0, mid-1);
			sumRight = sumArray(inputArray, mid, inputArray.length-1);
			
			if(sumLeft == sumRight)
			{
				index = mid;
				break;
			}
			else
				if(sumLeft > sumRight)
					break;
				else
					mid++;
		}	
		return index;
	}
	
	/**
	 * method to find sum of elements between indexes start & end
	 * @param array
	 * @param start
	 * @param end
	 * @return sum
	 */
	public int sumArray(int[] array, int start, int end)
	{
		int sum = 0;
		
		for(int i=start; i<=end; i++)
			sum += array[i];
		
		return sum;
	}
}
