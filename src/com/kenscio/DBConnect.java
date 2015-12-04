package com.kenscio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
	public void getConnection()
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/Login" + "user=root&password=sringeri1992");
				System.out.println("connected....");
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Exception" + e);
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
	}

}
