package com.metacube.userLogin.filters;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class UserDetailsFilter
 */

public class UserDetailsFilter implements Filter
{
    /**
     * Default constructor. 
     */
    public UserDetailsFilter()
    {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		String firstName, lastName, contact, password, confirmPassword, messageToShowOnView; 
		
		firstName = request.getParameter("first_name");
		lastName = request.getParameter("last_name");
		contact = request.getParameter("contact");
		password = request.getParameter("password");
		confirmPassword = request.getParameter("confirm_password");
		messageToShowOnView = getValidationMessage(firstName, lastName, contact, password, confirmPassword);
		
		if("".equals(messageToShowOnView))
		{
			chain.doFilter(request, response);
		}
		else
		{
			request.setAttribute("message", messageToShowOnView );
			RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/register_user.jsp");
			RequetsDispatcherObj.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}
	
	private String getValidationMessage(String firstName, String lastName, String contact, String password, String confirmPassword)
	{
		String message = "";
		if(!checkName(firstName))
		{
			message = message + "ERROR : first name should be alphabate and minimum of 3 character: "; 
		}
		if(!checkName(lastName))
		{
			message = message + "ERROR : last name should be alphabate and minimum of 3 character: "; 
		}
		if(!checkContact(contact))
		{
			message = message + "ERROR : invalid contact 10 digits are required: "; 
		}
		if(!checkPassword(password)){
			message = message + "ERROR : password should be alphanumeric EG: Demo@1234 and consist minimum 8 character: "; 
		}
		if(!checkConfirmPassword(password, confirmPassword))
		{
			message = message + "ERROR : password and confirm password are not same: "; 
		}
		return message;	
	}

	private boolean checkName(String name)
	{
		return Pattern.matches("^[A-Za-z]{3,15}$", name);
	}
	
	private boolean checkContact(String contact)
	{
		return Pattern.matches("^[0-9]{10}$", contact);
	}
	
	private boolean checkPassword(String password)
	{
		return Pattern.matches("^(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&*()_+!])(?=.*[A-Z]).{8,}$",password);
	}
	
	private boolean checkConfirmPassword(String password, String confirmPassword)
	{
		return password.equals(confirmPassword);
	}
}