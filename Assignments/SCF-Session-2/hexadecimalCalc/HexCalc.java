package hexadecimalCalc;

import java.util.Scanner;

/**
 * This class performs arithmetic functions on Hexadecimal values.
 * @author Ishita_Mathur
 *
 */
class ArithmeticFunctions
{
	/**
	 * Adds two hexadecimal values.
	 * @param firstHexNum
	 * @param secondHexNum
	 * @return addition of hexadecimal values
	 */
	public String add(String firstHexNum, String secondHexNum)
	{
		int firstDecNum, secondDecNum, decAdd;
		String hexAdd;
		
		firstDecNum = hexToDec(firstHexNum);
		secondDecNum = hexToDec(secondHexNum);
		decAdd = firstDecNum + secondDecNum;
		hexAdd = decToHex(decAdd);
		
		return hexAdd;
		
	}
	
	/**
	 * Subtracts two hexadecimal values.
	 * @param firstHexNum
	 * @param secondHexNum
	 * @return difference of hexadecimal values
	 */
	public String subtract(String firstHexNum, String secondHexNum)
	{
		int decSub, firstDecNum, secondDecNum;
		String hexSub;
		
		firstDecNum = hexToDec(firstHexNum);
		secondDecNum = hexToDec(secondHexNum);
		if(firstDecNum >= secondDecNum)
			decSub = firstDecNum - secondDecNum;
		else
			decSub = secondDecNum - firstDecNum;
		
		hexSub = decToHex(decSub);
		
		return hexSub;
		
	}
	
	/**
	 * Multiplies two hexadecimal values.
	 * @param firstHexNum
	 * @param secondHexNum
	 * @return product of hexadecimal values
	 */
	public String multiply(String firstHexNum, String secondHexNum)
	{
		int firstDecNum, secondDecNum, decMul;
		String hexMul;
		
		firstDecNum = hexToDec(firstHexNum);
		secondDecNum = hexToDec(secondHexNum);
		decMul = firstDecNum * secondDecNum;
		hexMul = decToHex(decMul);
		
		return hexMul;
		
	}
	
	/**
	 * Divides two hexadecimal values.
	 * @param firstHexNum
	 * @param secondHexNum
	 * @return division of hexadecimal values
	 */
	public String divide(String firstHexNum, String secondHexNum)
	{
		int decDiv = 0, firstDecNum, secondDecNum;
		String hexDiv;
		
		firstDecNum = hexToDec(firstHexNum);
		secondDecNum = hexToDec(secondHexNum);
		if(secondDecNum != 0)
			decDiv = firstDecNum / secondDecNum;
		else
			System.out.println("Cannot divide by 0");
		
		hexDiv = decToHex(decDiv);
		
		return hexDiv;
		
	}
	
	/**
	 * Converts hexadecimal value to decimal number.
	 * @param hexNum
	 * @return Decimal number
	 */
	public int hexToDec(String hexNum)
	{
        int value = 0, digit, i;
		String digits = "0123456789ABCDEF";
		char character;
		
		hexNum = hexNum.toUpperCase();  
        for (i = 0; i < hexNum.length(); i++)  
        {
			character = hexNum.charAt(i);  
            digit = digits.indexOf(character);  
            value = 16 * value + digit;  
        }  
        return value;  
	}
	
