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
	public void init() throws ServletException 
	{
		
			try 
			{
				con = DBConnect.getConnection(); 
				
			} 
			catch (SQLException e) 
			{
				System.out.println("Exception" + e);
			}
			catch (ClassNotFoundException e) 
			{
				System.out.println("Exception" + e);
			} 
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd1 = request.getRequestDispatcher("/jsp/Welcome.jsp"); 
		RequestDispatcher rd2 = request.getRequestDispatcher("/html/login.html");
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String select_querry = "SELECT NAME,PASSWORD FROM CUSTOMER WHERE NAME='" + name +"';" ;
		java.sql.Statement smt;
		try 
		{
			ResultSet rs=null;
			smt = con.createStatement();
			rs = smt.executeQuery(select_querry);
			if(!(rs.next()))
			{
				System.out.println("mark");
				pw.println("Invalid user!!! Plese try again");
				rd2.include(request, response);
			}
			String dbpass = rs.getString(2);
			if (pass.equalsIgnoreCase(dbpass)) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				rd1.forward(request, response);
			}
			else
			{
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<h1> U have entered a wrong password.<br> please try later" );
				pw.println("<body>");
				pw.println("</html>");
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Exception" + e);
		}
		
	}

}
