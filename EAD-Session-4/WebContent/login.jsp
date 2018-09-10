<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
</head>
<body>
	<h2>LOGIN PAGE</h2>

	<form action='login' method='post'>
		<table>
			<tr>
				<td>Email:</td>
				<td><input type='email' id='email' name='email'
					placeholder='write email here' required /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' id='password' name='password'
					required /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type='submit' value='submit' /></td>
			</tr>
		</table>
	</form>

	<%
		String registerMessage = (String) request.getAttribute("register_message");
		try
		{
			if (registerMessage.length() > 1)
			{
				out.println("<script> alert(\"" + registerMessage + "\""
						+ ")</script>");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	%>

	<%
		String loginMessage = (String) request.getAttribute("login_message");
		try
		{
			if(loginMessage.length() > 1)
			{
				out.println("<script> alert(\"" + loginMessage + "\""
						+ ")</script>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	%>
</body>
</html>