package com.kenscio;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kenscio.database.DatabaseClass;
import com.kenscio.util.DBConnect;
import com.kenscio.util.FileUpload;
import com.kenscio.util.JSONParse;
import com.kenscio.util.MD5;

@MultipartConfig
public class ControllerServlet extends HttpServlet {

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

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String strpath = req.getServletPath();
		PrintWriter pw = resp.getWriter();
		
		
		/*for parsing the given json file*/
		
		if (strpath.equals("/html/parse.do")) 					
		{
			RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/jsonParsing.jsp");
			FileReader reader = new FileReader(req.getParameter("input"));
			StringBuffer json = JSONParse.parse(reader);
			req.setAttribute("json", json);
			rd1.forward(req, resp);
		}
		
		
		/*for uploading the file to the remote server*/ 
		
		else if (strpath.equals("/html/uploadfile.do"))
		{
			final Part filePart = req.getPart("file");
		    final String fileName = getFileName(filePart);
		    InputStream filecontent = filePart.getInputStream();
		    FileUpload.upload(filecontent,fileName);
		    
			
			
			
			/*resp.setContentType("text/html");
			//Boolean flag;
			//Boolean result;
			File f = new File (req.getParameter("input"));
			//System.out.println(f.getAbsolutePath());
			//System.out.println("file created");
			//FileInputStream fis = new FileInputStream(f.getAbsoluteFile());
			//System.out.println("file input streams created");
			//String path = f.getAbsolutePath();
			FileUpload.upload(f);
			if(flag == true)
			{
				result = true;
				req.setAttribute("result", result);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/html/uploadSuccess.html");
				dispatcher.forward(req, resp);
			}
			else
			{
				result = false;
				req.setAttribute("result", result);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/layout.jsp");
				dispatcher.forward(req, resp);
			}*/
		}
		
		
		
		/*For login checking*/
		
		else if (strpath.equals("/html/login.do")) 
		{ 																									
			resp.setContentType("text/html");
			RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/layout.jsp");
			RequestDispatcher rd2 = req.getRequestDispatcher("/html/error2.html");
			String name = req.getParameter("Username");
			String user_entered_pass = req.getParameter("password");
			String md5_of_pass = MD5.getMD5(user_entered_pass);
			boolean user = DatabaseClass.loginCheck(name,md5_of_pass);
			if(user == true)
			{
				HttpSession session = req.getSession(); 
				session.setAttribute("name", name);
				rd1.forward(req, resp);
			}
			else
			{
				rd2.forward(req, resp);
			}
		}
			 	
		/*for registering the user*/
	
		else if (strpath.equals("/html/register.do")) 
		{ 
			
			RequestDispatcher rd4 = req.getRequestDispatcher("/html/success.html");
			String name = req.getParameter("name");
			String pass = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String gender = req.getParameter("gender");
			String md5_of_pass = MD5.getMD5(pass);
			boolean registeration = DatabaseClass.registerUser(name,md5_of_pass,email,phone,gender);
			if(registeration)
			{
				rd4.forward(req, resp);
			}
		}
		
		/*for logging out the user*/
		
		
		else if (strpath.equals("/html/logout.do")) 
		{ 

			RequestDispatcher rd = req.getRequestDispatcher("/html/login.html");
			HttpSession s = req.getSession();
			s.invalidate();
			rd.forward(req, resp);
		}
		
	}
	
	private String getFileName(final Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
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