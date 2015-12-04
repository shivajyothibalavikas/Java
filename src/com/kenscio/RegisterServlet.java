package com.kenscio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

public class RegisterServlet extends HttpServlet 
{
	public void init() throws ServletException 
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Login","vikas", "sringeri1992");
			System.out.println("connected....");
			java.sql.Statement smt = con.createStatement();
			
			
			
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
		
	}
}
