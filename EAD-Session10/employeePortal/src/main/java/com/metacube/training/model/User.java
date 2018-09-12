package com.metacube.training.model;

public class User
{
	private String firstName, lastname, emailAddress, empCode, appUrl, password;
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getAppUrl()
	{
		return appUrl;
	}
	
	public void setAppUrl(String appUrl)
	{
		this.appUrl = appUrl;
	}
	
	public String getEmpCode()
	{
		return empCode;
	}
	
	public void setEmpCode(String empCode)
	{
		this.empCode = empCode;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}