package factoryAssignment;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType triangle
 * @author Ishita_Mathur
 */
public class Triangle implements Shape
{
	public Date timestamp = null; //time at which object is added to screen
	private double firstSide, secondSide, thirdSide;
	private Point origin;
	
	//constructor of class
	public Triangle(double firstSide, double secondSide, double thirdSide, Point origin)
	{
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
		this.origin = origin;
	}
	
	@Override
	public double getArea()
	{
		double halfPerimeter = getPerimeter() / 2;
		return(Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide)));	
	}
	
	@Override
	public double getPerimeter()
	{
		return firstSide + secondSide + thirdSide;
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
		return ShapeType.TRIANGLE;
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
		double height, base;
		Point secondPoint, thirdPoint;
		
		height = 2 * getArea() / firstSide;
		base = Math.sqrt(Math.pow(thirdSide, 2) - Math.pow(height, 2));
        
		secondPoint = new Point(origin.getX() + firstSide, origin.getY());
        	thirdPoint = new Point(origin.getX() + base, origin.getY() + height);
                
        	if(Math.abs(getArea() - ((getAreaByVertices(point, origin, secondPoint)) + getAreaByVertices(point, secondPoint, thirdPoint) + getAreaByVertices(point, origin, thirdPoint))) <= 0.001)
            		enclosed = true;        
        
        	return enclosed;
	}
	
	public double getAreaByVertices(Point origin, Point secondPoint, Point thirdPoint)
    	{
        	return Math.abs((origin.getX() * (secondPoint.getY() - thirdPoint.getY()) + secondPoint.getX() * (thirdPoint.getY() - origin.getY()) + thirdPoint.getX() * (origin.getY() - secondPoint.getY())) / 2.0);
    	} 
}
