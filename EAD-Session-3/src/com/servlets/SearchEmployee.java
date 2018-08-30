package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoModelLayer.SearchEmployeeDaoImplementation;
import com.model.Employees;

/**
 * Servlet implementation class SearchEmployee
 */
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Employees employeeToBeSearched=null;
		// TODO Auto-generated method stub
		String name = request.getParameter("Name");
		String nameArray[] = name.split("\\s+");
		employeeToBeSearched = filterFunction(nameArray);
		if(employeeToBeSearched.getFirstName()!="")
		{
			SearchEmployeeDaoImplementation object = new SearchEmployeeDaoImplementation();
			List<Employees> resultList = object.get(employeeToBeSearched);
			display(resultList,response);
		}
		else
		{	
			out.println("Search Field Is Empty!!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void display(List<Employees> resultList,HttpServletResponse response){
		try{
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<table border = 'solid' align = 'center'><th>Name</th><th>Email</th><th>Age</th>");
		for (Employees emp : resultList) {
			out.println("<tr><td>" + emp.getFirstName() + emp.getLastName()
			+ "</td><td>" + emp.getEmail() + "</td><td>" + emp.getAge()
			+ "</td></tr>");
			}
		out.println("</table>");
		out.println("</html></body>");
		}catch(IOException e)
		{
			System.out.println("Input Output Exception");
		}
	}
	
	public Employees filterFunction(String nameArray[])
	{
		Employees employeeToBeSearched = null;
		if(nameArray.length == 2)
		{
			employeeToBeSearched = new Employees(nameArray[0],nameArray[1],"",-1);
			
		}
		else if(nameArray.length == 1)
		{
			employeeToBeSearched = new Employees(nameArray[0],"","",-1);
		}
		else if(nameArray.length > 2)
		{
			employeeToBeSearched = new Employees(nameArray[0],nameArray[nameArray.length - 1],"",-1);
		}
		else
		{
			employeeToBeSearched = new Employees("","","",-1);
		}
		return employeeToBeSearched;
	}
}
