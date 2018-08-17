package searches;

/**
 * This class contains methods to perform linear and binary searches.
 * @author Ishita_Mathur
 *
 */
public class Search 
{
	int leftIndex = 0;
	/**
	 * This method performs linear search on an input array.
	 * @param inputArray
	 * @param element, this is the element to be searched in the array. 
	 * @return the index at which the element is found.
	 */
	public int linearSearch(int inputArray[], int element)
	{
		if(inputArray.length == 0)
	        throw new AssertionError("Array is empty");
	    
		if(inputArray.length == leftIndex)
			return -1;
		else if(inputArray[leftIndex] == element)
			return leftIndex;
		else
		{
			leftIndex++;
			return linearSearch(inputArray, element);
		}
	}

	/**
	 * This method performs binary search on an input array.
	 * @param inputArray
	 * @param leftIndex, start index of array.
	 * @param rightIndex, end index of array.
	 * @param element, this is the element to be searched in the array.
	 * @return the index at which the element is found.
	 */
	public int binarySearch(int inputArray[], int leftIndex, int rightIndex, int element)
	{
		if (inputArray.length == 0)
			throw new AssertionError("Array is empty");

		if (leftIndex > rightIndex)
			return -1;

		int middle = (leftIndex + rightIndex) / 2;

		if(inputArray[middle] == element)
			return middle;

		else if(inputArray[middle] > element)
			return binarySearch(inputArray, leftIndex, middle - 1, element);

		else
			return binarySearch(inputArray, middle + 1, rightIndex, element);
	}
}
