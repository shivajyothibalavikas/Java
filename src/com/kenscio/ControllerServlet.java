package com.kenscio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.kenscio.util.DBConnect;
import com.kenscio.util.FileUpload;
import com.kenscio.util.JSONParse;
import com.kenscio.util.MD5;

public class ControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con = null;

	public void init(ServletConfig conf) throws ServletException {
		try {
			con = DBConnect.getConnection();

		} catch (SQLException e) {
			System.out.println("Exception" + e);
		} catch (ClassNotFoundException e) {
			System.out.println("Exception" + e);
		}
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strpath = req.getServletPath();
		System.out.println(strpath);
		java.sql.Statement smt = null;
		PrintWriter pw = resp.getWriter();
		
		if (strpath.equals("/html/parse.do")) 					
		{
			RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/layout.jsp");
			FileReader reader = new FileReader(req.getParameter("input"));
			StringBuffer json = JSONParse.parse(reader);
			req.setAttribute("json", json);
			rd1.forward(req, resp);
		}
		
		else if (strpath.equals("/html/uploadfile.do"))
		{
			resp.setContentType("text/html");
			Boolean flag;
			Boolean result;
			File f = new File (req.getParameter("input"));
			flag = FileUpload.upload(f);
			if(flag == true)
			{
				result = true;
				req.setAttribute("result", result);
				pw.println("Upload successfull");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/layout.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				result = false;
				req.setAttribute("result", result);
				pw.println("Upload Failed");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/layout.jsp");
				dispatcher.forward(req, resp);
			}
		}
		
		else if (strpath.equals("/html/login.do")) 
		{ 																									// login servlet
			resp.setContentType("text/html");
			RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/layout.jsp");
			RequestDispatcher rd2 = req.getRequestDispatcher("/html/error.html");
			RequestDispatcher rd3 = req.getRequestDispatcher("/html/error2.html");

			String name = req.getParameter("name");
			String pass = req.getParameter("password");
			String md5pass = MD5.getMD5(pass);
			String select_querry = "SELECT NAME,PASSWORD FROM CUSTOMER WHERE NAME='" + name + "';";

			try {
				ResultSet rs = null;
				smt = con.createStatement();
				rs = smt.executeQuery(select_querry);
				if (!(rs.next())) {

					rd2.forward(req, resp);

				} else {
					String dbpass = rs.getString(2);
					if (md5pass.equals(dbpass)) {

						HttpSession session = req.getSession(); // creating the
																// new session
						session.setAttribute("name", name);
						rd1.forward(req, resp);
					} else {
						rd3.forward(req, resp);

					}
				}
			} catch (SQLException e) {
				System.out.println("Exception" + e);
			} finally {
				try {
					pw.close();
					smt.close();
				} catch (SQLException e) {
					System.out.println("Error whControllerServletile closing statement object" + e);
				}
			}

		} 
		else if (strpath.equals("/html/register.do")) 
		{ // register Servlet

			RequestDispatcher rd4 = req.getRequestDispatcher("/html/success.html");
			String name = req.getParameter("name");
			String pass = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String gender = req.getParameter("gender");
			String md5pass = MD5.getMD5(pass);
			String querry = "INSERT INTO CUSTOMER(NAME,PASSWORD,EMAIL,PHONENO,GENDER)VALUES(" + "'" + name + "','"
					+ md5pass + "','" + email + "'," + phone + ",'" + gender + "');";
			try {
				smt = con.createStatement();
				int result = smt.executeUpdate(querry);
				if (result > 0) {
					rd4.forward(req, resp);
				}
			} catch (SQLException e) {
				System.out.println("Exception" + e);
			}

		} else if (strpath.equals("/html/logout.do")) { // logout servlet

			RequestDispatcher rd = req.getRequestDispatcher("/html/login.html");
			HttpSession s = req.getSession();
			s.invalidate();
			rd.forward(req, resp);
		}

	}

	public void destroy() {
		System.out.println("destroyed");
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error while closing the resource" + e);
		}
	}
}