	/**
	 * Converts decimal numbers to hexadecimal values.
	 * @param decNum
	 * @return Hexadecimal value
	 */
	public String decToHex(int decNum)
	{
		int remainder;  
	    String hex = "";   
	    char hexchars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};  
	    while(decNum > 0)  
	    {
	    	remainder = decNum % 16;   
	        hex = hexchars[remainder] + hex;   
	        decNum = decNum / 16;  
	    }  
	    return hex;  
	}
	
	/**
	 * Finds the greater number between two hexadecimal numbers
	 * @param firstHexNum
	 * @param secondHexNum
	 * @return the greater number
	 */
	public boolean greater(String firstHexNum, String secondHexNum)
	{
		boolean greaterNum  = false;
		String digits = "0123456789ABCDEF";
		
		firstHexNum = removeZeros(firstHexNum);
		secondHexNum = removeZeros(secondHexNum);
		
		firstHexNum = firstHexNum.toUpperCase();
		secondHexNum = secondHexNum.toUpperCase();
		
		if(firstHexNum.length() > secondHexNum.length())
			greaterNum = true;
		else 
			if(firstHexNum.length() == secondHexNum.length())
		    	{
				for(int i = 0; i < firstHexNum.length(); i++)
				{
					if(digits.indexOf(firstHexNum.charAt(i)) > digits.indexOf(secondHexNum.charAt(i)))
					{
						greaterNum = true;
						break;
					}
					else if(firstHexNum.charAt(i) == secondHexNum.charAt(i))
						continue;
					else
						break;
				}
		    	}
			return greaterNum;
	}
	
	/**
	 * Finds the smaller number between two hexadecimal numbers
	 * @param firstHexNum
	 * @param secondHexNum
	 * @return Smaller number
	 */
	public boolean smaller(String firstHexNum, String secondHexNum)
	{
		boolean smallerNum  = false;
		String digits = "0123456789ABCDEF";
		
		firstHexNum = removeZeros(firstHexNum);
		secondHexNum = removeZeros(secondHexNum);
		
		firstHexNum = firstHexNum.toUpperCase();
		secondHexNum = secondHexNum.toUpperCase();
		
		if(firstHexNum.length() < secondHexNum.length())
			smallerNum = true;
		else 
			if(firstHexNum.length() == secondHexNum.length())
		    	{
				for(int i = 0; i < firstHexNum.length(); i++)
				{
					if(digits.indexOf(firstHexNum.charAt(i)) < digits.indexOf(secondHexNum.charAt(i)))
					{
						smallerNum = true;
						break;
					}
					else if(firstHexNum.charAt(i) == secondHexNum.charAt(i))
						continue;
					else
						break;
				}
		    	}
			return smallerNum;
	}
	
	/**
	 * Checks if the two hexadecimal numbers equal.
	 * @param firstHexNum
	 * @param secondHexNum
	 * @return true if equal else false
	 */
	public boolean equality(String firstHexNum, String secondHexNum)
	{
		boolean equal = false;
		
		firstHexNum = removeZeros(firstHexNum);
		secondHexNum = removeZeros(secondHexNum);
	
		if(firstHexNum.equals(secondHexNum))
			equal = true;
		return equal;
	}
	
	/**
	 * Removes the extra Zeros from the beginning of hexadecimal number.
	 * @param hexNum
	 * @return Hexadecimal number after removing zeros
	 */
	public String removeZeros(String hexNum)
	{
		int i = 0;
		String newString = "";
	
		while(hexNum.charAt(i) == '0')
		{
			i++;
		}
		while(i	< hexNum.length())
		{
			newString += hexNum.charAt(i);
			i++;
		}
		return newString;
	}
}

/*
public class HexCalc 
{
	public static void main(String[] args)
	{
		int decNum, choice;
		String hexNum, firstHexNum, secondHexNum;
		
		ArithmeticFunctions fun = new ArithmeticFunctions();
		
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.print("MENU\n");
			System.out.print("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n");
			System.out.print("5. Hexadecimal to Decimal\n6. Decimal to Hexadecimal\n");
			System.out.print("7. Greater Hexadecimal number\n");
			System.out.print("8. Smaller Hexadecimal number\n");
			System.out.print("9. Check for Equal Hexadecimal number\n");
			System.out.print("10. Exit\n");
			System.out.print("Enter your choice:");
			choice = sc.nextInt();
		
			switch(choice)
			{
				case 1: System.out.println("Enter two hexadecimal numbers:");
						firstHexNum = sc.next();
						secondHexNum = sc.next();
						System.out.println("Addition:" + fun.add(firstHexNum, secondHexNum));
						break;
						
				case 2: System.out.println("Enter two hexadecimal numbers:");
						firstHexNum = sc.next();
						secondHexNum = sc.next();
				        System.out.println("Substraction:" + fun.subtract(firstHexNum, secondHexNum));
				        break;
						
				case 3: System.out.println("Enter two hexadecimal numbers:");
						firstHexNum = sc.next();
						secondHexNum = sc.next();
						System.out.println("Multiplication:" + fun.multiply(firstHexNum, secondHexNum));
						break;
						
				case 4: System.out.println("Enter two hexadecimal numbers:");
						firstHexNum = sc.next();
						secondHexNum = sc.next();
						System.out.println("Division:" + fun.divide(firstHexNum, secondHexNum));
						break;
						
				case 5: System.out.println("Enter hexadecimal number:");
						hexNum = sc.next();
						System.out.println("Decimal value:" + fun.hexToDec(hexNum));
						break;
						
				case 6: System.out.println("Enter decimal number:");
						decNum = sc.nextInt();
						System.out.println("Hexadecimal value:" + fun.decToHex(decNum));
						break;
						
				case 7: System.out.println("Enter two hexadecimal numbers:");
						firstHexNum = sc.next();
						secondHexNum = sc.next();
		         		System.out.println("Hexadecimal number 1 Greater:" + fun.greater(firstHexNum, secondHexNum));
		         		break;
						
				case 8: System.out.println("Enter two hexadecimal numbers:");
						firstHexNum = sc.next();
						secondHexNum = sc.next();
         		 		System.out.println("Hexadecimal number 1 Smaller:" + fun.smaller(firstHexNum, secondHexNum));
         		 		break;
         		 		
				case 9: System.out.println("Enter two hexadecimal numbers:");
						firstHexNum = sc.next();
						secondHexNum = sc.next();
         		 		System.out.println("Hexadecimal numbers equal:" + fun.equality(firstHexNum, secondHexNum));
         		 		break;
				
				case 10: break;
				
				default: System.out.println("Wrong input!! Try again!!");
			}
		}while(choice != 10);
	}
}*/