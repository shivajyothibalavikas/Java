package com.kenscio;

import java.io.IOException;
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
		//response.setContentType("text/html");
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String querry = "INSERT INTO CUSTOMER(NAME,PASSWORD,EMAIL,PHONENO,GENDER)VALUES(" + "'" +name +"','" + pass + "','" + email + "'," + phone + ",'" + gender + "');" ;
		System.out.println(querry);
		try 
		{
			java.sql.Statement smt = con.createStatement();
			int result = smt.executeUpdate(querry);
			System.out.println(result);
		}
		catch (SQLException e) 
		{
			System.out.println("Exception" + e);
		}
		
	}
}
