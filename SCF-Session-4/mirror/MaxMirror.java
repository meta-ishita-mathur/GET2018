package mirror;

/**
 * This class contains a function to calculate the size of largest mirror in an array. 
 * @author Ishita Mathur
 *
 */
public class MaxMirror 
{
	/**
	 * This function is used to calculate the size of largest mirror in an array.
	 * @param inputArray, this should contain mirror values
	 * @param arrayLength > 0
	 * @return maximum size of mirror 
	 */
	public int maxMirror(int[] inputArray, int arrayLength)
	{
		int maxCount = 1, tempCount, mirrorCount;
		boolean mirrorFlag = false;
		
		if (arrayLength == 0)
			throw new AssertionError("Array is empty");
	   
	    for (int i = 0; i < arrayLength; i++)
	    {
	        tempCount = 1;
	        mirrorCount = i;

	        for (int j = arrayLength - 1; j >= 0; j--)
	        {
	            if (inputArray[mirrorCount] == inputArray[j])
	            {
	                if (mirrorFlag)
	                {
	                    tempCount++;
	                    maxCount = Math.max(tempCount, maxCount);
	                }
	                mirrorFlag = true;
	                mirrorCount++;
	                
	                if (mirrorCount >= arrayLength)
	                    break;
	            }
	            else if (inputArray[i] != inputArray[j] && mirrorFlag)
	            {
	                mirrorFlag = false;
	                mirrorCount = i;
	                tempCount = 1;
	            }
	            else if (j == mirrorCount || j == (mirrorCount+1))
	            {
	                mirrorFlag = false;
	                break;
	            }
	        }
	    }    
	    return maxCount;    
	}
}