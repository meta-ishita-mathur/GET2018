package com.model;

/**
 * Class to store the Employee Details
 */
public class Employees
{
	private String firstName, lastName, email;
	private int age;
	
	/**
     	 * constructor
     	 * @param firstName
     	 * @param lastName
     	 * @param email
     	 * @param age
     	 */
	public Employees(String firstName, String lastName, String email, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	 /**
     	 * getter method for firstName
     	 * @return firstName
     	 */
	public String getFirstName()
	{
		return firstName;
	}

	 /**
     	  * setter method for firstName
     	  * @param firstName
     	  */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
     	 * getter method for lastName
     	 * @return lastName
     	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
     	 * setter method for lastName
     	 * @param lastName
     	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
     	 * getter method for email
     	 * @return email
     	 */
	public String getEmail()
	{
		return email;
	}

	/**
     	 * setter method for email
     	 * @param email
     	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
     	 * getter method for age
     	 * @return age
     	 */
	public int getAge()
	{
		return age;
	}

	/**
     	 * setter method for age
     	 * @param age
     	 */
	public void setAge(int age)
	{
		this.age = age;
	}
    	
	public boolean equals(Object object)
	{
        	// If the object is compared with itself then return true  
        	if (object == this)
            		return true;
        	
		// Check if object is an instance of Complex or not "null instanceof [type]" also returns false
        	if (!(object instanceof Employees))
            		return false;
         
        	// typecast o to Complex so that we can compare data members 
       		Employees employee = (Employees) object;
         
        	// Compare the data members and return accordingly 
        	return (this.getEmail().compareTo(employee.getEmail()) == 0);
    	}
    	
	public int hashCode()
    	{
        	return (int) (this.age + Math.random());
    	}
	
	public String toString()
	{
		return "Employees [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}
}
