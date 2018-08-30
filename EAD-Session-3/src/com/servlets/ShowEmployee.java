package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daoModelLayer.AddEmployeeDaoImplementation;
import com.daoModelLayer.ShowEmployeeDaoImplementation;
import com.model.Employees;

/**
 * Servlet implementation class ShowEmployee
 */
public class ShowEmployee extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    	/**
     	* @see HttpServlet#HttpServlet()
     	*/
    	public ShowEmployee()
	{
        	super();
    	}
	
	/**
	 * service method to show all the employees
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ShowEmployeeDaoImplementation showObject = new ShowEmployeeDaoImplementation(); 
		List<Employees> resultList = showObject.getAll();
		out.println("<html><body>");
		out.println("<table border = 'solid' align = 'center'><th>Name</th><th>Email</th><th>Age</th><th width = \"20%\"></th>");
		for (Employees employee : resultList)
		{
			out.println("<tr><td>" + employee.getFirstName() + employee.getLastName()
			+ "</td><td>" + employee.getEmail() + "</td><td>" + employee.getAge()
			+ "</td><td><a href = 'UpdateEmployee?email="
			+ employee.getEmail()
			+ "'><input type = 'button' value = 'update'></a></td></tr>");
		}
		out.println("</table>");
		out.println("</html></body>");
	}

	/**
     	 * service method to show all the employees
     	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
