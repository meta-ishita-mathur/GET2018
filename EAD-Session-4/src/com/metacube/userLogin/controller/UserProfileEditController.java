package com.metacube.userLogin.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.metacube.userLogin.facade.UserFacade;
import com.metacube.userLogin.view.ProfileView;

/**
 * Servlet implementation class UserProfileEditController
 */

public class UserProfileEditController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserFacade userFacade = UserFacade.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileEditController()
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
		ProfileView profileView = userFacade.getUserProfileData(request.getSession().getAttribute("email").toString());
		request.setAttribute("profile_data", profileView);
		System.out.println(profileView.toString());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
		requestDispatcher.forward(request, response);
	}
}