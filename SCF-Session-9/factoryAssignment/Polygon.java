package factoryAssignment;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType Regular Polygon
 * @author Ishita_Mathur
 */

public class Polygon implements Shape
{    
    public Date timestamp = null; //time at which object is added to screen
    int noOfSides;
    double lengthOfSide;
    Point origin;
    
    //constructor of class
    public Polygon(double noOfSides, double lengthOfSide, Point origin)
    {
        this.noOfSides = (int)noOfSides;
        this.lengthOfSide = lengthOfSide;
        this.origin = origin; 
    }
    
    @Override
    public ShapeType getShape()
    {
        return ShapeType.POLYGON;
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
    public double getOriginDistance() //distance between origin of the shape and origin of the screen
    {
        return Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
    }
    
    @Override
    public double getArea()
    {    
        double apothem = lengthOfSide / (2 * Math.tan(Math.toRadians(180 / noOfSides)));   
        return (getPerimeter() * apothem / 2);
    }

    @Override
    public double getPerimeter()
    {    
        return noOfSides * lengthOfSide;
    }

    @Override
    public Point getOrigin()
    {
        return origin;
    }
   
    @Override
    public boolean isPointEnclosed(Point point)
    {    
        boolean enclosed = false;   
        return enclosed;
    }    
}
