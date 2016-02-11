<%@ page import="com.kenscio.to.Books"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.css" rel="stylesheet">
<title>Kenscio</title>
</head>
<body>
	<%		//session = request.getSession();
			if(session.getAttribute("name")!=null)
			{
	%>

	<!-- Begin Header -->
	<div class="page-header">
		<h1>Welcome</h1>
	</div>
	<!-- End Header -->

	<!-- Begin Naviagtion -->
	<div class="navigation">
		<%@ include file="/jsp/navbar.jsp"%>
	</div>
	<!-- End Naviagtion -->

	<!-- Begin Wrapper -->
	<div class="container" id="content">
		<%@ include file="/jsp/welcomeUser.jsp"%>
		<!-- End Content -->
	</div>

	<!-- Begin Footer -->
	<div class="navbar-fixed-bottom">
		<p>Copyright &copy; kenscio.com</p>
	</div>
	<!-- End Footer -->
	<!-- End Wrapper -->
	<%

		} else {
	%>


	<h1>Session expired Please try later</h1>
	<a href="/Login/html/login.html">Click here to login again</a>


	<%
		}
	%>
</body>
<script>
	function load_view() {
		document.getElementById("content").innerHTML = '<object type="text/html"width="100%" height="100%" data="/Login/jsp/display.jsp" ></object>';
	}
	function load_home() {
		document.getElementById("content").innerHTML = '<object type="text/html"width="100%" height="100%" data="/Login/jsp/welcomeUser.jsp"></object>';
	}

	function load_welcome() {
		document.getElementById("content").innerHTML = '<object type="text/html" width="100%" height="100%" data="/Login/html/logout.html" ></object>';
	}

	function load_upload() {
		document.getElementById("content").innerHTML = '<object type="text/html" width="100%" height="100%" data="/Login/jsp/upload.jsp" ></object>';
	}

	function load_jsonParsing() {
		document.getElementById("content").innerHTML = '<object type="text/html" width="100%" height="100%" data="/Login/jsp/jsonParsing.jsp" ></object>'
	}
</script>
</html>