package factoryAssignment;

import java.util.ArrayList;

public class ShapeFactory
{
	public static Shape createShape(Point origin, ShapeType shapeType, ArrayList<Double> parameterList)
	{
		switch(shapeType)
		{
			case CIRCLE : return new Circle(parameterList.get(0), origin);
			
			case RECTANGLE : return new Rectangle(parameterList.get(0), parameterList.get(1), origin);
							 
			case SQUARE : return new Square(parameterList.get(0), origin);
						  
			case TRIANGLE : return new Triangle(parameterList.get(0), parameterList.get(1), parameterList.get(2), origin);
							
			default: throw new AssertionError("No such shape found");
		}	
	}
}
