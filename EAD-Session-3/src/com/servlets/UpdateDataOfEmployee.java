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
 * Servlet implementation class UpdateDataOfEmployee
 */
public class UpdateDataOfEmployee extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDataOfEmployee()
	{
		super();
	}

	/**
	 * service method to update the details of given employee in database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName, lastName, email, message;
		int age;
		boolean isDataUpdate;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body><html>");
		firstName = request.getParameter("first_name");
		lastName = request.getParameter("last_name");
		age = Integer.parseInt(request.getParameter("age"));
		email = request.getParameter("email");

		SearchEmployeeDaoImplementation searchObject = new SearchEmployeeDaoImplementation();

		isDataUpdate = searchObject.update(new Employees(firstName, lastName, email, age));
		message = isDataUpdate ? "Data Has Been Update" : "Data is Not Updated";

		out.println("<h1 align = 'center'>" + message + "</h1>");
		out.println("<a href = 'index.html'>Home</a>");
		out.println("</body></hrml>");
		System.out.println("data has been updtaed: " + isDataUpdate);
	}

	/**
     	 * service method to update the details of given employee in database
     	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
