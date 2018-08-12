package FCFS;

import static org.junit.Assert.*;

public class FCFSTest 
{
	FirstComeFirstServe object = new FirstComeFirstServe();

	/**
	 * To test completion time of processes
	 */
	@org.junit.Test
	public void testingCompletionTime()
	{
		int completionTime[] = object.findCompletionTime(4, new int[][]{{0, 10}, {6, 20}, {60, 10}, {110, 5}});
		assertArrayEquals(new int[]{10, 30, 70, 115}, completionTime);
	}

	/**
	 * To test turn around time of processes
	 */
	@org.junit.Test
	public void testingTurnAroundTime()
	{
		int turnAroundTime[] = object.findTurnAroundTime(4, new int[][]{{0, 10}, {6, 20}, {60, 10}, {110, 5}});
		assertArrayEquals(new int[]{10, 24, 10, 5}, turnAroundTime);
	}

	/**
	 * To test waiting time of processes
	 */
	@org.junit.Test
	public void testingWaitingTime()
	{
		int waitingTime[] = object.findWaitingTime(4, new int[][]{{0, 10}, {6, 20}, {60, 10}, {110, 5}});
		assertArrayEquals(new int[]{0, 4, 0, 0}, waitingTime);
	}

	/**
	 * To test average waiting time of processes
	 */
	@org.junit.Test
	public void testingAverageWaitingTime()
	{
		double avgWaitingTime = object.findAvgWaitingTime(4, new int[][]{{0, 10}, {6, 20}, {60, 10}, {110, 5}});
		assertEquals(1.0, avgWaitingTime, 0.1);
	}	

	/**
	 * To test maximum waiting time of processes
	 */
	@org.junit.Test
	public void testingMaximumWaitingTime()
	{
		int maxWaitingTime = object.maxWaitingTime(4, new int[][]{{0, 10}, {6, 20}, {60, 10}, {110, 5}});
		assertEquals(4, maxWaitingTime);
	}

}
