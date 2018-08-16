package area;

import java.util.Scanner;

/**
 * Calculates area of different shapes.
 * @author Ishita_Mathur
 */
class shapesArea
{
	/**
	 * Calculates the area of triangle
	 * @param width, width > 0
	 * @param height, height > 0
	 * @return area of triangle
	 */
	static final float PI = 3.14f, HALF = 0.5f;
	
	public double triangleArea(double width, double height) throws ArithmeticException
	{
		if (width < 0 || height < 0)
			throw new AssertionError("Enter positive number");
		
		return HALF * width * height;
	}
	
	/**
	 * Calculates the area of rectangle
	 * @param width, width > 0
	 * @param height, height > 0
	 * @return area of rectangle
	 */
	public double rectangleArea(double width, double height) throws ArithmeticException
	{
		if (width < 0 || height < 0)
			throw new AssertionError("Enter positive number");
		
		return width * height;
	}
	
	/**
	 * Calculates the area of square
	 * @param width, width > 0
	 * @return area of square
	 */
	public double squareArea(double width) throws ArithmeticException
	{
		if (width < 0)
			throw new AssertionError("Enter positive number");
		
		return width * width;
	}
	
	/**
	 * Calculates the area of circle
	 * @param radius, radius > 0
	 * @return area of circle
	 */
	public double circleArea(double radius) throws ArithmeticException
	{
		if (radius < 0)
			throw new AssertionError("Enter positive number");
		
		return PI * radius * radius;
	}
}
public class Area 
{
	public static void main(String[] args)
	{
		int choice;
		double width, height;
		Scanner sc = new Scanner(System.in);
		shapesArea area = new shapesArea();
		
		do
		{
			System.out.print("MENU\n1. Area of Triangle\n2. Area of Rectangle\n");
			System.out.print("3. Area of Square\n4. Area of Circle\n5. Exit\n");
			System.out.print("Enter your choice:");
			choice = sc.nextInt();
			
		    	try
		    	{
				switch(choice)
			    	{
					case 1: System.out.println("Enter width and height of triangle: ");
						width = sc.nextDouble();
						height = sc.nextDouble();
						System.out.println("Area of Triangle: " + area.triangleArea(width, height));
						break;
					
					case 2: System.out.println("Enter width and height of rectangle: ");
						width = sc.nextDouble();
						height = sc.nextDouble();
						System.out.println("Area of Rectangle: " + area.rectangleArea(width, height));
						break;
					
					case 3: System.out.println("Enter width of square: ");
						System.out.println("Area of Square: " + area.squareArea(sc.nextDouble()));
						break;
					
					case 4: System.out.println("Enter radius of circle: ");
						System.out.println("Area of Circle: " + area.circleArea(sc.nextDouble()));
						break;
					
					case 5: break;
			
					default: System.out.println("Wrong input!! Try again!!");
		    		}
		    }
		    catch(ArithmeticException exception)
		    {
		    	System.out.println("Arithmetic Exception encountered");
		    }
		}while(choice != 5);
	}
}