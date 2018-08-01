package factoryAssignment;

public class Rectangle implements Shape
{
	private double width, height;
	private Point origin;
	
	public Rectangle(double width, double height, Point origin)
	{
		this.width = width;
		this.height = height;
		this.origin = origin;
	}
	
	public double getArea()
	{
		return width * height;
	}
	
	public double getPerimeter()
	{
		return 2 * (width + height);
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
		return ShapeType.RECTANGLE;
	}
	
	public boolean isPointEnclosed(Point point)
	{
		boolean enclosed = false;
		
		if(point.getX() >= origin.getX() && point.getX() <= (origin.getX() + width) && point.getY() >= origin.getY() && point.getY() <= (origin.getY() + height))
		{
			enclosed = true;
		}
		return enclosed;
	}
}