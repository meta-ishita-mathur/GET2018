package com.metacube.training.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Employee
{
	private String empCode, firstName, lastName, gender, primaryContactNumber, secondaryContactNumber;
	private String emailId, skypeId, profilePicture, password, jobTitle;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	Date dob;
	private boolean isEnabled;
	
	public String getJobTitle()
	{
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}

	public String getEmpCode()
	{
		return empCode;
	}
	
	public void setEmpCode(String empCode)
	{
		this.empCode = empCode;
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
	
	public Date getDob()
	{
		return dob;
	}
	
	public void setDob(Date dob)
	{
		this.dob = dob;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String getPrimaryContactNumber()
	{
		return primaryContactNumber;
	}
	
	public void setPrimaryContactNumber(String primaryContactNumber)
	{
		this.primaryContactNumber = primaryContactNumber;
	}
	
	public String getSecondaryContactNumber()
	{
		return secondaryContactNumber;
	}
	
	public void setSecondaryContactNumber(String secondaryContactNumber)
	{
		this.secondaryContactNumber = secondaryContactNumber;
	}
	
	public String getEmailId()
	{
		return emailId;
	}
	
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	
	public String getSkypeId()
	{
		return skypeId;
	}
	
	public void setSkypeId(String skypeId)
	{
		this.skypeId = skypeId;
	}
	
	public String getProfilePicture()
	{
		return profilePicture;
	}
	
	public void setProfilePicture(String profilePicture)
	{
		this.profilePicture = profilePicture;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public boolean isEnabled()
	{
		return isEnabled;
	}
	
	public void setEnabled(boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}
}