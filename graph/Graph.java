package graph;

import java.util.List;

/**
 * This interface contains different methods on Undirected Weighted Graph
 * @author Ishita_Mathur
 *
 */
public interface Graph
{
	/**
	 * Returns true if the Graph is a Connected Graph
	 * @return boolean value
	 */
	public boolean isConnected();

	/**
	 * Returns all the Nodes that are Reachable from source
	 * @param source
	 * @return list of reachable vertices
	 */
	public List<Integer> reachable(int source);

	/**
	 * Return the Minimum Spanning Tree for the Graph
	 * @return list of edges in minimum spanning tree
	 */
	public List<Edge> minimumSpanningTree();

	/**
	 * Returns the Shortest Path from source to destination
	 * @param source
	 * @param destination
	 * @return distance of shortest path
	 */
	public int shortestPath(int source, int destination);
}
