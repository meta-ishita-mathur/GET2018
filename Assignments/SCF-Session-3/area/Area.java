package area;

import java.util.Scanner;

/**
 * Calculates area of different shapes.
 * @author Ishita Mathur
 */
class shapesArea
{
	/**
	 * Calculates the area of triangle
	 * @param width, width > 0
	 * @param height, height > 0
	 * @return area of triangle
	 */
	public double triangleArea(double width, double height) throws ArithmeticException
	{
		return 0.5 * width * height;
	}
	
	/**
	 * Calculates the area of rectangle
	 * @param width, width > 0
	 * @param height, height > 0
	 * @return area of rectangle
	 */
	public double rectangleArea(double width, double height) throws ArithmeticException
	{
		return width * height;
	}
	
	/**
	 * Calculates the area of square
	 * @param width, width > 0
	 * @return area of square
	 */
	public double squareArea(double width) throws ArithmeticException
	{
		return width * width;
	}
	
	/**
	 * Calculates the area of circle
	 * @param radius, radius > 0
	 * @return area of circle
	 */
	public double circleArea(double radius) throws ArithmeticException
	{
		return 3.14 * radius * radius;
	}
}
public class Area 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		shapesArea area = new shapesArea();
		int choice;
		double width, height, radius;
		do
		{
			System.out.println("MENU");
			System.out.println("1. Area of Triangle");
			System.out.println("2. Area of Rectangle");
			System.out.println("3. Area of Square");
			System.out.println("4. Area of Circle");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
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
						width = sc.nextDouble();
						System.out.println("Area of Square: " + area.squareArea(width));
						break;
					
					case 4: System.out.println("Enter radius of circle: ");
						radius = sc.nextDouble();
						System.out.println("Area of Circle: " + area.circleArea(radius));
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
