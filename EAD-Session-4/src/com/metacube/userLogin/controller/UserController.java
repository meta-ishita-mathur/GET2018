package com.metacube.userLogin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.metacube.userLogin.enums.Status;
import com.metacube.userLogin.facade.UserFacade;

/**
 * Servlet implementation class UserController
 */

public class UserController extends HttpServlet
{
	private static final long serialVersionUID = 1L;	
	private UserFacade userFacade = UserFacade.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController()
    {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName, lastName, dob, contact, email, password, orgName, message;
		int age;
		
		firstName = request.getParameter("first_name");
		lastName = request.getParameter("last_name");
		age = Integer.parseInt(request.getParameter("age").toString());
		dob = request.getParameter("dob");
		contact = request.getParameter("contact");
		email = request.getParameter("email");
		password = request.getParameter("password");
		orgName = request.getParameter("organization");
		Status status = userFacade.registerUser(firstName, lastName, age, dob, contact, email, password, orgName);
		message = getStatusMessage(status);
		request.setAttribute("register_message", message);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private String getStatusMessage(Status status)
	{
		String message = "";
		switch(status)
		{
			case CREATED: message = message + " user has been registerd ";
						  break;
			case DUPLICATE_USER: message = message + " user already exists ";
								 break;
			case ERROR: message = message + " ERROR: ";
						break;	
		}
		return message;
	}
}