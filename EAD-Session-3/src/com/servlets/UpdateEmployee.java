package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daoModelLayer.SearchEmployeeDaoImplementation;
import com.model.Employees;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployee()
	{
		super();
	}
	
	/**
	 * service method to allow user to edit employee details
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>employee</h1>");
		
		email = request.getParameter("email");
		SearchEmployeeDaoImplementation searchObject = new SearchEmployeeDaoImplementation();
		Employees employee = searchObject.get(email);

		out.println("<html><body><form action = 'UpdateDataOfEmployee'>");
		out.println("<table align = 'center'>");
		out.println("<tr><td><p>First Name: </p><td><input type = 'text' name = 'first_name' id = 'first_name' value = '" + employee.getFirstName() + "'></td></tr>");
		out.println("<tr><td><p>Last Name: </p><td><input type = 'text' name = 'last_name' id = 'last_name' value = '" + employee.getLastName() + "'></td></tr>");
		out.println("<tr><td><p>Age: </p><td><input type = 'text' id = 'age' name = 'age' value = '" + employee.getAge() + "'></td></tr>");
		out.println("<tr><td><p>Email: </p><td><input type = 'text' id = 'email' name = 'email' readonly value = '" + employee.getEmail() + "'></td></tr>");
		out.println("<tr><td></td><td><input type = 'submit' value = 'update' ></tr>");
		out.println("</form></table>");
		out.println("<html><body>");
	}

	/**
     	 * service method to allow user to edit employee details
     	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
