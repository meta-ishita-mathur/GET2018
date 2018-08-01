package factoryAssignment;

public interface Shape
{
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point objPoint);
	public ShapeType getShape();
}
