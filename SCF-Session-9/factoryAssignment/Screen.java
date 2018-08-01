package factoryAssignment;

import java.util.ArrayList;

public class Screen 
{
	private ArrayList<Shape> shapeList = new  ArrayList<Shape>();
	
	public ArrayList<Shape> addShape (ShapeType shapeType, Point origin, ArrayList<Double> parameterList)
	{
		shapeList.add(ShapeFactory.createShape(origin, shapeType, parameterList));
		return shapeList;
	}
	
	public void deleteShape (String ShapeType)
	{
		
	}
	
	public ArrayList<Shape> deletAllShapeOfType (ShapeType shapeType)
	{
		if (shapeType == null)
			throw new AssertionError("String is null");
		
		for (int itr = 0; itr < shapeList.size(); itr++)
		{
			if(shapeList.get(itr).getShape().equals(shapeType))
			{
				shapeList.remove(itr);
				itr--;
			}
		}
		return shapeList;
	}
	
	public ArrayList<Shape> sortOnBasisOfArea()
	{
		ArrayList<Shape> sortedList = new ArrayList<Shape>(shapeList);

		for (int i=0; i<sortedList.size(); i++)
		{
			for(int j=i; j<sortedList.size()-1; j++)
			{
				if(sortedList.get(j).getArea()>sortedList.get(j+1).getArea())
				{
					Shape shape = sortedList.get(j);
					sortedList.set(j, sortedList.get(j+1));
					sortedList.set(j+1,shape);
				}
			}
		}	
		return sortedList;
	}
	
	public List<Shape> sortOnBasisOfPerimeter(){
		List<Shape> sortedList = new ArrayList<Shape>(shapeList);

		for (int i=0; i<sortedList.size(); i++) {
			for(int j=i; j<sortedList.size()-1; j++) {
				if(sortedList.get(j).getPerimeter()>sortedList.get(j+1).getPerimeter()){
					Shape shape = sortedList.get(j);
					sortedList.set(j, sortedList.get(j+1));
					sortedList.set(j+1,shape);
				}
			}
		}	
		return sortedList;
	}

	public List<Shape> sortOnBasisOfTimeStamp(){
		List<Shape> sortedList = new ArrayList<Shape>(shapeList);

		for (int i=0; i<sortedList.size(); i++) {
			for(int j=i; j<sortedList.size()-1; j++) {
				if(sortedList.get(j).getTimeStamp().compareTo(sortedList.get(j+1).getTimeStamp())>0){
					Shape shape = sortedList.get(j);
					sortedList.set(j, sortedList.get(j+1));
					sortedList.set(j+1,shape);
				}
			}
		}	
		return sortedList;
	}
	
	public List<Shape> sortOnBasisOfDistanceFromOrigin(){
		List<Shape> sortedList = new ArrayList<Shape>(shapeList);

		for (int i=0; i<sortedList.size(); i++) {
			for(int j=i; j<sortedList.size()-1; j++) {
				if(sortedList.get(j).getOrigin().getX()>=sortedList.get(j+1).getOrigin().getX() && sortedList.get(j).getOrigin().getY()>=sortedList.get(j+1).getOrigin().getY()){
					Shape shape = sortedList.get(j);
					sortedList.set(j, sortedList.get(j+1));
					sortedList.set(j+1,shape);
				}
			}
		}	
		return sortedList;
	}
	public int listOfShapeEnclosingPoint(Point point) {
		int count = 0;
		for (int itr=0; itr<shapeList.size(); itr++) {
			if (shapeList.get(itr).isPointEnclosed(point)) {
				count++;
			}
		}
		return count;
	}
	
	public List<Shape> getList() {
		return shapeList;
	}

}
