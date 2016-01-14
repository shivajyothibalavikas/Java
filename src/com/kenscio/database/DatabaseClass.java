package com.kenscio.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kenscio.to.Books;
import com.kenscio.util.DBConnect;

public class DatabaseClass 
{

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
	
	
	public static Map<Long, Books> getBook()										
	{

		final String select_all_book_querry = "SELECT * FROM BOOKS;";
		Map<Long,Books> books = new HashMap<>();
		try 
		{
			rs = smt.executeQuery(select_all_book_querry);
			while(rs.next())
			{
				Books to = new Books();
				to.setBook_id(rs.getLong(1));
				to.setBook_name(rs.getString(2));
				to.setBook_category(rs.getString(3));
				to.setISBN(rs.getLong(4));
				books.put(rs.getLong(1), to);
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
		return books;
	}
	
	public static void putBook(Books b)												//adding a book
	{
		final String put_book_querry = "INSERT INTO BOOKS(NAME,CATEGORY,ISBN) VALUES('" + b.getBook_name() + "','"+ b.getBook_category() + "'," + b.getISBN() +");";
		System.out.println(put_book_querry);
		try 
		{
			smt.executeUpdate(put_book_querry);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void removeBook(long bookid) 										//removing a book
	{
		final String remove_book_querry = "DELETE FROM BOOKS WHERE ID="+ bookid + ";";
		try 
		{
			smt.executeUpdate(remove_book_querry);
		} 
		catch (SQLException e) {
			System.out.println("Exception" + e);
		}
	}

	public static boolean loginCheck(String name, String md5_of_pass) 
	{
		boolean user = false;
		String select_querry = "SELECT NAME,PASSWORD FROM CUSTOMER WHERE NAME='" + name + "';";
		try 
		{
			smt = con.createStatement();
			rs = smt.executeQuery(select_querry);
			if (rs.next()) 
			{
				String dbpass = rs.getString(2);
				if (md5_of_pass.equals(dbpass)) 
				{
					user = true;
				} 
				
			}
			
		} catch (SQLException e) {
			System.out.println("Exception" + e);
		} 
		
		return user;

	}

	public static boolean registerUser(String name, String md5_of_pass, String email, String phone, String gender) 
	{
		boolean reg = false;
		String querry = "INSERT INTO CUSTOMER(NAME,PASSWORD,EMAIL,PHONENO,GENDER)VALUES(" + "'" + name + "','"
				+ md5_of_pass + "','" + email + "'," + phone + ",'" + gender + "');";
		try 
		{
			smt = con.createStatement();
			int result = smt.executeUpdate(querry);
			if (result > 0) 
			{
				reg= true;
			}
		} catch (SQLException e) {
			System.out.println("Exception" + e);
		}
		return reg;
	} 
	
		
	
}