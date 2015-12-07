<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String usr = null;
		session = request.getSession();
		usr = (String) session.getAttribute("name");
		System.out.println(usr);
		if (usr != null) 
		{
	%>
	<form action="../logoutservlet" method="post">
		<h1>Hello welcome</h1>
		<input type="submit" value="Logout" />
	</form>
	<%
		} else {
	%>

	<h1>Session expired Please try later</h1>
	<a href="../html/login.html">Click here to login again</a>


	<%
		}
	%>

</body>
</html>
