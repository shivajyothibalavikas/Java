package com.kenscio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
	static Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		try 
		{
			String currentdir = new File("").getAbsolutePath();
			System.out.println(currentdir);
			File configFile = new File(currentdir+"/vikas/Java/properties/DBConnect.properties");
			Properties props = new Properties();
			FileReader reader = new FileReader(configFile);
			props.load(reader);
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded....");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("connected....");
			
			
		} 
		
		catch (IOException e) 
		{
			System.out.println("Exception:" + e);
		}
		return con;
		

	}

}
