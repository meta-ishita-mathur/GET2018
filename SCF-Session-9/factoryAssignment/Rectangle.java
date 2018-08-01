package factoryAssignment;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType Rectangle
 * @author Ishita_Mathur
 */
public class Rectangle implements Shape
{
	public Date timestamp = null; //time at which object is added to screen
	private double width, height;
	private Point origin;
	
	//constructor of class
	public Rectangle(double width, double height, Point origin)
	{
		this.width = width;
		this.height = height;
		this.origin = origin;
	}
	
	@Override
	public double getArea()
	{
		return width * height;
	}
	
	@Override
	public double getPerimeter()
	{
		return 2 * (width + height);
	}
	
	@Override
	public Point getOrigin()
	{
		return origin;
	}
	
	@Override
	public double getOriginDistance() //distance between origin of the shape and origin of the screen
	{
		return Math.sqrt((Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2)));
	}
	
	@Override
	public ShapeType getShape()
	{
		return ShapeType.RECTANGLE;
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
		
		if(point.getX() >= origin.getX() && point.getX() <= (origin.getX() + width) && point.getY() >= origin.getY() && point.getY() <= (origin.getY() + height))
			enclosed = true;
		return enclosed;
	}
}
