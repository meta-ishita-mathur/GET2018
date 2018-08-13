package graph;

import java.util.List;

public interface Graph
{
	public boolean isConnected();

	public List<Integer> reachable(int source);

	public List<Edge> minimumSpanningTree();

	public int shortestPath(int source, int destination);
}