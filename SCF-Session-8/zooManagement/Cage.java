package zooManagement;

import java.util.ArrayList;

/**
 * The Cage class will add the cage to the Zoo
 * @author Ishita_Mathur
 * Here many getter setter are present to initializes the Cage properties
 */
public class Cage
{
	private AnimalName animalType;
	private int capacity;
	ArrayList<Animal> listOfAnimals = new ArrayList<>();
			
	public Cage(AnimalName animalType, int capacity)
	{
		this.animalType = animalType;
		this.capacity = capacity;
	}
	
	public AnimalName getAnimalType()
	{
		return animalType;
	}

	public void setAnimalType(AnimalName animalType)
	{
		this.animalType = animalType;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}

	public ArrayList<Animal> getListOfAnimals()
	{
		return listOfAnimals;
	}

	public void addAnimal(Animal animal)
	{
			listOfAnimals.add(animal);	
	}
	
	public boolean removeAnimal()
	{	
		boolean removed = false;	
		if(listOfAnimals.size() > 0)
		{
			listOfAnimals.remove(0);
			removed = true;
		}
		return removed;
	}
	
	public int spareCapacity()
	{
		return capacity - listOfAnimals.size();
	}
}