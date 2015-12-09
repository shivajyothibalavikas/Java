package com.kenscio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {
	Connection con = null;

	public void init() throws ServletException {

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
		java.sql.Statement smt = null;
		PrintWriter pw = resp.getWriter();
		System.out.println(strpath);
		
		
		if (strpath.equals("/login.do")) {					//login servlet
			
			
			resp.setContentType("text/html");
			RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/Welcome.jsp");
			String name = req.getParameter("name");
			String pass = req.getParameter("password");
			String select_querry = "SELECT NAME,PASSWORD FROM CUSTOMER WHERE NAME='" + name + "';";
			try {

				ResultSet rs = null;
				smt = con.createStatement();
				rs = smt.executeQuery(select_querry);
				if (!(rs.next())) {
					pw.println("<html>");
					pw.println("<body>");
					pw.println("<h1>Invalid user!!! Plese try again</h1><br>");
					pw.println("<a href='html/login.html'>click here to login again</a>");
					pw.println("</body>");
					pw.println("</html>");

				} else {
					String dbpass = rs.getString(2);
					if (pass.equalsIgnoreCase(dbpass)) {
						HttpSession session = req.getSession();
						session.setAttribute("name", name);
						rd1.forward(req, resp);
					} else {
						pw.println("<html>");
						pw.println("<body>");
						pw.println("<h1> U have entered a wrong password.<br> please try again</h1><br>");
						pw.println("<a href='html/login.html'>click here to login again </a>");
						pw.println("</body>");
						pw.println("</html>");
					}
				}
			} catch (SQLException e) {
				System.out.println("Exception" + e);
			} finally {
				try {
					pw.close();
					smt.close();
				} catch (SQLException e) {
					System.out.println("Error whControllerServletile closing statement object\n + e");
				}
			}
			
			
		} else if (strpath.equals("/register.do")) {						//register Servlet
			
			
			String name = req.getParameter("name");
			String pass = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String gender = req.getParameter("gender");
			String querry = "INSERT INTO CUSTOMER(NAME,PASSWORD,EMAIL,PHONENO,GENDER)VALUES(" + "'" + name + "','"
					+ pass + "','" + email + "'," + phone + ",'" + gender + "');";
			try {
				smt = con.createStatement();
				int result = smt.executeUpdate(querry);
				if (result > 0) {
					pw.println("<html>");
					pw.println("<body>");
					pw.println("<h1>User '" + name + "' successfully added to the database...</h1><br/>");
					pw.println("<a href='html/login.html'>click here to login</a>");
					pw.println("</body>");
					pw.println("</html>");
				}
			} catch (SQLException e) {
				System.out.println("Exception" + e);
			}
			
			
			

		} else if (strpath.equals("/logout.do")) {							//logout servlet
			
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
