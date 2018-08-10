package employee;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EmployeeTest
{
	/**
	 * test case for adding employees in SortByNaturalOrder class object, it rejects employees with duplicate id 
	 */
	@Test
	public void sortByNaturalOrderTestFirst()
	{
		SortByNaturalOrder collection = new SortByNaturalOrder();

		assertTrue(collection.addEmployee(new Employee(19, "Prakalpa", "delhi")));
		assertTrue(collection.addEmployee(new Employee(25, "Deekshika", "alwar")));
		assertFalse(collection.addEmployee(new Employee(19, "Anshul", "gurgaon")));
		assertTrue(collection.addEmployee(new Employee(27, "Shalu", "delhi")));
		assertFalse(collection.addEmployee(new Employee(25, "Disha", "mumbai")));
		assertTrue(collection.addEmployee(new Employee(17, "arjita", "gwalior")));
		assertTrue(collection.addEmployee(new Employee(3, "Tanu", "jaipur")));
	}

	/**
	 * test case for trying to add null in SortByNaturalOrder class object
	 */
	@Test
	public void sortByNaturalOrderTestSecond()
	{
		SortByNaturalOrder collection = new SortByNaturalOrder();
		try
		{
			assertTrue(collection.addEmployee(new Employee(19, "Prakalpa", "delhi")));
			collection.addEmployee(null);
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid input", error.getMessage());
		}
	}

	/**
	 * test case for sortByNaturalOrder method of SortByNaturalOrder class
	 */
	@Test
	public void sortByNaturalOrderTestThird()
	{
		SortByNaturalOrder collection = new SortByNaturalOrder();

		collection.addEmployee(new Employee(19, "Prakalpa", "delhi"));
		collection.addEmployee(new Employee(25, "Deekshika", "alwar"));
		collection.addEmployee(new Employee(19, "Anshul", "gurgaon"));
		collection.addEmployee(new Employee(27, "Shalu", "delhi"));
		collection.addEmployee(new Employee(25, "Disha", "mumbai"));
		collection.addEmployee(new Employee(17, "arjita", "gwalior"));
		collection.addEmployee(new Employee(3, "Tanu", "jaipur"));

		collection.sortByNaturalOrder();

		ArrayList<Employee> expectedCollection = new ArrayList<>();
		expectedCollection.add(new Employee(3, "Tanu", "jaipur"));
		expectedCollection.add(new Employee(17, "arjita", "gwalior"));
		expectedCollection.add(new Employee(19, "Prakalpa", "delhi"));
		expectedCollection.add(new Employee(25, "Deekshika", "alwar"));
		expectedCollection.add(new Employee(27, "Shalu", "delhi"));

		for(int i = 0; i < collection.getCollectionOfEmployee().size(); i++)
			assertEquals(expectedCollection.get(i).getEmpId(), collection.getCollectionOfEmployee().get(i).getEmpId());
	}

	/**
	 * test case for adding employees in SortByName class object, it rejects employees with duplicate id 
	 */
	@Test
	public void sortByNameTestFirst()
	{
		SortByName collection = new SortByName();

		assertTrue(collection.addEmployee(new Employee(19, "Prakalpa", "delhi")));
		assertTrue(collection.addEmployee(new Employee(25, "Deekshika", "alwar")));
		assertFalse(collection.addEmployee(new Employee(19, "Anshul", "gurgaon")));
		assertTrue(collection.addEmployee(new Employee(27, "Shalu", "delhi")));
		assertFalse(collection.addEmployee(new Employee(25, "Disha", "mumbai")));
		assertTrue(collection.addEmployee(new Employee(17, "arjita", "gwalior")));
		assertTrue(collection.addEmployee(new Employee(3, "Tanu", "jaipur")));
	}


	/**
	 * test case for trying to add null in SortByName class object
	 */
	@Test
	public void sortByNameTestSecond()
	{
		SortByName collection = new SortByName();
		try
		{
			assertTrue(collection.addEmployee(new Employee(19, "Prakalpa", "delhi")));
			collection.addEmployee(null);
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid input", error.getMessage());
		}
	}


	/**
	 * test case for sortByName method of SortByName class
	 */
	@Test
	public void sortByNameTestThird()
	{
		SortByName collection = new SortByName();

		collection.addEmployee(new Employee(19, "Prakalpa", "delhi"));
		collection.addEmployee(new Employee(25, "Deekshika", "alwar"));
		collection.addEmployee(new Employee(19, "Anshul", "gurgaon"));
		collection.addEmployee(new Employee(27, "Shalu", "delhi"));
		collection.addEmployee(new Employee(25, "Disha", "mumbai"));
		collection.addEmployee(new Employee(17, "Arjita", "gwalior"));
		collection.addEmployee(new Employee(3, "Tanu", "jaipur"));

		collection.sortByName();

		ArrayList<Employee> expectedCollection = new ArrayList<>();
		expectedCollection.add(new Employee(17, "Arjita", "gwalior"));
		expectedCollection.add(new Employee(25, "Deekshika", "alwar"));
		expectedCollection.add(new Employee(19, "Prakalpa", "delhi"));
		expectedCollection.add(new Employee(27, "Shalu", "delhi"));
		expectedCollection.add(new Employee(3, "Tanu", "jaipur"));

		for(int i = 0; i < collection.getCollectionOfEmployee().size(); i++)
		{
			assertEquals(expectedCollection.get(i).getEmpId(), collection.getCollectionOfEmployee().get(i).getEmpId());

		}
	}

	/**
	 * test case for adding employees in CollectionWithoutDuplicates class object
	 */
	@Test
	public void collectionWithoutDuplicatesTestFirst()
	{
		CollectionWithoutDuplicates collection = new CollectionWithoutDuplicates();

		assertTrue(collection.addEmployee(new Employee(19, "Prakalpa", "delhi")));
		assertTrue(collection.addEmployee(new Employee(25, "Deekshika", "alwar")));
		assertFalse(collection.addEmployee(new Employee(19, "Anshul", "gurgaon")));
		assertTrue(collection.addEmployee(new Employee(27, "Shalu", "delhi")));
		assertFalse(collection.addEmployee(new Employee(25, "Disha", "mumbai")));
		assertTrue(collection.addEmployee(new Employee(17, "Arjita", "gwalior")));
		assertTrue(collection.addEmployee(new Employee(3, "Tanu", "jaipur")));
	}


	/**
	 * test case for trying to add null in CollectionWithoutDuplicates class object
	 */
	@Test
	public void collectionWithoutDuplicatesTestSecond()
	{
		SortByName collection = new SortByName();
		try
		{
			collection.addEmployee(new Employee(19, "Prakalpa", "delhi"));
			collection.addEmployee(null);
		}
		catch(AssertionError error)
		{
			assertEquals("Invalid input", error.getMessage());
		}
	}
}