package intSet;

import java.util.Arrays;

/**
 * immutable class IntSet which is uses an array to represent a set of integers in the range 1-1000
 * @author Ishita_Mathur
 *
 */
public final class IntSet 
{
	private int[] newArray;
	final private int arraySize;
	
	/**
	 * Constructor of class
	 * @param inputArray, an array containing the elements of set
	 * assume elements are integers
	 */
	public IntSet(int inputArray[])
	{
		arraySize = removeDuplicate(inputArray);
		newArray = new int[arraySize];
		for(int i = 0; i < arraySize; i++)
			newArray[i] = inputArray[i];
	}
	
	/**
	 * This method removes the duplicate values from array.
	 * @param inputArray
	 * @return size of array after removing duplicate elements
	 */
	public int removeDuplicate(int[] inputArray)
	{
		int size;
		
		Arrays.sort(inputArray);
		size = inputArray.length;
		for(int i = 0; i < size - 1; i++)
		{
			for(int j = i + 1; j < size; j++)
			{
				if(inputArray[i] == inputArray[j])
				{
					for(int k = i; k < size - 1; k++)
					{
						inputArray[k] = inputArray[k + 1];
					}
					size--;
				}
			}
		}
		return size;
	}
	
	/**
	 * Finds that whether an element is a member of set
	 * @param element, this is the element to search
	 * @return true if element is present else false
	 */
	public boolean isMember(int element)
	{
		boolean memberFound = false;
		for(int i = 0; i < arraySize; i++)
		{
			if(newArray[i] == element)
				memberFound = true;
		}
		return memberFound;
	}
	
	/**
	 * Finds the size of array
	 * @return size of array
	 */
	public int size()
	{
		return arraySize;
	}
	
	/**
	 * Checks if an array is the subset of a given set
	 * @param subset, object of the subset array
	 * @return true if it is subset else false
	 */
	public boolean isSubSet(IntSet subset)
	{
		int i, j, count = 0;
		boolean result = false;
		
		for(i = 0; i < subset.arraySize; i++)
		{
			for(j = 0; j < this.arraySize; j++)
			{
				if(subset.newArray[i] == this.newArray[j])
				{
					count++;
					break;
				}
			}
		}
		if(count == subset.arraySize)
			result = true;
		
		return result;
	}
	
	/**
	 * finds the complement of an array
	 * @return the complement of array
	 */
	public int[] getComplement()
	{
		boolean found = false;
		int index = 0, upperLimit = 10;
		int[] complement = new int[upperLimit - this.arraySize];
		
		Arrays.sort(this.newArray);
		
		for(int i = 0; i < upperLimit; i++)
		{
			for(int j = 0; j < this.arraySize; j++)
			{
				if(i + 1 == this.newArray[j])
				{
					found = true;
					break;
				}
				else
					found = false;
			}
			if(found == false)
			{
				complement[index] = i + 1;
				index++;
			}
		}
		return complement;
	}
	
	/**
	 * this method is used to find the union of two arrays
	 * @param firstObject, object of first array
	 * @param secondObject, object of second array
	 * @return the union of arrays
	 */
	public int[] getUnion(IntSet firstObject, IntSet secondObject)
	{
		int firstIndex = 0, secondIndex = 0, unionIndex = 0;
		int[] union = new int[firstObject.arraySize + secondObject.arraySize];
		int[] finalUnion;
		Arrays.sort(firstObject.newArray);
		Arrays.sort(secondObject.newArray);
		
		while(firstObject.arraySize > firstIndex && secondObject.arraySize > secondIndex)
		{
			if(firstObject.newArray[firstIndex] < secondObject.newArray[secondIndex])
				union[unionIndex++] = firstObject.newArray[firstIndex++];
				
			else if(firstObject.newArray[firstIndex] > secondObject.newArray[secondIndex])
				union[unionIndex++] = secondObject.newArray[secondIndex++];
				
			else
			{
				union[unionIndex++] = firstObject.newArray[firstIndex++];
				secondIndex++;
			}
		}
		
		while(firstObject.arraySize > firstIndex)
		{
			union[unionIndex++] = firstObject.newArray[firstIndex++];
		}
		
		while(secondObject.arraySize > secondIndex)
		{
			union[unionIndex++] = secondObject.newArray[secondIndex++];
		}
		
		finalUnion = new int[unionIndex];
		for(int i = 0; i < unionIndex; i++)
			finalUnion[i] = union[i];
		return finalUnion;
	}
}
