<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Service</title>
<link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>
<form id="myForm" action="/Login/jsp/logout.do" method="post"></form>
<!-- <form id="myForm1" action="/Login/jsp/display.do" method="post"></form> -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Kenscio</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a onclick="load_home()">Home</a></li>
					<li><a onclick="load_upload()">Upload File</a></li>
					<li><a onclick="load_jsonParsing()">Json File Parsing</a></li>
					<li><a onclick="load_view()">View Book Catalog</a></li>
					<li><a onclick="myForm.submit();">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>

