package zooManagement;

/**
 * This Bird class inherits the Animal super class
 * @author Ishita_Mathur
 */
public class Bird extends Animal
{
	private final boolean isAbleToFly;
	private double wingsSpan;
	
	/**
	 * The constructor initializes the Birds in the Zoo
	 * It calls its superclass constructor to set it into animal property 
	 * @param name
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param isAbleToFly
	 * @param wingsSpan
	 * @param animalType
	 */
	public Bird(String name, double weight, int age, String sound, int numberOfLegs, boolean isAbleToFly, double wingsSpan, AnimalName animalType)
	{	
		super(name, weight, age, sound, numberOfLegs, AnimalFamily.BIRD, animalType);
		
		this.isAbleToFly = isAbleToFly;
		this.wingsSpan = wingsSpan;
	}	
	
	public double getWingsSpan()
	{
		return wingsSpan;
	}

	public void setWingsSpan(double wingsSpan)
	{
		this.wingsSpan = wingsSpan;
	}

	public boolean isAbleToFly()
	{
		return isAbleToFly;
	}
}
