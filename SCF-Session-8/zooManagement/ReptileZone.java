package zooManagement;

/**
 * This class will add the Reptile zone into Zoo
 * @author Ishita_Mathur
 */
public class ReptileZone extends Zone
{
	public ReptileZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.REPTILE, capacity, hasPark, hasCanteen);
	}

}
