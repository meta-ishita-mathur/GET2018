package factoryAssignment;

import java.util.ArrayList;

/**
 * this class creates objects of various shape types
 * @author Ishita_Mathur
 */
public class ShapeFactory
{
	/**
     	 * method to create the object of specified shape type
     	 * @param shapeType
     	 * @param origin
     	 * @param parameters, list of parameters vary according to shape type
     	 * @return
     	 */
	public static Shape createShape(Point origin, ShapeType shapeType, ArrayList<Double> parameterList)
	{
		switch(shapeType)
		{
			// parameters contains radius
			case CIRCLE : return new Circle(parameterList.get(0), origin);
			
			// parameters contains width, height
			case RECTANGLE : return new Rectangle(parameterList.get(0), parameterList.get(1), origin);
			
			// parameters contains side
			case SQUARE : return new Square(parameterList.get(0), origin);
			
			// parameters contains length of firstSide, length of secondSide, length of thirdSide
			case TRIANGLE : return new Triangle(parameterList.get(0), parameterList.get(1), parameterList.get(2), origin);
			
			// parameters contains no. of sides, length of side   
	        	case POLYGON : return new Polygon(parameterList.get(0), parameterList.get(1), origin);
			
	        	default : throw new AssertionError("No such shape found");
		}	
	}
}
