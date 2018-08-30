package com.model;

public class Employees
{
	private String firstName, lastName, email;
	private int age;
	
	public Employees(String firstName, String lastName, String email, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getAge()
	{
		return age;
	}

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
