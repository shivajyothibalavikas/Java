<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Service</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
</head>
<body>
<form id="myForm" action="/Login/jsp/logout.do" method="post"></form>
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
				<a class="navbar-brand" href="http://www.kenscio.com/">Kenscio</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
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
	</nav>
</body>
</html>

