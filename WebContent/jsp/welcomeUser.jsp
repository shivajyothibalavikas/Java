<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.ar {
	width: 105px;
	height: 20px;
	line-height: 20px;
	padding-bottom: 2px;
	vertical-align: middle;
	font-family: "Lucida Grande", Geneva, Verdana, Arial, Helvetica,
		sans-serif;
	font-size: 18px;
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
		<br/>

	<form>
		<font size="3" color="red">Click here to view the book catalog:</font><a
			class="ar" href="/Login/jsp/display.jsp">View</a>
	</form>
	<br />
	<br />

	<form action="/Login/html/uploadfile.do" method="post">
		Please provide the input File for uploading:<input type="file"
			name="input"><br> <input type="submit" value="upload">
		<p id="demo"></p>
	</form>
	<br />
	<br />


	<form action="/Login/html/parse.do" method="get">
		Please provide the input Json File:<input type="file" name="input"><br>
		<input type="submit" value="submit">

		<%
			if (request.getAttribute("json") != null) {
		%>
		<div id="textarea">
			<textarea rows="20" cols="70"><%=request.getAttribute("json")%></textarea>
		</div>
	</form>
	<br />


	<%
		}

		} else {
	%>


	<h1>Session expired Please try later</h1>
	<a href="/Login/html/login.html">Click here to login again</a>


	<%
		}
	%>

</body>
</html>