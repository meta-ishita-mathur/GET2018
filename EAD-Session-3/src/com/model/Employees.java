package com.model;

public class Employees {
	@Override
	public String toString() {
		return "Employees [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age=" + age
				+ "]";
	}

	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	public Employees(String firstName, String lastName, String email, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	   
    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Employees)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
       Employees c = (Employees) o;
         
        // Compare the data members and return accordingly 
        return (this.getEmail().compareTo(c.getEmail())==0);
               
    }
    
    @Override
    public int hashCode()
    {
        return (int) (this.age+Math.random());
    }
     
}
