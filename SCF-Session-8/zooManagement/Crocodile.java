package zooManagement;

/**
 * The Crocodile class is the subclass of the Reptile
 * @author Ishita_Mathur
 * It initializes the Crocodile animal when added to the Zoo
 */
public class Crocodile extends Reptile
{
	static int id = 1;
	
	/**
	 * It initializes the crocodile properties and calls its super to add it into Reptile
	 * @param weight
	 * @param age
	 */
	public Crocodile(double weight, int age)
	{	
		super("Crocodile" + (id++), weight, age, "Roar", 4, false, "warm", AnimalName.CROCODILE);
	}
}
