package hexadecimalCalc;

import java.util.Scanner;

class Functions
{
	public String add(String hexNum1,String hexNum2)
	{
		int decNum1 = hexToDec(hexNum1);
		int decNum2 = hexToDec(hexNum2);
		
		int decAdd = decNum1+decNum2;
		String hexAdd = decToHex(decAdd);
		
		return hexAdd;
		
	}
	
	public String substract(String hexNum1,String hexNum2)
	{
		int decSub=0;
		int decNum1 = hexToDec(hexNum1);
		int decNum2 = hexToDec(hexNum2);
		
		if(decNum1>=decNum2)
		{
			decSub = decNum1-decNum2;
		}
		else
		{
			decSub = decNum2-decNum1;
		}
		
		String hexSub = decToHex(decSub);
		
		return hexSub;
		
	}
	
	public String multiply(String hexNum1,String hexNum2)
	{
		int decNum1 = hexToDec(hexNum1);
		int decNum2 = hexToDec(hexNum2);
		
		int decMul = decNum1*decNum2;
		String hexMul = decToHex(decMul);
		
		return hexMul;
		
	}
	
	public String divide(String hexNum1,String hexNum2)
	{
		int decDiv=0;
		int decNum1 = hexToDec(hexNum1);
		int decNum2 = hexToDec(hexNum2);
		
		if(decNum2!=0)
		{
			decDiv = decNum1/decNum2;
		}
		else
		{
			System.out.println("Cannot divide by 0");
		}
		
		String hexDiv = decToHex(decDiv);
		
		return hexDiv;
		
	}
	
	public int hexToDec(String hexNum)
	{
		String digits = "0123456789ABCDEF";
		hexNum = hexNum.toUpperCase();  
        int value = 0;  
        for (int i = 0; i < hexNum.length(); i++)  
        {  
            char character = hexNum.charAt(i);  
            int digit = digits.indexOf(character);  
            value = 16*value + digit;  
        }  
        return value;  
	}
	
	public String decToHex(int decNum)
	{
		int remender;  
	    String hex="";   
	    char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while(decNum>0)  
	    {
	    	remender=decNum%16;   
	        hex=hexchars[remender]+hex;   
	        decNum=decNum/16;  
	    }  
	    return hex;  
	}
	
	public boolean greater(String hexNum1, String hexNum2)
	{
		hexNum1 = removeZeros(hexNum1);
		hexNum2 = removeZeros(hexNum2);
		boolean greaterNum  = false;
		String digits = "0123456789ABCDEF";
		hexNum1 = hexNum1.toUpperCase();
		hexNum2 = hexNum2.toUpperCase();
		
		if(hexNum1.length() > hexNum2.length())
		{
			greaterNum = true;
		}
		else 
			if(hexNum1.length() == hexNum2.length())
		    {
				for(int i = 0 ; i < hexNum1.length() ; i++)
				{
					if(digits.indexOf(hexNum1.charAt(i)) > digits.indexOf(hexNum2.charAt(i)))
					{
						greaterNum = true;
						break;
					}
					else if(hexNum1.charAt(i) == hexNum2.charAt(i))
					{
						continue;
					}
					else
						break;
				}
		    }
		return greaterNum;
	}
	
	public boolean smaller(String hexNum1, String hexNum2)
	{
		hexNum1 = removeZeros(hexNum1);
		hexNum2 = removeZeros(hexNum2);
		boolean smallerNum  = false;
		String digits = "0123456789ABCDEF";
		hexNum1 = hexNum1.toUpperCase();
		hexNum2 = hexNum2.toUpperCase();
		
		if(hexNum1.length() < hexNum2.length())
		{
			smallerNum = true;
		}
		else 
			if(hexNum1.length() == hexNum2.length())
		    {
				for(int i = 0 ; i < hexNum1.length() ; i++)
				{
					if(digits.indexOf(hexNum1.charAt(i)) < digits.indexOf(hexNum2.charAt(i)))
					{
						smallerNum = true;
						break;
					}
					else if(hexNum1.charAt(i) == hexNum2.charAt(i))
					{
						continue;
					}
					else
						break;
				}
		    }
		return smallerNum;
	}
	
