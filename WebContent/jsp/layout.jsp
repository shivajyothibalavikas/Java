<%@ page import="com.kenscio.to.Books"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/Login/css/bootstrap.css" rel="stylesheet">
<script src="/Login/js/jquery.js" type="text/javascript"></script>
<title>Kenscio</title>

<script>
	function load_view() {
		$(".nav a").on("click", function() {
			$(".nav").find(".active").removeClass("active");
			$(this).parent().addClass("active");
		});
		$("#content").load("/Login/jsp/display.jsp");
	}
	function load_home() {
		$(".nav a").on("click", function() {
			$(".nav").find(".active").removeClass("active");
			$(this).parent().addClass("active");
		});
		$("#content").load("/Login/jsp/welcomeUser.jsp");
	}

	function load_welcome() {
		$(".nav a").on("click", function() {
			$(".nav").find(".active").removeClass("active");
			$(this).parent().addClass("active");
		});
		$("#content").load("/Login/html/logout.html");
	}

	function load_upload() {
		$(".nav a").on("click", function() {
			$(".nav").find(".active").removeClass("active");
			$(this).parent().addClass("active");
		});
		$("#content").load("/Login/jsp/upload.jsp");
	}

	function load_jsonParsing() {
		$(".nav a").on("click", function() {
			$(".nav").find(".active").removeClass("active");
			$(this).parent().addClass("active");
		});
		$("#content").load("/Login/jsp/jsonParsing.jsp");
	}
</script>

<script type='text/javascript'>
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
	window.onload = 'noBack()';
	window.onpageshow = function(evt) {
		if (evt.persisted)
			noBack()
	}
	window.onunload = function() {
		void (0)
	}
</script>

</head>

<body>
	<%
		//session = request.getSession();
		if (session.getAttribute("name") != null) {
	%>

	<!-- Begin Header -->
	<div class="page-header">
		<h1>Welcome</h1>
	</div>
	<!-- End Header<!-- <script>

	<!-- Begin Naviagtion -->
	<div class="navigation">
		<%@ include file="/jsp/navbar.jsp"%>
	</div>
	<!-- End Naviagtion -->

	<!-- Begin Wrapper -->
	<div class="container-fluid" id="content">
		<%@ include file="/jsp/welcomeUser.jsp"%>
		<!-- End Content -->
	</div>

	<!-- Begin Footer -->
	<div class="panel-footer">
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

</html>