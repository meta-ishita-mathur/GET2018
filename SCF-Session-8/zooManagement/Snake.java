package zooManagement;

/**
 * Snake is the subclass of Reptile
 * @author Ishita_Mathur 
 * It initializes the properties of Snake when added to Zoo
 */
public class Snake extends Reptile
{
	static int id = 1;
	
	/**
	 * This initializes Snake and calls its super to add it into Reptile
	 * @param weight
	 * @param age
	 */
	public Snake(double weight, int age)
	{	
		super("Snake" + (id++), weight, age, "Hiss", 0, true, "cold", AnimalName.SNAKE);
	}
}
