package employee;

import java.util.Comparator;

/**
 * used for imposing total ordering on Employee
 * @author Ishita_Mathur
 *
 */
public class NameComparator implements Comparator<Employee>
{
	/**
	 * method used for imposing total ordering by name on Employee
	 */
	@Override
	public int compare(Employee firstEmployee, Employee secondEmployee)
	{    
		return firstEmployee.getName().compareTo(secondEmployee.getName());
	}
}