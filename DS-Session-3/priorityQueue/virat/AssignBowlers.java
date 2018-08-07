package virat;

import java.util.ArrayList;

public class AssignBowlers
{
	private int totalBowl;
	private ArrayList<Bowler> bowlers = new ArrayList<Bowler>();

	/**
	 * To add bowlers
	 * @param quota
	 * @param name
	 */
	public void addBowler(int quota, String name)
	{
		bowlers.add(new Bowler(quota, name));
	}

	/**
	 * To calculate total bowl bowler's need to perform
	 */
	public void totalBowl()
	{
		for (Bowler bowlerObj : bowlers)
		{
			totalBowl += bowlerObj.getQuota();
		}
	}

	/**
	 * To make virat score as low as possible
	 * @return Bowler's order such that virat scores minimum
	 */
	public ArrayList<Bowler> viratMinimumRun()
	{
		ArrayList<Bowler> bowlerOrder = new ArrayList<Bowler>();
		while (totalBowl != 0)
		{
			int bolwerIndex, orderSize;
			String bowlerName;
			
			//provide index in list of bowlers which has maximum balls
			bolwerIndex = getMaxBowlBolwer();
			bowlerName = bowlers.get(bolwerIndex).getBowler();
			orderSize = bowlerOrder.size();
			
			if (orderSize == 0)
			{
				bowlerOrder.add(new Bowler(1, bowlerName));
			}
			else if (!bowlerName.equals(bowlerOrder.get(orderSize - 1).getBowler())) // checks if bowler on previous bowl is same or not
			{
				bowlerOrder.add(new Bowler(1, bowlerName));
			}
			else
			{
				bowlerOrder.get(bowlerOrder.size() - 1).setQuota(bowlerOrder.get(bowlerOrder.size() - 1).getQuota() + 1);
			}
			bowlers.get(bolwerIndex).setQuota(bowlers.get(bolwerIndex).getQuota() - 1);
			totalBowl--;
		}
		return bowlerOrder;
	}

	/**
	 * To get the index of bowler which have maximum balls
	 * @return index of bowler in list bowler's
	 */
	private int getMaxBowlBolwer()
	{
		int numberOfBowlers, maxBowls, index = 0, quota;
		
		numberOfBowlers = bowlers.size();
		maxBowls = bowlers.get(0).getQuota();
				
		for (int i = 0; i < numberOfBowlers; i++)
		{
			quota = bowlers.get(i).getQuota();
			if (quota > maxBowls)
			{
				maxBowls = quota;
				index = i;
			}
		}
		return index;
	}
}