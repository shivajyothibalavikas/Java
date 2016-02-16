package com.kenscio.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kenscio.to.Books;
import com.kenscio.util.DBConnect;

public class DatabaseClass {

	static Connection con = null;
	static ResultSet rs = null;
	static Statement smt = null;

	static {
		try {
			con = DBConnect.getConnection();
			smt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Map<Long, Books> getBook() {

		final String select_all_book_querry = "SELECT * FROM BOOKS;";
		Map<Long, Books> books = new HashMap<>();
		try {
			rs = smt.executeQuery(select_all_book_querry);
			while (rs.next()) {
				Books to = new Books();
				to.setBook_id(rs.getLong(1));
				to.setBook_name(rs.getString(2));
				to.setBook_category(rs.getString(3));
				to.setISBN(rs.getLong(4));
				books.put(rs.getLong(1), to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	@SuppressWarnings("unused")
	public static JSONObject getBookList(int totalRecords, HttpServletRequest req) throws SQLException {

		String GLOBAL_SEARCH_TERM;
		String COLUMN_NAME;
		String DIRECTION;
		int INITIAL;
		int RECORD_SIZE;
		String ID_SEARCH_TERM, NAME_SEARCH_TERM, CATEGORY_SEARCH_TERM, ISBN_SEARCH_TERM;

		String[] columnNames = { "ID", "NAME", "CATEGORY", "ISBN" };

		JSONObject jsonResult = new JSONObject();
		int listDisplayAmount = 10;
		int start = 0;
		int column = 0;
		String dir = "asc";
		String pageNo = req.getParameter("iDisplayStart");
		String pageSize = req.getParameter("iDisplayLength");
		String colIndex = req.getParameter("iSortCol_0");
		String sortDirection = req.getParameter("sSortDir_0");

		if (pageNo != null) {
			start = Integer.parseInt(pageNo);
			if (start < 0) {
				start = 0;
			}
		}
		if (pageSize != null) {
			listDisplayAmount = Integer.parseInt(pageSize);
			if (listDisplayAmount < 10 || listDisplayAmount > 100) {
				listDisplayAmount = 10;
			}
		}
		if (colIndex != null) {
			column = Integer.parseInt(colIndex);
			if (column < 0 || column > 3)
				column = 0;
		}
		if (sortDirection != null) {
			if (!sortDirection.equals("asc"))
				dir = "desc";
		}

		String colName = columnNames[column];

		RECORD_SIZE = listDisplayAmount;
		GLOBAL_SEARCH_TERM = req.getParameter("sSearch");
		COLUMN_NAME = colName;
		DIRECTION = dir;
		INITIAL = start;

		int totalAfterSearch = totalRecords;
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		String searchSQL = "";

		String sql = "SELECT " + "ID,NAME,CATEGORY,ISBN " + "FROM "
				+ "BOOKS " /* + "WHERE " */;

		String globeSearch = " WHERE ID like '%" + GLOBAL_SEARCH_TERM + "%'" + "or NAME like '%" + GLOBAL_SEARCH_TERM
				+ "%'" + "or CATEGORY like '%" + GLOBAL_SEARCH_TERM + "%'" + "or ISBN like  '%" + GLOBAL_SEARCH_TERM
				+ "%'";

		if (GLOBAL_SEARCH_TERM != "") {
			searchSQL = globeSearch;
		}

		sql += searchSQL;
		sql += " order by " + COLUMN_NAME + " " + DIRECTION;
		sql += " limit " + INITIAL + ", " + RECORD_SIZE;

		System.out.println("sql:" + sql);

		// for searching
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		System.out.println("resultset:" + rs);

		while (rs.next()) {
			JSONArray ja = new JSONArray();
			ja.put(rs.getString("ID"));
			ja.put(rs.getString("NAME"));
			ja.put(rs.getString("CATEGORY"));
			ja.put(rs.getString("ISBN"));
			array.put(ja);
		}

		String query = "SELECT " + "COUNT(*) as count " + "FROM " + "BOOKS ";

		// for pagination
		if (GLOBAL_SEARCH_TERM != "") {
			query += searchSQL;
			System.out.println("query:" + query);

			PreparedStatement smt = con.prepareStatement(query);
			ResultSet results = smt.executeQuery();

			if (results.next()) {
				totalAfterSearch = results.getInt("count");
			}
		}
		try {
			result.put("iTotalRecords", totalRecords);
			result.put("iTotalDisplayRecords", totalAfterSearch);
			result.put("aaData", array);
		} catch (Exception e) {

		}

		return result;
	}

	public static int getTotalRecordCount() throws SQLException {

		int totalRecords = -1;
		String sql = "SELECT " + "COUNT(*) as count " + "FROM " + "BOOKS";

		PreparedStatement smt = con.prepareStatement(sql);
		ResultSet resultSet = smt.executeQuery();

		if (resultSet.next()) {
			totalRecords = resultSet.getInt("count");
		}
		return totalRecords;
	}

	// adding a book

	public static void putBook(Books b) {
		final String put_book_querry = "INSERT INTO BOOKS(NAME,CATEGORY,ISBN) VALUES('" + b.getBook_name() + "','"
				+ b.getBook_category() + "'," + b.getISBN() + ");";
		try {
			smt.executeUpdate(put_book_querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// removing a book
	public static void removeBook(long bookid) {
		final String remove_book_querry = "DELETE FROM BOOKS WHERE ID=" + bookid + ";";
		try {
			smt.executeUpdate(remove_book_querry);
		} catch (SQLException e) {
			System.out.println("Exception" + e);
		}
	}

	// logging in user
	public static boolean loginCheck(String name, String md5_of_pass) {
		boolean user = false;
		String select_querry = "SELECT NAME,PASSWORD FROM CUSTOMER WHERE NAME='" + name + "';";
		try {
			rs = smt.executeQuery(select_querry);
			if (rs.next()) {
				String dbpass = rs.getString(2);
				if (md5_of_pass.equals(dbpass)) {
					user = true;
				}

			}

		} catch (SQLException e) {
			System.out.println("Exception" + e);
		}

		return user;

	}

	// registering user
	public static boolean registerUser(String name, String md5_of_pass, String email, String phone, String gender) {
		System.out.println(name + "" + md5_of_pass + "" + email + "" + phone + "" + gender);
		boolean reg = false;
		String querry = "INSERT INTO CUSTOMER(NAME,PASSWORD,EMAIL,PHONENO,GENDER)VALUES(" + "'" + name + "','"
				+ md5_of_pass + "','" + email + "'," + phone + ",'" + gender + "');";
		try {
			int result = smt.executeUpdate(querry);
			if (result > 0) {
				reg = true;
			}
		} catch (SQLException e) {
			System.out.println("Exception" + e);
		}
		return reg;
	}

	public static void insertTest(String name, int age, int sal) {
		final String querry = "INSERT INTO TEST(NAME,AGE,SAL) VALUES('" + name + "'," + age + "," + sal + ");";
		System.out.println(querry);
		try {
			Connection con = DBConnect.getConnection();
			Statement smt = con.createStatement();
			int rs = smt.executeUpdate(querry);
			if (rs > 0) {
				System.out.println("querry executed successfully");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}