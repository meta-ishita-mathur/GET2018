package virat;

/**
 * Implementation of Bowler Class where we describe about properties of bowler
 * @author Ishita_Mathur
 */
public class Bowler
{
	private int quota;
	private String bowlerName;
	
	public Bowler(int quota, String bowlerName)
	{
		if(quota == 0)
			throw new AssertionError("Bowler not allowed with zero bowl");
		
		if(bowlerName == null)
			throw new NullPointerException("Bowler name can'nt be null");
		
		this.quota = quota;
		this.bowlerName = bowlerName;
	}
	
	public void setQuota(int quota)
	{
		if(quota >= 0)
			this.quota = quota;
	}
	
	public int getQuota()
	{
		return quota;
	}
	
	public String getBowler()
	{
		return bowlerName;
	}
}