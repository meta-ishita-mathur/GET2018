package fixXY;

/**
 * Contains methods to solve fixXY problem.
 * @author Ishita Mathur
 *
 */
public class ArrayFixXY 
{
	/**
	 * Method returns an array that contains exactly the same numbers as the input array,
	 * but rearranged so that every X is immediately followed by a Y.
	 * It does not move X within array, but every other number may move.
	 * 
	 * @param inputArray, should contain equal number of X and Y 
	 * & two adjacent X values should not be there & X should not be at the last position. 
	 * @param arrayLength > 0
	 * @param x, this is the value that should not move.
	 * @param y, this is the value that should come after x.
	 * @return
	 */
	public int[] fixXY(int[] inputArray, int arrayLength, int x, int y)
	{
		if (arrayLength == 0)
			throw new AssertionError("Array is empty");
		for(int j = 0; j < arrayLength - 1; j++)
		{
			if (inputArray[j] == inputArray[j + 1] && inputArray[j] == x)
				throw new AssertionError("Two adjacent X values");
		}
		
		for(int k = 0; k <= arrayLength - 1; k++)
		{
			if (k == arrayLength - 1 && inputArray[k] == x)
				throw new AssertionError("X is at last position");
		}

		for(int i = 0; i < arrayLength - 1; i++)
		{	
			if(inputArray[i] == x)
			{
				if(i != arrayLength - 1 && inputArray[i+1] != x)	
					inputArray = swap(i + 1, inputArray, arrayLength, x, y);
			}
		}
		return inputArray;
	}
	
	/**
	 * This method is used to swap the value of Y at the position after X.
	 * @param index, index with which Y should swap 
	 * @param newArray
	 * @param arrayLength
	 * @param X
	 * @param Y
	 * @return the array after swapping Y with a number after X
	 */
	public int[] swap(int index, int[] newArray, int arrayLength, int X, int Y)
	{
		int tempSwap, findSwap = 0;
		
		for(int i = 0; i < arrayLength; i++)
		{
			if(newArray[i] == Y)
			{
				if(i == 0 || newArray[i-1] != X)
				{
					
					tempSwap = newArray[index];
					newArray[index] = newArray[i];
					newArray[i] = tempSwap;
					findSwap = 1;
				}
			}
		}
		if (findSwap == 0)
			throw new AssertionError("Unequal number of X and Y");
		return newArray;
	}
}