package virat;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TestAssignBowlers
{
	AssignBowlers findOrder = new AssignBowlers();

	public ArrayList<Bowler> initialize()
	{
		Bowler firstBowler, secondBowler, thirdBowler, fourthBowler;
		ArrayList<Bowler> listOfBowlers = new ArrayList<Bowler>();

		firstBowler = new Bowler("A", 7);
		secondBowler = new Bowler("B", 3);
		thirdBowler = new Bowler("C", 4);
		fourthBowler = new Bowler("D", 1);

		listOfBowlers.add(firstBowler);
		listOfBowlers.add(secondBowler);
		listOfBowlers.add(thirdBowler);
		listOfBowlers.add(fourthBowler);

		return listOfBowlers;
	}
	/**
	 * To test the order of bowlers such that runs scored by opponent are minimum
	 */
	@Test
	public void testResult()
	{
		int numberOfBowlers = 4, totalBalls = 15;
		ArrayList<Bowler> listOfBowlers = initialize();
		List<String> namesInOrderActualList, expectedListOfOrder;

		namesInOrderActualList = findOrder.findOrderOfBowling(numberOfBowlers, totalBalls, listOfBowlers);
		expectedListOfOrder = new ArrayList<String>(totalBalls);

		expectedListOfOrder.add("A");   
		expectedListOfOrder.add("A");     
		expectedListOfOrder.add("A");     
		expectedListOfOrder.add("C");     
		expectedListOfOrder.add("A");     
		expectedListOfOrder.add("C");     
		expectedListOfOrder.add("B");     
		expectedListOfOrder.add("A");     
		expectedListOfOrder.add("C");     
		expectedListOfOrder.add("B");     
		expectedListOfOrder.add("A");     
		expectedListOfOrder.add("D");     
		expectedListOfOrder.add("C");     
		expectedListOfOrder.add("B");     
		expectedListOfOrder.add("A");     

		assertEquals(expectedListOfOrder, namesInOrderActualList);    
	}

	/**
	 * To test the order of bowlers such that runs scored by opponent are minimum with number of 
	 * bowlers less than or equal to zero
	 */
	@Test
	public void testResultWithNumberOfBowlersLessThanOne()
	{
		try
		{
			int numberOfBowlers = 0, totalBalls = 15;
			ArrayList<Bowler> listOfBowlers = initialize();
			List<String> namesInOrderActualList, expectedListOfOrder;

			namesInOrderActualList = findOrder.findOrderOfBowling(numberOfBowlers, totalBalls, listOfBowlers);
			expectedListOfOrder = new ArrayList<String>(totalBalls);
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid Input!", error);
		}
	}

	/**
	 * To test the order of bowlers such that runs scored by opponent are minimum with number of 
	 * balls less than or equal to zero
	 */
	@Test
	public void testResultWithNumberOfBallsLessThanOne()
	{
		try
		{
			int numberOfBowlers = 4, totalBalls = 0;
			ArrayList<Bowler> listOfBowlers = initialize();
			List<String> namesInOrderActualList, expectedListOfOrder;

			namesInOrderActualList = findOrder.findOrderOfBowling(numberOfBowlers, totalBalls, listOfBowlers);
			expectedListOfOrder = new ArrayList<String>(totalBalls);
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid Input!", error);
		}    
	}

	/**
	 * To test the order of bowlers such that runs scored by opponent are minimum with number of 
	 * balls less than the number of bowlers
	 */
	@Test
	public void testResultWithNumberOfBallsLessThanNumberOfBowlers()
	{
		try
		{
			int numberOfBowlers = 4, totalBalls = 2;
			ArrayList<Bowler> listOfBowlers = initialize();
			List<String> namesInOrderActualList, expectedListOfOrder;

			namesInOrderActualList = findOrder.findOrderOfBowling(numberOfBowlers, totalBalls, listOfBowlers);
			expectedListOfOrder = new ArrayList<String>(totalBalls);
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid Input!", error);
		}  
	}
}
