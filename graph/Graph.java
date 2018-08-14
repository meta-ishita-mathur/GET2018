package graph;

import java.util.List;

public interface Graph
{
	/**
	 * Returns true if the Graph is a Connected Graph
	 * @return
	 */
	public boolean isConnected();

	/**
	 * Returns all the Nodes that are Reachable from node
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
	 * Returns the Shortest Path from node1 to node2 using Dijkstra’s Algorithm
	 * @param source
	 * @param destination
	 * @return
	 */
	public int shortestPath(int source, int destination);
}
