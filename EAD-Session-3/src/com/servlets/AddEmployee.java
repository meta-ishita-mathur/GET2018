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


public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String email = request.getParameter("Email");
		int age = Integer.parseInt(request.getParameter("Age"));
		Employees objectToBeAdded = new Employees(firstName,lastName,email,age);
		AddEmployeeDaoImplementation object = new AddEmployeeDaoImplementation(); 
		boolean flag = object.add(objectToBeAdded);  
		if(flag)
		{
			out.println("/n Employee Added Succesfully");
		}
		else
		{
			out.println("/n Employee Not Added");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
