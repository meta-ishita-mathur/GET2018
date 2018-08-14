package graph;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class GraphImplementationTest
{
	public GraphImplementation addFirst()
	{
		GraphImplementation graph = new GraphImplementation(4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);

		return graph;
	}
	
	public GraphImplementation addSecond()
	{
		GraphImplementation graph = new GraphImplementation(6);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);
		graph.addEdge(4, 5, 4);
		
		return graph;
	}

	@Test
	public void testIsConnectedPositive()
	{    
		GraphImplementation graph = addFirst();    
		assertTrue(graph.isConnected());
	}

	@Test
	public void testIsConnectedNegative()
	{    
		GraphImplementation graph = addSecond();
		assertFalse(graph.isConnected());
	}

	@Test
	public void testRechable()
	{
        	GraphImplementation graph = addSecond();
		
        	List<Integer> expected = new ArrayList<Integer>();
        	expected.add(4);
        
        	assertEquals(expected, graph.reachable(5));
        	
		graph.addEdge(3, 4, 1);
        
        	List<Integer> newExpected = new ArrayList<Integer>();
        	newExpected.add(0);
        	newExpected.add(1);
        	newExpected.add(2);
        	newExpected.add(3);
        	newExpected.add(4);
        
        	assertEquals(newExpected, graph.reachable(5));
	}

	@Test
	public void testShortestPath()
	{    
		GraphImplementation graph = addFirst(); 
		assertEquals(8, graph.shortestPath(0, 2));   
	}

	@Test
	public void testMinSpanningTree()
	{    
		GraphImplementation graph = addFirst();
		graph.addEdge(0, 2, 2);
		
		List<Edge> expected = new ArrayList<Edge>();
        	expected.add(new Edge(0, 1, 2));
        	expected.add(new Edge(0, 2, 2));
        	expected.add(new Edge(0, 3, 4));
        
        	List<Edge> mst = graph.minimumSpanningTree();
        
        	for(int i = 0; i < mst.size(); i++)
        	{
            		assertEquals(expected.get(i).getSource(), mst.get(i).getSource());
            		assertEquals(expected.get(i).getDestination(), mst.get(i).getDestination());
            		assertEquals(expected.get(i).getWeight(), mst.get(i).getWeight());
        	}
	}
}
