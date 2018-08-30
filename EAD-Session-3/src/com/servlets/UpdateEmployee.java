package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoModelLayer.SearchEmployeeDaoImplementation;
import com.model.Employees;

public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<h1>employee</h1>");

		System.out.println("sdsad");
		
		String email = request.getParameter("email");
		System.out.println(email);
		SearchEmployeeDaoImplementation empdao = new SearchEmployeeDaoImplementation();
		Employees employee = empdao.get(email);
		
		


		out.println("<html><body><form action = 'UpdateDataOfEmployee'>");

		out.println("<table align = 'center'>");

		out.println("<tr><td><p>First Name: </p><td><input type = 'text' name = 'first_name' id = 'first_name' value = '"
				+ employee.getFirstName() + "'></td></tr>");
		out.println("<tr><td><p>Last Name: </p><td><input type = 'text' name = 'last_name' id = 'last_name' value = '"
				+ employee.getLastName() + "'></td></tr>");
		out.println("<tr><td><p>Age: </p><td><input type = 'text' id = 'age' name = 'age' value = '"
				+ employee.getAge() + "'></td></tr>");
		out.println("<tr><td><p>Email: </p><td><input type = 'text' id = 'email' name = 'email' readonly value = '"
				+ employee.getEmail() + "'></td></tr>");
		out.println("<tr><td></td><td><input type = 'submit' value = 'update' ></tr>");
		out.println("</form></table>");
		out.println("<html><body>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}