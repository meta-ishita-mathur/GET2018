package zooManagement;

import java.util.Scanner;

/**
 * This is the main method from where zoo management is begin
 * @author Ishita_Mathur
 */
public class ZooManagementSystem
{
	public static void main(String[] args)
	{
		int choice, capacity, capacityOfCage;
		boolean hasPark, hasCanteen;
		AnimalFamily zoneType;
		AnimalName cageType, animalType, firstAnimalType;
		
		Zoo zoo = new Zoo(); // create object of zoo class
		
		// a do while loop which is true for each situation
		do
		{
			System.out.print("\nMENU!!!!\n1. Add Zone to the Zoo\n2. Add Cage to the Zone\n3. Add Animal to cage\n4. Remove animal from cage\n");
			System.out.print("Enter your choice..");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) // this switch case will show various operations of zoo class
			{
				case 1: zoneType = chooseZone(sc);
					System.out.println("Please enter the capacity");
					capacity = sc.nextInt();
					System.out.println("Does the zone has a park? (Enter true or false)");
					hasPark = sc.nextBoolean();
					System.out.println("Does the zone has a canteen? (Enter true or false)");
					hasCanteen = sc.nextBoolean();
			
					zoo.addZone(zoneType, capacity, hasPark, hasCanteen);
					break;
			
				case 2: cageType = chooseCage(sc);
					System.out.println("Enter the capacity of the cage");
					capacityOfCage = sc.nextInt();
		
					if(zoo.addCage(cageType, capacityOfCage))
						System.out.println("Cage is successfully added");
					break;
		    
				case 3: animalType = chooseCage(sc);
			        	Animal animal = addNewAnimal(sc, animalType);
			        	if(zoo.addAnimal(animal))
			        		System.out.println("Animal added successfully");
			        	break;
			
				case 4: firstAnimalType = chooseCage(sc);
					if(zoo.removeAnimal(firstAnimalType))
						System.out.println("Remove successfully");
					break;
			}
		}while(choice != 4);
	}

	/**
	 * This will create a animal object to add animal
	 * @param sc
	 * @param animalType
	 * @return animal object
	 */
	private static Animal addNewAnimal(Scanner sc, AnimalName animalType)
	{	
		Animal animal = null;
		double weight, wingSpan;
		int age;
		
		switch(animalType)
		{
			case CROCODILE: System.out.println("Enter the weight and age of crocodile");
		     			weight = sc.nextDouble();
		     			age = sc.nextInt();
		     			animal = new Crocodile(weight, age);
		    			break;
			
			case ELEPHANT: System.out.println("Enter the weight and age of elephant");
	         		       weight = sc.nextDouble();
	         		       age = sc.nextInt();
	         		       animal = new Elephant(weight, age);
	         		       break;
			
			case LION: System.out.println("Enter the weight and age of Lion");
				   weight = sc.nextDouble();
				   age = sc.nextInt();
				   animal = new Lion(weight, age);
				   break;
			
			case PARROT: System.out.println("Enter the weight, age and wing span of Parrot");
	                  	     weight = sc.nextDouble();
	         		     age = sc.nextInt();
	         		     wingSpan = sc.nextDouble();
	         		     animal = new Parrot(weight, age, wingSpan);
	         		     break;
			
			case PEACOCK: System.out.println("Enter the weight, age and wing span of Peacock");
				      weight = sc.nextDouble();
				      age = sc.nextInt();
				      wingSpan = sc.nextDouble();
				      animal = new Peacock(weight, age, wingSpan);
				      break;
			
			case SNAKE: System.out.println("Enter the weight and age of snake");
				    weight = sc.nextDouble();
				    age = sc.nextInt();
				    animal = new Snake(weight, age);
				    break;
		}
		return animal;
	}

	/**
	 * Used to find animal name
	 * @param sc
	 * @return type of cage
	 */
	private static AnimalName chooseCage(Scanner sc)
	{
		int cage;
		AnimalName cageType = null;
		
		System.out.print("\nList of Cage Types\n1. Lion\n2. Elephant\n3. Parrot\n4. Peacock\n5. Snake\n6. Crocodile\n");
	    	System.out.print("Choose from the cage types..");
	    	cage = sc.nextInt();
	    
	    	switch(cage)
	    	{
	    		case 1: cageType = AnimalName.LION;
	    			break;
	    		case 2: cageType = AnimalName.ELEPHANT;
	    			break;
	    		case 3: cageType = AnimalName.PARROT;
	    			break;
	    		case 4: cageType = AnimalName.PEACOCK;
	    			break;
	    		case 5: cageType = AnimalName.SNAKE;
	    			break;
	    		case 6: cageType = AnimalName.CROCODILE;
	    			break;
	    		default: System.out.println("No result found!!");
				 break;	
	    	}
		return cageType;
	}
	
	/**
	 * Used to choose zone for animal
	 * @param sc
	 * @return type of zone
	 */
	private static AnimalFamily chooseZone(Scanner sc)
	{	
		int zone;
		AnimalFamily zoneType = null;
		System.out.print("\nList of Zones\n1. Bird\n2. Mammal\n3. Reptile\n");
	    	System.out.print("Choose from the zone types: ");
	    	zone = sc.nextInt();
	    
	    	switch (zone)
	    	{
			case 1: zoneType = AnimalFamily.BIRD;
				break;
			case 2: zoneType = AnimalFamily.MAMMAL;
				break;
			case 3: zoneType = AnimalFamily.REPTILE;
				break;
			default: System.out.println("No result found!!");
				 break;
		}
		return zoneType;
	}
}
