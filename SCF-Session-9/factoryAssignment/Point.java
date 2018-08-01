package factoryAssignment;

/**
 * this class represents coordinates 
 * @author Ishita_Mathur
 */
public class Point
{
	private double X, Y; //to store x and y coordinates
	
	//constructor of class
	public Point(double X, double Y)
	{
		this.X = X;
		this.Y = Y;
	}
	
	public double getX()
	{
		return X;
	}
	
	public void setX(int X)
	{
		this.X = X;
	}
	
	public double getY()
	{
		return Y;
	}
	
	public void setY(int Y)
	{
		this.Y = Y;
	}
}
