package string;

import java.util.Scanner;

/**
 * This class performs operations on strings without using Java APIs.
 * @author Ishita_Mathur
 *
 */
public class MyString 
{
	/**
	 * Calculates length of string
	 * @param string, string != null
	 * @return length of string
	 */
	public int stringLength(String inputString)
	{
		inputString += '\0'; //add null to the given string
		int count = 0;

		for (int i = 0; inputString.charAt(i) != '\0'; i++) 
		{
			count++;
		}

		return count;
	}
	
	/**
	 * Compares two string for equality
	 * @param string1 != null
	 * @param string2 != null
	 * @return returns 1 if strings are equal and 0 if unequal
	 */
	public int compareStrings(String firstString, String secondString) throws ArithmeticException
	{
		int equal = 1, firstStringLength = stringLength(firstString);
		int secondStringLength = stringLength(secondString);
		
		if(firstStringLength != secondStringLength)
			equal = 0;
		else
		{
			for(int i = 0; i < firstStringLength; i++)
			{
				if(firstString.charAt(i) != secondString.charAt(i))
				{
					equal = 0;
					break;
				}
			}
		}
		return equal;
	}
	
	/**
	 * calculates the reverse of string
	 * @param string != null
	 * @return reverse of string
	 */
	public String reverseString(String inputString) throws ArithmeticException
	{
		String reverse = "";
		int stringLength = stringLength(inputString);
		
		for(int i = stringLength - 1; i >= 0; i--)
		{
			reverse += inputString.charAt(i);
		}
		return reverse;
	}
	
	/**
	 * converts the lower case character to upper case in a string and vice-versa
	 * @param string !=0
	 * @return string after exchanging the case of each character
	 */
	public String caseString(String inputString) throws ArithmeticException
	{
		int lowerCase, upperCase, stringLength = stringLength(inputString), asciiDifference = 32;
		String changeCase = "";
		
		for(int i = 0; i < stringLength; i++)
		{
			if(inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z')
			{
				lowerCase = (int) inputString.charAt(i);
		        	lowerCase = lowerCase - asciiDifference;
		        	changeCase += (char)lowerCase;
		        
			}
			else if(inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
			{
				upperCase = (int) inputString.charAt(i);
		        	upperCase = upperCase + asciiDifference;
		        	changeCase += (char)upperCase;
			}
			else
				changeCase += inputString.charAt(i);
		}
		return changeCase;
	}
	
	/**
	 * finds the largest word from a given string
	 * @param string != 0
	 * @return largest word from sentence
	 */
	public String largestWord(String inputString) throws ArithmeticException
	{
		inputString += " ";
		String newString = "", maxWord = "";
		int maxLength = 0, newStringLength, stringLength = stringLength(inputString);
		
		for(int i = 0; i < stringLength; i++)
		{
			char ch = inputString.charAt(i);
			if(ch != ' ')
				newString += ch;
			else
			{
				newStringLength = stringLength(newString);
				
				if(newStringLength >= maxLength)
				{
					maxLength = newStringLength;
					maxWord = newString;
				}
				newString = "";
            		}
        	}
        	return maxWord;
	}

}

class MyStringMain
{
	public static void main(String[] args)
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		MyString my = new MyString();
		
		do
		{
			System.out.println("MENU\n");
			System.out.print("1. Compare two strings\n2. Reverse of string\n");
			System.out.print("3. Exchange the case of a string\n4. Largest word of string\n5. Exit\n");
			System.out.print("Enter your choice:");
			choice = sc.nextInt();
			try
			{
				switch(choice)
				{
					case 1: System.out.println("Enter two strings:");
						String firstString = sc.next();
						firstString += sc.nextLine();
						String secondString = sc.next();
						secondString += sc.nextLine();
						System.out.println("Strings are equal if 1 and unequal if 0: " + my.compareStrings(firstString, secondString));
						break;
					
					case 2: System.out.println("Enter the string:");
						String inputString = sc.next();
						inputString += sc.nextLine();
						String reverseString = my.reverseString(inputString);
						System.out.println("Reverse of string is: " + reverseString);
						break;
			
					case 3: System.out.println("Enter the string:");
						String newInputString = sc.next();
						newInputString += sc.nextLine();
						String newString = my.caseString(newInputString);
						System.out.println("The new string is :" + newString);
						break;
					
					case 4: System.out.println("Enter the string:");
						String sentence = sc.next();
						sentence += sc.nextLine();
						String maxString = my.largestWord(sentence);
						System.out.println("Largest word is: " + maxString);
						break;
					
					case 5: break;
			
					default: System.out.println("Wrong input!! Try again!!");	
				}
			}
			catch(ArithmeticException exception)
			{
				System.out.println("Arithmetic exception encountered");
			}
		}while(choice != 5)
	}
}
