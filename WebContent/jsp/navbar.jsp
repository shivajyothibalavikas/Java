<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $("#content").load("/Login/jsp/jsonParsing.jsp");
    });
});
</script> -->
<style type="text/css">
ul {
    list-styljsone-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #D8D8D8;
}

li {
    float: left;
}

li a{
    display: block;
    color: black;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #848484;
}

.active {
    background-color: #4CAF50;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li id="home"><a class="active" href="#home" onclick="load_home()">Home</a></li>
		<li id="news"><a href="#news" onclick="load_news()">Upload File</a></li>
		<li id="contact"><a href="#contact" onclick="load_jsonParsing()">Json File Parsing</a></li>
		<li id="view"><a href="#view" onclick="load_view()">View Book Catalog</a></li>
	</ul>
</body>
</html>
<!-- <li id="contact"><button>Json File Parsing</button></li> -->
 