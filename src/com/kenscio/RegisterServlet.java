package com.kenscio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet 
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String querry = "INSERT INTO CUSTOMER(NAME,PASSWORD,EMAIL,PHONENO,GENDER)VALUES(" + "'" +name +"','" + pass + "','" + email + "'," + phone + ",'" + gender + "');" ;
		try 
		{
			java.sql.Statement smt = con.createStatement();
			int result = smt.executeUpdate(querry);
			if(result>0)
			{
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<h1>User '"+ name + "' successfully added to the database...</h1><br/>");
				pw.println("<a href='html/login.html'>click here to loginS</a>");
				pw.println("</body>");
				pw.println("</html>");
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Exception" + e);
		}
		
	}
}
