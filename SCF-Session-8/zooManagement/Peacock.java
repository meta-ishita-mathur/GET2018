package zooManagement;

/**
 * Peacock is the subclass of Bird
 * @author Ishita_Mathur 
 * It initializes the properties of Parrot when added to Zoo
 */
public class Peacock extends Bird
{
	static int id = 1;
	
    /**
     * This initializes Peacock and calls its super to add it into Bird
     * @param weight
     * @param age
     * @param wingsSpan
     */
	public Peacock(double weight, int age, double wingsSpan)
	{	
		super("Peacock" + (id++), weight, age, "scream", 2, true, wingsSpan, AnimalName.PEACOCK);
	}
}
