package employee;

import java.util.ArrayList;
import java.util.Collections;

/**
 * used to sort a list of Employees by name
 * @author Ishita_Mathur
 *
 */
public class SortByName
{
	ArrayList<Employee> collectionOfEmployee = new ArrayList<Employee>();

	/**
	 * getter of collectionOfEmployee list
	 * @return collectionOfEmployee
	 */
	public ArrayList<Employee> getCollectionOfEmployee()
	{    
		return collectionOfEmployee;
	}

	/**
	 * method for adding the given employee to the collectionOfEmployee list
	 * @param employee
	 * @return true if employee is added, false otherwise
	 */
	public boolean addEmployee(Employee employee)
	{      
		boolean flag = true;
		if(employee == null)
			throw new AssertionError("Invalid input");

		for (Employee employeeInCollection : collectionOfEmployee)
		{
			if (employee.getEmpId() == employeeInCollection.getEmpId())
			{
				flag = false;
				break;
			}
		}

		if (flag)
			collectionOfEmployee.add(employee);

		return flag;
	}

	/**
	 * method to sort the collectionOfEmployee list by name
	 */
	public void sortByName()
	{
		Collections.sort(collectionOfEmployee, new NameComparator());
	}
}