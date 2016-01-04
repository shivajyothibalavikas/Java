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
		if (usr != null)
		{
			
	%>


	<h1>
		Hello welcome
		<%=usr%></h1>
	<form action="/Login/html/parse.do" method="get">
		Please provide the input Json File:<input type="file" name="input"><br>
		<input type="submit" value="submit">
	
	<%if(request.getAttribute("json")!=null)
	{ 
	%>
	<div id="textarea">
		<textarea rows="20" cols="70"><%=request.getAttribute("json") %></textarea>
	</div>

	<%
	}
		
	} 
		else
		{
	%>


	<h1>Session expired Please try later</h1>
	<a href="/Login/html/login.html">Click here to login again</a>


	<%
		}
		
	%>
	</form>

</body>
</html>