	public boolean equality(String hexNum1, String hexNum2)
	{
		hexNum1 = removeZeros(hexNum1);
		hexNum2 = removeZeros(hexNum2);
		boolean equal = false;
		
		if(hexNum1.equals(hexNum2))
		{
			equal = true;
		}
		
		return equal;
	}
	
	public String removeZeros(String hexNum)
	{
		int i = 0;
		String newString = "";
		while(hexNum.charAt(i) == '0')
		{
			i++;
		}
		while(i<hexNum.length())
		{
			newString += hexNum.charAt(i);
			i++;
		}
		
		return newString;
	}
}


public class HexCalc 
{
	public static void main(String[] args)
	{
		int decNum, choice;
		String hexNum, hexNum1, hexNum2;
		
		Functions fun = new Functions();
		
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Add");
			System.out.println("2. Substract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Hexadecimal to Decimal");
			System.out.println("6. Decimal to Hexadecimal");
			System.out.println("7. Greater Hexadecimal number");
			System.out.println("8. Smaller Hexadecimal number");
			System.out.println("9. Check for Equal Hexadecimal number");
			System.out.println("10. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
		
			switch(choice)
			{
				case 1: System.out.println("Enter two hexadecimal numbers:");
						hexNum1 = sc.next();
						hexNum2 = sc.next();
						String hexAdd = fun.add(hexNum1, hexNum2);
						System.out.println("Addition:" + hexAdd);
						break;
						
				case 2: System.out.println("Enter two hexadecimal numbers:");
				        hexNum1 = sc.next();
				        hexNum2 = sc.next();
				        String hexSub = fun.substract(hexNum1, hexNum2);
						System.out.println("Substraction:" + hexSub);
						break;
						
				case 3: System.out.println("Enter two hexadecimal numbers:");
						hexNum1 = sc.next();
						hexNum2 = sc.next();
						String hexMul = fun.multiply(hexNum1, hexNum2);
						System.out.println("Multiplication:" + hexMul);
						break;
						
				case 4: System.out.println("Enter two hexadecimal numbers:");
						hexNum1 = sc.next();
						hexNum2 = sc.next();
						String hexDiv = fun.divide(hexNum1, hexNum2);
						System.out.println("Division:" + hexDiv);
						break;
						
				case 5: System.out.println("Enter hexadecimal number:");
						hexNum = sc.next(); 
						decNum = fun.hexToDec(hexNum);
						System.out.println("Decimal value:" + decNum);
						break;
						
				case 6: System.out.println("Enter decimal number:");
						decNum = sc.nextInt(); 
						hexNum = fun.decToHex(decNum);
						System.out.println("Hexadecimal value:" + hexNum);
						break;
						
				case 7: System.out.println("Enter two hexadecimal numbers:");
		         		hexNum1 = sc.next();
		         		hexNum2 = sc.next();
		         		boolean hexGreater = fun.greater(hexNum1, hexNum2);
		         		System.out.println("Hexadecimal number 1 Greater:" + hexGreater);
		         		break;
						
				case 8: System.out.println("Enter two hexadecimal numbers:");
         		 		hexNum1 = sc.next();
         		 		hexNum2 = sc.next();
         		 		boolean hexSmaller = fun.smaller(hexNum1, hexNum2);
         		 		System.out.println("Hexadecimal number 1 Smaller:" + hexSmaller);
         		 		break;
         		 		
				case 9: System.out.println("Enter two hexadecimal numbers:");
         		 		hexNum1 = sc.next();
         		 		hexNum2 = sc.next();
         		 		boolean hexEqual = fun.equality(hexNum1, hexNum2);
         		 		System.out.println("Hexadecimal numbers equal:" + hexEqual);
         		 		break;
				
				case 10: break;
				
				default: System.out.println("Wrong input!! Try again!!");
			}
		}while(choice != 10);
	}
}