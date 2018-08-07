package virat;

/**
 * Implementation of Bowler Class where we describe about properties of bowler
 * @author Ishita_Mathur
 */
public class Bowler
{
	String name;
	int quotaOfBalls;

	// Parameterized constructor for bowler class
	public Bowler(String name, int quotaOfBalls)
	{
		this.name = name;
		this.quotaOfBalls = quotaOfBalls;
	}

	/**
	 * To get name of bowler
	 * @return name, name of bowler
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * To get quota of balls of bowler i.e number of balls assigned to the bowler
	 * @return quotaOfBalls, number of balls assigned to bowler
	 */
	public int getQuota()
	{
		return quotaOfBalls;
	}

	/**
	 * To decrement number of balls in the quota of a baller, after he has bowled one time
	 */
	public void decrementNumberOfBalls()
	{
		if(quotaOfBalls != 0)
			quotaOfBalls--;
	}
}
