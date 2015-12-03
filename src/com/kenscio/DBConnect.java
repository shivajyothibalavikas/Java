package com.kenscio;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect 
{
	public void getConnection()
	{
		Connection con = null;
		try 
		{
			Class.forName("java.sql.DriverManager");
			//con = DriverManager.getConnection("url");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Exception" + e);
		}
	}

}
