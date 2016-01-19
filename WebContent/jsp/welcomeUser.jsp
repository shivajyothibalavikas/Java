<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.button {
	width: 105px;
	height: 20px;
	line-height: 20px;
	padding-bottom: 2px;
	vertical-align: middle;
	font-family: "Lucida Grande", Geneva, Verdana, Arial, Helvetica,
		sans-serif;
	font-size: 13px;
	text-transform: none;
	border: 1px solid transparent;
	color: green;
}
</style>

</head>
<body>
	<%
		String usr = null;
		session = request.getSession();
		usr = (String) session.getAttribute("name");
		if (usr != null) {
	%>


	<h1>
		Hello welcome
		<%=usr%></h1>
		<br/>

	
	<br />


	<%

		} else {
	%>


	<h1>Session expired Please try later</h1>
	<a href="/Login/html/login.html">Click here to login again</a>


	<%
		}
	%>

</body>
</html>