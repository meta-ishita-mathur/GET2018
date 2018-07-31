package zooManagement;

/**
 * Elephant is the subclass of Mammal
 * @author Ishita_Mathur
 * It initializes the properties of Elephant when added to Zoo
 */
public class Elephant extends Mammal
{
	private static int id = 1;
	
	/**
	 * This constructor initializes the Elephant properties and calls its super to add it into Mammal
	 * @param weight
	 * @param age
	 */
	public Elephant(double weight, int age)
	{
		super("Elephant" + (id++), weight, age, "Trumpet", 4, false, AnimalName.ELEPHANT);
	}
}
