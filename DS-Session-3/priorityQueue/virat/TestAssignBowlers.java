package virat;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class TestAssignBowlers
{
	AssignBowlers assign = new AssignBowlers();
	
	public void Initialize()
	{
		assign.addBowler(8, "rahul");
		assign.addBowler(3, "utkarsh");
		assign.addBowler(1, "ajay");
	}
	
	@Test
	public void testPositive()
	{	
		assign.totalBowl();
		ArrayList<Bowler> names = assign.viratMinimumRun();
		ArrayList<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(6, "rahul"));
		result.add(new Bowler(1, "utkarsh"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "utkarsh"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "utkarsh"));
		result.add(new Bowler(1, "ajay"));
		for(int i = 0; i < result.size(); i++)
		{
			assertEquals(names.get(i).getQuota(), result.get(i).getQuota());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}

	@Test
	public void test2()
	{
		assign.addBowler(4, "bobby");
		
		assign.totalBowl();
		ArrayList<Bowler> names = assign.viratMinimumRun();
		ArrayList<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(5, "rahul"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "utkarsh"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "utkarsh"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "utkarsh"));
		result.add(new Bowler(1, "ajay"));
		result.add(new Bowler(1, "bobby"));
		for(int i = 0; i < result.size(); i++)
		{
			assertEquals(names.get(i).getQuota(), result.get(i).getQuota());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}
}