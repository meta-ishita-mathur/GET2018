package factoryAssignment;

public class Circle implements Shape
{
	private double radius;
	private Point origin;
	
	public Circle(double radius, Point origin)
	{
		this.radius = radius;
		this.origin = origin;
	}
	
	public double getArea()
	{
		return Math.PI * radius * radius;
	}
	
	public double getPerimeter()
	{
		return 2 * Math.PI * radius;
	}
	
	public Point getOrigin()
	{
		return origin;
	}
	
	public ShapeType getShape()
	{
		return ShapeType.CIRCLE;
	}
	
	public double getOriginDistance()
	{
		return Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
	}
	
	public boolean isPointEnclosed(Point point)
	{
		boolean enclosed = false;
		double centerXCoordinate, centerYCoordinate, distanceOfPointFromCenter;
		
		centerXCoordinate = origin.getX() + radius / Math.sqrt(1 + origin.getY() / origin.getX());
		centerYCoordinate = origin.getY() + radius / Math.sqrt(1 + origin.getY() / origin.getX());
		distanceOfPointFromCenter = Math.sqrt(Math.pow(centerXCoordinate - point.getX(), 2) + Math.pow(centerYCoordinate - point.getY(), 2));
		
		if(distanceOfPointFromCenter <= radius)
		{
			enclosed = true;
		}
		return enclosed;
	}

}
