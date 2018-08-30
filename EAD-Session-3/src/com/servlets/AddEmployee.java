package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daoModelLayer.AddEmployeeDaoImplementation;
import com.model.Employees;

public class AddEmployee extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    	/**
     	 * @see HttpServlet#HttpServlet()
     	 */
    	public AddEmployee()
	{
        	super();
    	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName, lastName, email;
		int age;
		boolean addFlag;
		PrintWriter out = response.getWriter();
		
		firstName = request.getParameter("FirstName");
		lastName = request.getParameter("LastName");
		email = request.getParameter("Email");
		age = Integer.parseInt(request.getParameter("Age"));
		Employees objectToBeAdded = new Employees(firstName, lastName, email, age);
		AddEmployeeDaoImplementation object = new AddEmployeeDaoImplementation(); 
		addFlag = object.add(objectToBeAdded);  
		
		if(addFlag)
			out.println("/n Employee Added Succesfully");
		else
			out.println("/n Employee Not Added");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
