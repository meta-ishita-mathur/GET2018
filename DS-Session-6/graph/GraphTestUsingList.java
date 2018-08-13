package graph;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs different Tests.
 * 
 * @author Ishita_Mathur
 *
 */
public class GraphTestUsingList {
	ImplementationUsingList graphList;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws GraphException {
		// Input Graph
		// 0---1
		// |  /| \ 
		// | / |  2
		// |/  | /
		// 4---3
		List<LinkedList<AdjacencyList>> list = new LinkedList<LinkedList<AdjacencyList>>();
		LinkedList<AdjacencyList> list1 = new LinkedList<>();
		list1.add(new AdjacencyList(1, 5));
		list1.add(new AdjacencyList(4, 8));
		list.add(list1);
		LinkedList<AdjacencyList> list2 = new LinkedList<>();
		list2.add(new AdjacencyList(0, 5));
		list2.add(new AdjacencyList(2, 9));
		list2.add(new AdjacencyList(3, 10));
		list2.add(new AdjacencyList(4, 1));
		list.add(list2);
		LinkedList<AdjacencyList> list3 = new LinkedList<>();
		list3.add(new AdjacencyList(1, 9));
		list3.add(new AdjacencyList(3, 4));
		list.add(list3);
		LinkedList<AdjacencyList> list4 = new LinkedList<>();
		list4.add(new AdjacencyList(1, 10));
		list4.add(new AdjacencyList(2, 4));
		list4.add(new AdjacencyList(4, 2));
		list.add(list4);
		LinkedList<AdjacencyList> list5 = new LinkedList<>();
		list5.add(new AdjacencyList(0, 8));
		list5.add(new AdjacencyList(1, 1));
		list5.add(new AdjacencyList(3, 2));
		list.add(list5);
		graphList = new ImplementationUsingList(list);
	}

	@Test
	public void When_GraphConnected_Expect_True() {
		assertTrue(graphList.isConnected());
	}

	@Test
	public void When_Vertex0Reachable_Expect_Vertex1Vertex4() throws GraphException {
		assertEquals(new LinkedList<Integer>(Arrays.asList(1, 4)), graphList.reachable(0));
	}

	@Test
	public void When_Graph_Expect_MinimumSpanningTree() {
		// Minimum Spanning Tree
		// 0---1
		//    /
		//   /   2
		//  /   /
		// 4---3
		assertArrayEquals(new int[][] { { 0, 5, 0, 0, 0 }, { 5, 0, 0, 0, 1 }, { 0, 0, 0, 4, 0 }, { 0, 0, 4, 0, 2 },
				{ 0, 1, 0, 2, 0 } }, graphList.minimumSpanningTree());
	}

	@Test
	public void When_GraphShortesdPathBetween0To2_Expect_ShortestPath12() throws GraphException {
		assertEquals(7, graphList.shortestPath(1, 2));
	}

	@Test
	public void When_GraphIsNull_Expect_NullPointerException() throws GraphException {
		ex.expect(NullPointerException.class);
		ex.expectMessage("Graph can't be Null");
		graphList = new ImplementationUsingList(null);
	}

	@Test
	public void When_GraphNodeNotPresent_Expect_GraphException() throws GraphException {
		ex.expect(GraphException.class);
		ex.expectMessage("Given Node not Present in Graph");
		graphList.reachable(5);
	}

	@Test
	public void When_GraphNodeNotPresentForShortestPath_Expect_GraphException() throws GraphException {
		ex.expect(GraphException.class);
		ex.expectMessage("Given Nodes not Present in Graph");
		graphList.shortestPath(0, 6);
	}
}
