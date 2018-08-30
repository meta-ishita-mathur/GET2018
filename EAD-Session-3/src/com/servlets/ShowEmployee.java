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
public class ShowEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ShowEmployeeDaoImplementation object = new ShowEmployeeDaoImplementation(); 
		List<Employees> resultList = object.getAll();
		out.println("<html><body>");
		out.println("<table border = 'solid' align = 'center'><th>Name</th><th>Email</th><th>Age</th><th width = \"20%\"></th>");
		for (Employees emp : resultList) {
			out.println("<tr><td>" + emp.getFirstName() + emp.getLastName()
			+ "</td><td>" + emp.getEmail() + "</td><td>" + emp.getAge()
			+ "</td><td><a href = 'UpdateEmployee?email="
					+ emp.getEmail()
					+ "'><input type = 'button' value = 'update'></a></td></tr>");
			}
		out.println("</table>");
		out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
