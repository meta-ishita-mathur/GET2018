package zooManagement;

/**
 * Reptile is the subclass of Animal and it adds the Reptile type animal into Zoo
 * @author Ishita_Mathur
 */
public class Reptile extends Animal
{
	private final boolean isPoisonous;
	private final String bloodType;
	
    /**
     * This initializes the Reptile properties and calls super to add it into animal
     * @param name
     * @param weight
     * @param age
     * @param sound
     * @param numberOfLegs
     * @param isPoisonous
     * @param bloodType
     * @param animlType
     */
	public Reptile(String name, double weight, int age, String sound,
			int numberOfLegs, boolean isPoisonous, String bloodType, AnimalName animlType)
	{
		super(name, weight, age, sound, numberOfLegs, AnimalFamily.REPTILE, animlType);
		this.isPoisonous = isPoisonous;
		this.bloodType = bloodType;
	}

	public boolean isPoisonous()
	{
		return isPoisonous;
	}

	public String getBloodType()
	{
		return bloodType;
	}
}