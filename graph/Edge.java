package graph;

/**
 * class for representing an edge in a graph 
 * @author Ishita_Mathur
 *
 */
public class Edge implements Comparable<Edge>
{
    private int source, int destination, weight;

    /**
     * constructor 
     * @param source
     * @param destination
     * @param weight
     */
    public Edge(int source, int destination, int weight) 
    {
        this.setSource(source);
        this.setDestination(destination);
        this.setWeight(weight);
    }
    
    /**
     * getter method for source
     * @return source
     */
    public int getSource()
    {
        return source;
    }
    
    /**
     * setter method for source
     * @param source
     */
    public void setSource(int source)
    {
        this.source = source;
    }
    
    /**
     * getter method for destination
     * @return destination
     */
    public int getDestination()
    {
        return destination;
    }
    
    /**
     * setter method for destination
     * @param destination
     */
    public void setDestination(int destination)
    {
        this.destination = destination;
    }
    
    /**
     * getter method for weight
     * @return weight
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * setter method for weight
     * @param weight
     */
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    /**
     * method to compare two edges
     */
    public int compareTo(Edge edge)
    {
        return this.weight - edge.weight;
    }
}
