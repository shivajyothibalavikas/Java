<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Service</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<script src="../js/jquery.js"></script>
</head>
<body>
<form id="myForm" action="/Login/jsp/logout.do" method="post"></form>
		<div class="container-fluid">
			<div class="navbar navbar-default">
				<ul class="nav navbar-nav">
					<li class="active" id="home"><a onclick="load_home()">Home</a></li>
					<li><a onclick="load_upload()" id="Upload File">Upload File</a></li>
					<li><a onclick="load_jsonParsing()" id="Json File Parsing">Json File Parsing</a></li>
					<li><a onclick="load_view()" id="View Book Catalog">View Book Catalog</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li><a onclick="myForm.submit();" id="Logout"><span class="glyphicon glyphicon-log-out"></span>  Logout</a></li>
				</ul>
			</div>
		</div>
</body>
</html>

