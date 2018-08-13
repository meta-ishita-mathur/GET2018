package graph;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GraphImplementationTest
{
	public GraphImplementation add()
	{
		GraphImplementation graph = new GraphImplementation(4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);

		return graph;
	}

	@Test
	public void testIsConnectedPositive()
	{    
		GraphImplementation graph = add();    
		assertTrue(graph.isConnected());
	}

	@Test
	public void testIsConnectedNegative()
	{    
		GraphImplementation graph = new GraphImplementation(6);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);
		graph.addEdge(4, 5, 4);

		assertFalse(graph.isConnected());
	}

	@Test
	public void testRechable()
	{    
		GraphImplementation graph = new GraphImplementation(6);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);
		graph.addEdge(4, 5, 4);

		List<Integer> reachable = graph.reachable(5);

		for(Integer i: reachable)
		{
			System.out.println(i);
		}
	}

	@Test
	public void testShortestPath()
	{    
		GraphImplementation graph = add(); 
		assertEquals(8, graph.shortestPath(0, 2));   
	}

	@Test
	public void testMinSpanningTree()
	{    
		GraphImplementation graph = add();
		graph.addEdge(0, 2, 2);

		List<Edge> g = graph.minimumSpanningTree();
		for(Edge e: g)
			System.out.println(e.getSource() + " " + e.getDestination() + " " + e.getWeight());
	}
}