package factoryAssignment;

import java.util.ArrayList;
import java.util.Date;

/**
 * this class is used to create a virtual screen for storing shape objects
 * @author Ishita_Mathur
 */
public class Screen
{
	ArrayList<Shape> screenObjects = new ArrayList<Shape>();
	double xMax, yMax; // used to determine the size of the screen
	    
	//constructor of class
	public Screen(double xMax, double yMax)
	{
		this.xMax = xMax;
	    this.yMax = yMax;
	}
	    
	    
	/**
	 * used to add a shape object on the screen
	 * @param shapeObject
	 * @return true if added, false otherwise
	 */
	public boolean addShape(Shape shapeObject)
	{
		try
	    {
			if(shapeObject == null)
				throw new AssertionError("Object is null! Cannot add!");
	        
			Point shapeOrigin = shapeObject.getOrigin();
	        
	        if(shapeOrigin.getX() < 0 || shapeOrigin.getX() > xMax || shapeOrigin.getY() < 0 || shapeOrigin.getY() > yMax)
	            throw new AssertionError("Object lies outside the screen!");
	        
	        screenObjects.add(shapeObject);
	        shapeObject.setTimestamp(new Date());
	        
	        return true;
	    }
	    
		catch(AssertionError error)
	    {
			return false;
	    }
	}
	
	/**
	 * used to remove a shape object from the screen
	 * @param shapeObject
	 * @return true if removed, false otherwise
	 */
	public boolean deleteShape(Shape shapeObject)
	{
		try
	    {
			if(screenObjects.contains(shapeObject))
				screenObjects.remove(shapeObject);
	        else
	            throw new AssertionError("The given shape object is not present on screen!");
	            
	        return true;
	    }
	        
		catch(AssertionError error)
	    {
			return false;
	    }
	}
	
	/**
	 * used to remove all the shape objects of a specific type from the screen
	 * @param shapeType
	 * @return true if removed, false otherwise
	 */
	public boolean deleteShapeType(ShapeType shapeType)
	{
		boolean flag = false;
	    ArrayList<Shape> removeList = new ArrayList<Shape>();
	        
	    for(Shape shape : screenObjects)
	    {
	    	if(shape.getShape() == shapeType)
	        {
	    		flag = true;
	            removeList.add(shape);              
	        }
	    }
	        
	    for(Shape shape: removeList)
	    {
	    	screenObjects.remove(shape);
	    }
	        
	    try
	    {
	    	if(!flag)
	    		throw new AssertionError("No object of the given type!");
	    }
	    
	    catch(AssertionError error)
	    {
	    	return false;
	    }
	    return flag;
	}
	
	/**
	 * sorts the list of objects in ascending order according to area
	 * @return sortedList
	 */
	public ArrayList<Shape> sortByArea()
	{
		int noOfObjects = screenObjects.size();
		Shape temp;
		ArrayList<Shape> sortedListByArea = new ArrayList<Shape>(screenObjects);
	    
	    if(noOfObjects == 0)
	    	throw new AssertionError("List is empty! Cannot sort");
	        
	    for(int i = 0; i < noOfObjects; i++)
	    {
	    	for(int j = 0; j < noOfObjects - 1 - i; j++)
	        {
	    		if(sortedListByArea.get(j).getArea() > sortedListByArea.get(j + 1).getArea())
	            {
	    			temp = sortedListByArea.get(j);
	                sortedListByArea.set(j, sortedListByArea.get(j + 1));
	                sortedListByArea.set(j + 1, temp);
	            }
	        }
	    }
	    return sortedListByArea;
	}
	
	/**
	 * sorts the list of objects in ascending order according to perimeter
	 * @return sortedList
	 */
	public ArrayList<Shape> sortByPerimeter()
	{
		int noOfObjects = screenObjects.size();
		Shape temp;
		ArrayList<Shape> sortedListByPerimeter = new ArrayList<Shape>(screenObjects);
		
		if(noOfObjects == 0)
			throw new AssertionError("List is empty! Cannot sort");
	        
	    for(int i = 0; i < noOfObjects; i++)
	    {
	    	for(int j = 0; j < noOfObjects - 1 - i; j++)
	        {
	    		if(sortedListByPerimeter.get(j).getPerimeter() > sortedListByPerimeter.get(j + 1).getPerimeter())
	            {
	    			temp = sortedListByPerimeter.get(j);
	                sortedListByPerimeter.set(j, sortedListByPerimeter.get(j + 1));
	                sortedListByPerimeter.set(j + 1, temp);
	            }
	        }
	    }
	    return sortedListByPerimeter;
	}
	
	/**
	 * sorts the list of objects in ascending order according to distance between origin of shape and origin of screen
	 * @return sortedList
	 */
	public ArrayList<Shape> sortByOriginDistance()
	{
		int noOfObjects = screenObjects.size();
		Shape temp;
		ArrayList<Shape> sortedListByOriginDistance = new ArrayList<Shape>(screenObjects);
	    
	    if(noOfObjects == 0)
	    	throw new AssertionError("List is empty! Cannot sort");
	        
	    for(int i = 0; i < noOfObjects; i++)
	    {
	    	for(int j = 0; j < noOfObjects - 1 - i; j++)
	        {
	    		
	    		if(sortedListByOriginDistance.get(j).getOriginDistance() > sortedListByOriginDistance.get(j + 1).getOriginDistance())
	            {
	    			temp = sortedListByOriginDistance.get(j);
	                sortedListByOriginDistance.set(j, sortedListByOriginDistance.get(j + 1));
	                sortedListByOriginDistance.set(j + 1, temp);
	            }
	        }
	    }
	    return sortedListByOriginDistance;
	}
	
	/**
	 * sorts the list of objects in ascending order according to timestamp
	 * @return sortedList
	 */
	public ArrayList<Shape> sortByTimestamp()
	{
		if(screenObjects.size() == 0)
			throw new AssertionError("List is empty! Cannot sort");
	    return screenObjects;
	}
	
	/**
	 * returns list of all shapes enclosing the given point
	 * @param point
	 * @return list of all shapes
	 */
	public ArrayList<Shape> shapesEnclosingPoint(Point point)
	{
		ArrayList<Shape> listOfShapes = new ArrayList<Shape>();
	        
	    if(point == null)
	    	throw new AssertionError("Enter a valid point");
	        
	    for(Shape shape : screenObjects)
	    {
	    	if(shape.isPointEnclosed(point))
	    		listOfShapes.add(shape);
	    }
	    return listOfShapes;
	}
}
