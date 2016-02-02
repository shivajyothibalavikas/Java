<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<form action="/Login/html/parse.do" method="post" enctype="multipart/form-data">
		<%
			if (request.getAttribute("json") == null) {
		%>
		Please provide the input Json File:<input type="file" name="input" ><br>
		<input type="submit" value="submit">
		<%
			} else {
		%>
		<p style="color: blue; font-size: large;">Content from the uploaded Json File:</p>

		<div id="textarea">
			<textarea rows="20" cols="70"><%=request.getAttribute("json")%></textarea>
		</div>
		<%
			}
		%>
	</form>
</body>
</html>