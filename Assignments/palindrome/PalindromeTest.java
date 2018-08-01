package palindrome;

import java.util.Stack;

import java.util.Scanner;

public class PalindromeTest 
{
	public static void main(String[] args)
	{
		String reverseString = "", inputString;
		System.out.println ("Enter any string:");
		Scanner in = new Scanner (System.in);
		inputString = in.nextLine();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < inputString.length(); i++)
		{
			stack.push(inputString.charAt(i));
    		}
		
	    	while(!stack.isEmpty())
	    	{
	    		reverseString = reverseString + stack.pop();
	    	}
	
	    	if(inputString.equals(reverseString))
	    		System.out.println("The input string is a palindrome.");
	    	else
	    		System.out.println("The input string is not a palindrome");
	}
}
