package employee;

import java.util.HashSet;
import java.util.Set;

/**
 * this class is used to create a collection for employees and avoid any duplicate employee entry
 * @author Ishita_Mathur
 *
 */
public class CollectionWithoutDuplicates
{
	Set<Employee> collectionOfEmployee = new HashSet<Employee>();

	/**
	 * getter for the collectionOfEmployee set
	 * @return collectionOfEmployee
	 */
	public Set<Employee> getCollectionOfEmployee()
	{
		return collectionOfEmployee;
	}

	/**
	 * this method is used to add employee to the collectionOfEmployee set
	 * @param employee
	 */
	public boolean addEmployee(Employee employee)
	{
		boolean flag = false;

		if(employee == null)
			throw new AssertionError("Invalid input");

		if(collectionOfEmployee.add(employee))
			flag = true;

		return flag;    	
	}
}