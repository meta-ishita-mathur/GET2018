package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements Graph interface methods using Edge
 * @author Ishita_Mathur
 *
 */
public class GraphImplementation implements Graph
{
	int noOfVertices;
	List<Edge>[] edgeList;

	/**
     	 * constructor
     	 * @param noOfVertices
    	 */
	public GraphImplementation(int noOfVertices)
	{
		this.noOfVertices = noOfVertices;
		edgeList = new LinkedList[noOfVertices];

		for(int i = 0; i < noOfVertices; i++)
			edgeList[i] = new LinkedList<Edge>();
	}

	/**
	 * method to add an edge to the graph.
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdge(int source, int destination, int weight) 
	{
		edgeList[source].add(new Edge(source, destination, weight));
		edgeList[destination].add(new Edge(destination, source, weight));
	}

	/**
	 * Returns true is the Graph is a Connected Graph
	 * @return boolean value
	 */
	public boolean isConnected()
	{
		Boolean[] nodeTraversed = new Boolean[noOfVertices];
		boolean isConnected = true;

		for(int i = 0; i < noOfVertices; i++)
		{
			nodeTraversed[i] = false;
		}

		DFSTraversal(0, nodeTraversed);

		for(int i = 0; i < noOfVertices; i++)
		{
			if(nodeTraversed[i] == false)
			{
				isConnected = false;
				break;
			}
		}
		return isConnected;
	}

	/**
	 * Returns all the Nodes that are Reachable from source
	 * @param source
	 * @return list of rechable nodes
	 */
	public List<Integer> reachable(int source)
	{
		List<Integer> reachableNodes = new ArrayList<>();
		Boolean[] nodeTraversed = new Boolean[noOfVertices];

		for(int i = 0; i < noOfVertices; i++)
		{
			nodeTraversed[i] = false;
		}

		DFSTraversal(source, nodeTraversed);

		for(int i = 0; i < noOfVertices; i++)
		{
			if(i != source && nodeTraversed[i] == true)
				reachableNodes.add(i);
		}
		return reachableNodes;
	}

	/**
	 * Return the Minimum Spanning Tree for the Graph
	 * @return list of edges in minimum spanning tree
	 */
	public List<Edge> minimumSpanningTree()
	{
		List<Edge> minSpanningtree;
		int parent[] = new int[noOfVertices];
		int key[] = new int[noOfVertices];
		Boolean minSpanningTreeSet[] = new Boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) 
		{
			key[i] = Integer.MAX_VALUE;
			minSpanningTreeSet[i] = false;
		}

		key[0] = 0; 
		parent[0] = -1; 

		for (int count = 0; count < noOfVertices - 1; count++) 
		{
			int shortestPathNode = minKey(key, minSpanningTreeSet);

			minSpanningTreeSet[shortestPathNode] = true;
			List<Edge> edges = edgeList[shortestPathNode];

			for (int v = 0; v < noOfVertices; v++) 
			{
				for (Edge listEdges : edges) 
				{
					if (listEdges.getDestination() == v) 
					{                        
						if (listEdges.getWeight() != 0 && !minSpanningTreeSet[v] && listEdges.getWeight() < key[v]) 
						{
							parent[v] = shortestPathNode;
							key[v] = listEdges.getWeight();
						}
					}
				}
			}
		}
		minSpanningtree = new ArrayList<>();

		for (int i = 1; i < noOfVertices; i++) 
		{
			List<Edge> edges = edgeList[i];
			for (Edge edgeConnected : edges)
			{
				if (edgeConnected.getDestination() == parent[i]) 
				{
					Edge edge = new Edge(parent[i], i, edgeConnected.getWeight());
					minSpanningtree.add(edge);
				}
			}
		}
		return minSpanningtree;
	}

	/**
	 * Returns the Shortest Path from source to destination using Dijkstra’s Algorithm
	 * @param source
	 * @param destination
	 * @return distance of shortest path
	 */
	public int shortestPath(int source, int destination) 
	{
		int shortestDistanceNode;
		List<Edge> adjacentEdges = new LinkedList<>();
		int distance[] = new int[noOfVertices]; 
		Boolean processed[] = new Boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) 
		{
			distance[i] = Integer.MAX_VALUE;
			processed[i] = false;
		}
		distance[source] = 0;

		for (int count = 0; count < noOfVertices - 1; count++) 
		{
			shortestDistanceNode = minKey(distance, processed);
			processed[shortestDistanceNode] = true;
			adjacentEdges = edgeList[shortestDistanceNode];

			for (int v = 0; v < noOfVertices; v++)
			{    
				for (Edge listEdges : adjacentEdges) 
				{
					if (listEdges.getDestination() == v)
						if (!processed[v] && listEdges.getWeight() != 0 && distance[shortestDistanceNode] != Integer.MAX_VALUE && distance[shortestDistanceNode] + listEdges.getWeight() < distance[v])
							distance[v] = distance[shortestDistanceNode] + listEdges.getWeight();
				}
			}
		}
		return distance[destination];
	}

	/**
    	 * helper method to find the vertex with the minimum key
    	 * @param key
    	 * @param processed
    	 * @return vertex with the minimum key
    	 */
	private int minKey(int distance[], Boolean processed[]) 
	{
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int vertex = 0; vertex < noOfVertices; vertex++)
		{
			if (processed[vertex] == false && distance[vertex] < min) 
			{
				min = distance[vertex];
				minIndex = vertex;
			}
		}
		return minIndex;
	}

	/**
    	 * helper method for Depth First Traversal
    	 * @param graphNode
     	 * @param nodeTraversed
    	 */
	private void DFSTraversal(int graphNode, Boolean[] nodeTraversed) 
	{    
		int node;
		nodeTraversed[graphNode] = true;

		Iterator<Edge> iterator = edgeList[graphNode].iterator();

		while(iterator.hasNext())
		{
			node = iterator.next().getDestination();

			if(!nodeTraversed[node])
				DFSTraversal(node, nodeTraversed);
		}       
	}
}
