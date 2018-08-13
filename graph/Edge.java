package graph;

public class Edge implements Comparable<Edge>
{
	private int source, destination, weight;

	public Edge(int source, int destination, int weight) 
	{
		this.setSource(source);
		this.setDestination(destination);
		this.setWeight(weight);
	}

	public int getSource()
	{
		return source;
	}

	public void setSource(int source)
	{
		this.source = source;
	}

	public int getDestination()
	{
		return destination;
	}

	public void setDestination(int destination)
	{
		this.destination = destination;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public int compareTo(Edge edge)
	{
		return this.weight - edge.weight;
	}
}