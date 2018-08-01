package factoryAssignment;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType Circle
 * @author Ishita_Mathur
 */
public class Circle implements Shape
{
	public Date timestamp = null; //time at which object is added to screen
	private double radius;
	private Point origin;
	
	//constructor of class
	public Circle(double radius, Point origin)
	{
		this.radius = radius;
		this.origin = origin;
	}
	
	@Override
	public double getArea()
	{
		return Math.PI * radius * radius;
	}
	
	@Override
	public double getPerimeter()
	{
		return 2 * Math.PI * radius;
	}
	
	@Override
	public Point getOrigin()
	{
		return origin;
	}
	
	@Override
	public ShapeType getShape()
	{
		return ShapeType.CIRCLE;
	}
	
	@Override
	public double getOriginDistance() //distance between origin of the shape and origin of the screen
	{
		return Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
	}
	
	@Override
	public Date getTimestamp()
	{
		return timestamp;
	}
	
	@Override
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}
	 
	@Override
	public boolean isPointEnclosed(Point point)
	{
		boolean enclosed = false;
		double centerXCoordinate, centerYCoordinate, distanceOfPointFromCenter;
		
		centerXCoordinate = origin.getX() + radius / Math.sqrt(1 + origin.getY() / origin.getX());
		centerYCoordinate = origin.getY() + radius / Math.sqrt(1 + origin.getY() / origin.getX());
		distanceOfPointFromCenter = Math.sqrt(Math.pow(centerXCoordinate - point.getX(), 2) + Math.pow(centerYCoordinate - point.getY(), 2));
		
		if(distanceOfPointFromCenter <= radius)
			enclosed = true;
			
		return enclosed;
	}
}
