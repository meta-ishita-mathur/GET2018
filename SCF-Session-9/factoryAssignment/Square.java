package factoryAssignment;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType square
 * @author Ishita_Mathur
 */
public class Square implements Shape
{
	public Date timestamp = null; //time at which object is added to screen
	private double side;
	private Point origin;
	
	//constructor of class
	public Square(double side, Point origin)
	{
		this.side = side;
		this.origin = origin;
	}
	
	@Override
	public double getArea()
	{
		return side * side;
	}
	
	@Override
	public double getPerimeter()
	{
		return 4 * side;
	}
	
	@Override
	public Point getOrigin()
	{
		return origin;
	}
	
	@Override
	public ShapeType getShape()
	{
		return ShapeType.SQUARE;
	}
	
	@Override
	public double getOriginDistance() //distance between origin of the shape and origin of the screen
	{
		return Math.sqrt((Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2))); 
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
		
		if(point.getX() >= origin.getX() && point.getX() <= side && point.getY() >= origin.getY() && point.getY() <= side)
			enclosed = true;
		return enclosed;
	}
}
