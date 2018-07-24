package lcmhcf;

/**
 * This class contains methods to find LCM and HCF of two numbers using recursion.
 * @author Ishita Mathur
 *
 */
public class LcmHcf 
{
	static int i = 1;
	/**
	 * This method calculates the LCM of two numbers using recursion.
	 * @param firstNum > 0
	 * @param secondNum > 0
	 * @return LCM of two numbers
	 */
	public int lcm(int firstNum, int secondNum) 
	{
		if(firstNum <= 0 || secondNum <= 0)
			throw new AssertionError("Enter positive number");
		
		if(firstNum % secondNum == 0)
			return firstNum;
	     	else
	        	return lcm(firstNum + firstNum / i++, secondNum);
	}
	
	/**
	 * This method calculates the HCF of two numbers using recursion.
	 * @param firstNum > 0
	 * @param secondNum > 0
	 * @return HCF of two numbers
	 */
	public int hcf(int firstNum, int secondNum)
	{
		if(firstNum <= 0 || secondNum < 0)
			throw new AssertionError("Enter positive number");
		
		if (secondNum != 0)
            		return hcf(secondNum, firstNum % secondNum);
        	else
            		return firstNum;
	}
}
