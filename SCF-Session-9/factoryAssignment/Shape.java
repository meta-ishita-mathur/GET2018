package factoryAssignment;

import java.util.Date;

/**
 * interface for creating shape objects
 * @author Ishita_Mathur
 */
public interface Shape
{
	/**
     	 * calculates the area of the shape
     	 * @return area
     	 */
	public double getArea();
	
	/**
     	 * calculates the perimeter of the shape
     	 * @return perimeter
     	 */
	public double getPerimeter();
	
	/**
     	 * @return origin of the shape
     	 */
	public Point getOrigin();
	
	/**
     	 * checks if the given point lies inside the shape or not
     	 */
	public boolean isPointEnclosed(Point objPoint);
	
	/**
     	 * @return ShapeType of the shape
     	 */
	public ShapeType getShape();
	
	/**
     	 * @return originDistance, i.e the distance between origin of the shape and origin of the screen
     	 */
	public double getOriginDistance();
	
	/**
     	 * @return timestamp of the shape
     	 */
	public Date getTimestamp();
	
	/**
	 * sets the timestamp at which the object is added to the screen
     	 * @param timestamp
     	 */
	public void setTimestamp(Date timestamp);
}
