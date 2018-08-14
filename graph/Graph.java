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
	 * @return
	 */
	public boolean isConnected();

	/**
	 * Returns all the Nodes that are Reachable from source
	 * @param source
	 * @return
	 */
	public List<Integer> reachable(int source);

	/**
	 * Return the Minimum Spanning Tree for the Graph
	 * @return
	 */
	public List<Edge> minimumSpanningTree();

	/**
	 * Returns the Shortest Path from source to destination
	 * @param source
	 * @param destination
	 * @return
	 */
	public int shortestPath(int source, int destination);
}
