package virat;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to find the order or sequence of bowlers so that runs scored by the opponent cricketer are minimized
 * @author Ishita_Mathur
 */
public class AssignBowlers
{
	List<String> nameOfBallers;
	int maximumQuota, quota;
	String name;
	Bowler maxBowler; 

	// Constructor for FindOrderOfBalls
	public AssignBowlers()
	{    
		nameOfBallers = new ArrayList<String>();
		maxBowler = null;
	}

	/**
	 * To find the order of bowlers such that the runs scored by the opponent are minimized
	 * @param numberOfBowlers, total number of bowlers
	 * @param totalBalls, total number of balls
	 * @param listOfBallers, list of bowlers 
	 * @return nameOfBallers, list of names of bowlers in order in which they will bowl
	 */
	public List<String> findOrderOfBowling(int numberOfBowlers, int totalBalls, ArrayList<Bowler> listOfBallers)
	{          
		if((numberOfBowlers <= 0 || totalBalls <= 0) || (numberOfBowlers > totalBalls))
			throw new AssertionError("Invalid Input!");

		for( int i = 0; i < totalBalls; i++)
		{       
			for(Bowler bowler : listOfBallers)
			{
				maximumQuota = listOfBallers.get(0).getQuota();
				if(bowler.getQuota() >= maximumQuota)
					maxBowler = bowler; 
			}
			nameOfBallers.add(maxBowler.getName());
			maxBowler.decrementNumberOfBalls();  
		} 
		return nameOfBallers;
	}     
}
