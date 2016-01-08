package com.kenscio.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kenscio.util.DBConnect;
import com.kenscio.to.Books;

public class FetchDataFromDb {
	
	static Connection con = null;
	static ResultSet rs = null;
	static Statement smt = null;
	static 
	{
		try 
		{
			con = DBConnect.getConnection();
			smt = con.createStatement();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	

	
	public static List<Books> GetBookData() throws IOException {
		
		System.out.println("entered salesdata()");
		
		List<Books> SalesData = new ArrayList<Books>();
		final String select_all_book_querry = "SELECT * FROM BOOKS;";
		try 
		{
			rs = smt.executeQuery(select_all_book_querry);
			System.out.println("executed query");
			while(rs.next()) 
			{
				System.out.println("rs has elements");
				Books to = new Books();
				System.out.println("created book to");
				to.setBook_id(rs.getLong("ID"));
				System.out.println("got id");
				to.setBook_name(rs.getString("NAME"));
				to.setBook_category(rs.getString("CATEGORY"));
				to.setISBN(rs.getLong("ISBN"));
				SalesData.add(to);
				System.out.println("completed");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		return SalesData;
	}

}
