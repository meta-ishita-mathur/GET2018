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
	 * @param inputArray, this should contain mirror value
	 * @return maximum size of mirror 
	 */
	public int maxMirror(int[] inputArray)
	{
		int largestMirrorSection = 0, mirrorSection;
	    
	    	if(inputArray.length == 0)
            		throw new AssertionError("Array is empty");
	      
	    	for(int i = 0; i < inputArray.length; i++)
	    	{
	        	for(int j = inputArray.length - 1; j >= 0; j--)
	        	{
	            		int k = i,location = j;
	            		mirrorSection = 0;
			
	            		while(k < inputArray.length && location >= 0 && inputArray[k] == inputArray[location])
	            		{
	                		mirrorSection++;
	                		k++;
	                		location--;
	            		}         
	            		if(mirrorSection > largestMirrorSection)
	                		largestMirrorSection = mirrorSection;	             
	        	}
	    	}	    
	    	return largestMirrorSection;
	}
}
