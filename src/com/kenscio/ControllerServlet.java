package com.kenscio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.json.JsonException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.*;
import com.kenscio.database.DatabaseClass;
import com.kenscio.service.Run;
import com.kenscio.service.Service;
import com.kenscio.util.DBConnect;
import com.kenscio.util.MD5;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection con = null;
	Service service = null;
	public void init(ServletConfig conf) throws ServletException {

/*		Run run = new Run();
		Thread t1 = new Thread(run);
		t1.start();
		System.out.println("Thread started successfully");*/

		try {
			con = DBConnect.getConnection();
		} catch (SQLException e) {
			System.out.println("Exception" + e);
		} catch (ClassNotFoundException e) {
			System.out.println("Exception" + e);
		}
	}

	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		String strpath = req.getServletPath();
		System.out.println("strpath=" + strpath);

		/* for parsing the given json file */

		if (strpath.equals("/html/parse.do")) {
			RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/jsonParsing.jsp");
			if (ServletFileUpload.isMultipartContent(req)) {
				try {
					DiskFileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					List<FileItem> formItems = upload.parseRequest(req);
					service = new Service();
					StringBuffer json = service.parseJson(formItems);
					req.setAttribute("json", json);
					rd1.forward(req, resp);
				} catch (JsonException e) {
					try {
						resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error Occured while parsing");
					} catch (IOException e1) {
						System.out.println(e1);
					}
				} catch (FileUploadException e) {
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}

		}

		/* for uploading the file to the remote server */

		else if (strpath.equals("/jsp/uploadfile.do"))

		{
			if (ServletFileUpload.isMultipartContent(req)) {
				RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/success.jsp");
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> formItems;
				try {
					formItems = upload.parseRequest(req);
					service = new Service();
					service.uploadFile(formItems);
					rd1.include(req, resp);
				} catch (FileUploadException e) {
					System.out.println("Exception during uploading the file:" + e);
				} catch (IOException e) {
					System.out.println("Exception during uploading the file:" + e);
				} catch (ServletException e) {
					System.out.println("Exception during uploading the file:" + e);
				}

			}
		}
		
		
		/* grid view displaying*/
		
		else if (strpath.equals("/html/display.do")) {
			System.out.println("inside display");
			
			 JSONObject jsonResult = new JSONObject();

			  int totalRecords= -1;
			  try {
			   totalRecords = DatabaseClass.getTotalRecordCount();
			  } catch (SQLException e1) {
			   e1.printStackTrace();
			  }
			 
			  
			 
			  try {
				jsonResult = DatabaseClass.getBookList(totalRecords, req);
				System.out.println("JSON RESULT:"+jsonResult);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			 
			  resp.setContentType("application/json");
			  resp.setHeader("Cache-Control", "no-store");
			  
			  
			  try {
				resp.getWriter().print(jsonResult);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		/* For login checking */

		else if (strpath.equals("/html/login.do"))

		{

			resp.setContentType("text/html");
			RequestDispatcher rd1 = req.getRequestDispatcher("/jsp/layout.jsp");
			RequestDispatcher rd2 = req.getRequestDispatcher("/jsp/errWrongPass.jsp");
			String name = req.getParameter("Username");
			String user_entered_pass = req.getParameter("password");
			String md5_of_pass = MD5.getMD5(user_entered_pass);
			boolean user = DatabaseClass.loginCheck(name, md5_of_pass);
			if (user == true) {
				HttpSession session = req.getSession();
				session.setAttribute("name", name);
				try {
					rd1.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					rd2.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/* for registering the user */

		else if (strpath.equals("/html/register.do"))

		{

			RequestDispatcher rd4 = req.getRequestDispatcher("/jsp/succReg.jsp");
			String name = req.getParameter("name");
			String pass = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String gender = req.getParameter("gender");
			String md5_of_pass = MD5.getMD5(pass);
			boolean registeration = DatabaseClass.registerUser(name, md5_of_pass, email, phone, gender);
			if (registeration) {
				try {
					rd4.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/* for logging out the user */

		else if (strpath.equals("/jsp/logout.do"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("/html/login.html");
			HttpSession s = req.getSession();
			s.invalidate();
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		else if (strpath.equals("/handler")) {
			Integer status_code = (Integer) req.getAttribute("javax.servlet.error.status_code");
			String error_message = (String)req.getAttribute("javax.servlet.error.message");
			req.setAttribute("status_code", status_code);
			req.setAttribute("error_message", error_message);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/Errors.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
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