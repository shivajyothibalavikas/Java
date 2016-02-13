<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>
<%
int err =(int) request.getAttribute("javax.servlet.error.status_code");%>
<div class="page-header">
		<h1>Welcome</h1>
	</div>
<h2><strong>Sorry!!!! Error Occured while handling your request.</strong></h2>
<h3>ERROR CODE:<%=err %></h3>
<h3>CAUSE:<%=request.getAttribute("javax.servlet.error.message") %></h3><br>
<a href="/Login/jsp/layout.jsp" > Go back</a>
<div class="navbar-fixed-bottom">
		<p>Copyright &copy; kenscio.com</p>
	</div>
</body>
</html>