package com.kenscio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
	Connection con = null;
	java.sql.Statement smt;
	

	public void init() throws ServletException 
	{

		try 
		{
			con = DBConnect.getConnection();

		} catch (SQLException e) {
			System.out.println("Exception" + e);
		} catch (ClassNotFoundException e) {
			System.out.println("Exception" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd1 = request.getRequestDispatcher("/jsp/Welcome.jsp");
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String select_querry = "SELECT NAME,PASSWORD FROM CUSTOMER WHERE NAME='" + name + "';";
		try 
		{
			
			ResultSet rs = null;
			smt = con.createStatement();
			rs = smt.executeQuery(select_querry);
			if (!(rs.next())) {
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<h1>Invalid user!!! Plese try again</h1><br>");
				pw.println("<a href='html/login.html'>click here to login again</a>");
				pw.println("</body>");
				pw.println("</html>");
				

			} else {
				String dbpass = rs.getString(2);
				if (pass.equalsIgnoreCase(dbpass)) {
					HttpSession session = request.getSession();
					session.setAttribute("name", name);
					rd1.forward(request, response);
				} else {
					pw.println("<html>");
					pw.println("<body>");
					pw.println("<h1> U have entered a wrong password.<br> please try again</h1><br>");
					pw.println("<a href='html/login.html'>click here to login again </a>");
					pw.println("</body>");
					pw.println("</html>");
				}
			}
		}
		catch (SQLException e)
		{
			System.out.println("Exception" + e);
		}
		finally
		{
			try 
			{
				pw.close();
				smt.close();
			} 
			catch (SQLException e) {
				System.out.println("Error while closing statement object\n + e");
			}
		}

	}
	public void destroy() 
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Error while closing the resource" + e);
		}
	}

}
