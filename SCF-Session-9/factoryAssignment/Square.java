package factoryAssignment;

public class Square implements Shape
{
	private double side;
	private Point origin;
	
	public Square(double side, Point origin)
	{
		this.side = side;
		this.origin = origin;
	}
	
	public double getArea()
	{
		return side * side;
	}
	
	public double getPerimeter()
	{
		return 4 * side;
	}
	
	public Point getOrigin()
	{
		return origin;
	}
	
	public ShapeType getShape()
	{
		return ShapeType.SQUARE;
	}
	
	public double getOriginDistance()
	{
		return Math.sqrt((Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2))); 
	}
	
	public boolean isPointEnclosed(Point point)
	{
		boolean enclosed = false;
		
		if(point.getX() >= origin.getX() && point.getX() <= (origin.getX() + side) && point.getY() >= origin.getY() && point.getY() <= (origin.getY() + side))
		{
			enclosed = true;
		}
		return enclosed;
	}
}
