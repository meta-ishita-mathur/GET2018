package com.metacube.userLogin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.metacube.userLogin.enums.Status;
import com.metacube.userLogin.facade.UserFacade;
import com.metacube.userLogin.models.User;
import com.metacube.userLogin.view.ProfileView;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UserImageController
 */
public class UserImageController extends HttpServlet
{
	UserFacade userFacade = UserFacade.getInstance();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserImageController()
	{

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException
	{

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String fileName = "", message = "", upload;
			MultipartRequest multipartRequest = new MultipartRequest(request, "C://Users//User6//workspace//EAD-Session-4//WebContent//images");
			Enumeration files = multipartRequest.getFileNames();
			
			while(files.hasMoreElements() )
			{
				upload = (String)files.nextElement();
				fileName = multipartRequest.getFilesystemName(upload);
			}

			Status status = userFacade.addImageUrl("./images/"+fileName,request.getSession().getAttribute("email").toString());
			switch(status)
			{
				case CREATED: break;
				case DELETED: break;
				case DUPLICATE_USER: break;
				case ERROR: message = "error in uploading";
							break;
				case NOT_FOUND: break;
				case OK: message = "image has been added";
						 break;
				case UPDATED: break;
				default: break;
			}
			request.setAttribute("image_message", message);

			ProfileView profileView = userFacade.getUserProfileData(request.getSession().getAttribute("email").toString());

			request.setAttribute("profile_data", profileView);
			request.setAttribute("visibility", "block");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
			requestDispatcher.forward(request, response);
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
}