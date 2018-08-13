package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphImplementation implements Graph
{
	int noOfVertices;
	List<Edge>[] edgeList;

	public GraphImplementation(int noOfVertices)
	{
		this.noOfVertices = noOfVertices;
		edgeList = new LinkedList[noOfVertices];

		for(int i = 0; i < noOfVertices; i++)
			edgeList[i] = new LinkedList<Edge>();
	}

	public void addEdge(int source, int destination, int weight) 
	{
		edgeList[source].add(new Edge(source, destination, weight));
		edgeList[destination].add(new Edge(destination, source, weight));
	}

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
			int node = minKey(key, minSpanningTreeSet);

			minSpanningTreeSet[node] = true;
			List<Edge> edges = edgeList[node];

			for (int v = 0; v < noOfVertices; v++) 
			{
				for (Edge listEdges : edges) 
				{
					if (listEdges.getDestination() == v) 
					{                        
						if (listEdges.getWeight() != 0 && !minSpanningTreeSet[v] && listEdges.getWeight() < key[v]) 
						{
							parent[v] = node;
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