package factoryAssignment;

public class Triangle implements Shape
{
	private double firstSide, secondSide, thirdSide;
	private Point origin;
	
	public Triangle(double firstSide, double secondSide, double thirdSide, Point origin)
	{
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
		this.origin = origin;
	}
	
	public double getArea()
	{
		double halfPerimeter = getPerimeter() / 2;
		return(Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide)));	
	}
	
	public double getPerimeter()
	{
		return firstSide + secondSide + thirdSide;
	}
	
	public Point getOrigin()
	{
		return origin;
	}
	
	public double getOriginDistance()
	{
		return Math.sqrt((Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2))); 
	}
	
	public ShapeType getShape()
	{
		return ShapeType.TRIANGLE;
	}
	
	public boolean isPointEnclosed(Point point)
	{
		boolean enclosed = false;
		Point secondPoint = new Point(origin.getX() + firstSide, origin.getY());
		double height = 2 * getArea() / firstSide;
		Point thirdPoint = new Point(origin.getX() + Math.sqrt(Math.pow(secondSide, 2) - Math.pow(height - origin.getY(), 2)), height);
		double firstArea = Math.abs(origin.getX() * (height - point.getY()) + thirdPoint.getX() * (point.getY() - origin.getY()) + point.getX() * (origin.getY() - thirdPoint.getY()) / 2.0);
		double secondArea = Math.abs(secondPoint.getX() * (height - point.getY()) + thirdPoint.getX() * (point.getY() - secondPoint.getY()) + point.getX() * (secondPoint.getY() - thirdPoint.getY()) / 2.0);
		double thirdArea = Math.abs(origin.getX() * (point.getY() - secondPoint.getY()) + point.getX() * (secondPoint.getY() - origin.getY()) + secondPoint.getX() * (origin.getY() - point.getY()) / 2.0);
		
		if(firstArea + secondArea + thirdArea == getArea())
		{
			enclosed = true;
		}
		return enclosed;
	}
}