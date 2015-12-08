<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
html, body {
	height: 100%;
	min-height: 100%;
	margin: 0;
	padding: 0;
}

li a {
	display: block;
	width: 180px;
	text-decoration: none;
	padding: 8px 0 8px 16px;
}

li a:hover {
	background-color: #555;
	color: white;
}

ul {
	margin: 0;
	padding: 0;
	list-style-type: none;
	width: 200px;
}

#headder {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
	width: 100%;
	height: 100px;
}

#navbar {
	line-height: 30px;
	background-color: #eeeeee;
	width: 200px;
	height: 100%;
	float: left;
	padding: 5px;
}

#section {
	width: 500px;
	float: left;
	padding: 10px;
}
</style>
</head>
<body>
	<div id="headder">KENSCIO</div>
	<div id="navbar">
		<ul>
			<li><a href="">Home</a></li>
			<li><a href="">News</a></li>
			<li><a href="">Contact</a></li>
			<li><a href="">About</a></li>
		</ul>
	</div>
	<%
		String usr = null;
		session = request.getSession();
		usr = (String) session.getAttribute("name");
		System.out.println(usr);
		if (usr != null) {
	%>

	<div id="section">
		<form action="../logout" method="post">
			<h1>
				Hello welcome
				<%=usr %>
			</h1>
			<input type="submit" value="Logout" />
		</form>
		</div>


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



