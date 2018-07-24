package string;

import java.util.Scanner;

/**
 * This class performs operations on strings without using Java APIs.
 * @author Ishita Mathur
 *
 */
public class MyString 
{
	/**
	 * Calculates length of string
	 * @param string, string != null
	 * @return length of string
	 */
	public int stringLength(String string)
	{
		string = string + '\0'; //add null to the given string
		int count = 0;

		for (int i = 0; string.charAt(i) != '\0'; i++) 
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
	public int compareStrings(String string1, String string2) throws ArithmeticException
	{
		int equal = 1;
		int string1Length = stringLength(string1);
		int string2Length = stringLength(string2);
		
		if(string1Length != string2Length)
			equal = 0;
		else
		{
			for(int i = 0; i < string1Length; i++)
			{
				if(string1.charAt(i) != string2.charAt(i))
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
	public String reverseString(String string) throws ArithmeticException
	{
		String reverse = "";
		int stringLength = stringLength(string);
		
		for(int i = stringLength - 1; i >= 0; i--)
		{
			reverse += string.charAt(i);
		}
		return reverse;
	}
	
	/**
	 * converts the lower case character to upper case in a string and vice-versa
	 * @param string !=0
	 * @return string after exchanging the case of each character
	 */
	public String caseString(String string) throws ArithmeticException
	{
		int lowerCase, upperCase;
		String changeCase = "";
		int stringLength = stringLength(string);
		
		for(int i = 0; i < stringLength; i++)
		{
			if(string.charAt(i) >= 'a' && string.charAt(i) <= 'z')
			{
				lowerCase = (int) string.charAt(i);
		        	lowerCase = lowerCase - 32;
		        	changeCase += (char)lowerCase;
			}
			else if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z')
			{
				upperCase = (int) string.charAt(i);
		        	upperCase = upperCase + 32;
		        	changeCase += (char)upperCase;
			}
			else
				changeCase += string.charAt(i);
		}
		return changeCase;
	}
	
	/**
	 * finds the largest word from a given string
	 * @param string != 0
	 * @return largest word from sentence
	 */
	public String largestWord(String string) throws ArithmeticException
	{
		string += " ";
		int stringLength = stringLength(string);
		String newString = "", maxWord = "";
		int maxLength = 0, newStringLength;
		
		for(int i = 0; i < stringLength; i++)
		{
			char ch = string.charAt(i);
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

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		MyString my = new MyString();
		int choice;
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Compare two strings");
			System.out.println("2. Reverse of string");
			System.out.println("3. Exchange the case of a string");
			System.out.println("4. Largest word of string");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
	
			try
			{
				switch(choice)
				{
					case 1: System.out.println("Enter two strings:");
						String string1 = sc.next();
						string1 += sc.nextLine();
						String string2 = sc.next();
						string2 += sc.nextLine();
						System.out.println("Strings are equal if 1 and unequal if 0: " + my.compareStrings(string1, string2));
						break;
					
					case 2: System.out.println("Enter the string:");
						String string = sc.next();
						string += sc.nextLine();
						String reverseString = my.reverseString(string);
						System.out.println("Reverse of string is: " + reverseString);
						break;
			
					case 3: System.out.println("Enter the string:");
						String strings = sc.next();
						strings += sc.nextLine();
						String newString = my.caseString(strings);
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
			
		
		}while(choice != 5);

	}
}
