<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function load_home() {
		document.getElementById("content").innerHTML = '<object type="text/html"width="100%" height="100%" data="/Login/jsp/welcomeUser.jsp"></object>';
	}

	function load_welcome() {
		document.getElementById("content").innerHTML = '<object type="text/html" width="100%" height="100%" data="/Login/html/logout.html" ></object>';
	}

	function load_news() {
		document.getElementById("content").innerHTML = '<object type="text/html" width="100%" height="100%" data="/Login/html/news.html" ></object>';
	}

	function load_contact() {
		document.getElementById("content").innerHTML = '<object type="text/html" width="100%" height="100%" data="/Login/html/contact.html" ></object>';
	}

	function load_about() {
		document.getElementById("content").innerHTML = '<object type="text/html"width="100%" height="100%" data="/Login/html/about2.html" ></object>';

		function load_view() {
			document.getElementById("view").innerHTML = '<object type="text/html"width="100%" height="100%" data="/Login/jsp/display.jsp" ></object>';
		}
	}
</script>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	width: 100%;
	height: 100%;
}

#wrapper {
	margin: 0;
	width: 100%;
}

#header {
	width: 100%;
	color: white;
	padding: 10px;
	border: 0;
	height: 100px;
	margin: 0px 0px 0px 0px;
	background: black;
} /* #DAC8BF */
#navigation {
	width: 100%;
	color: #333;
	padding: 10px;
	border: 0;
	margin: 0px 0px 0px 0px;
	background: black;
}

#content {
	width: 100%;
	color: #333;
	border: 0;
	background: #F2F2E6;
	margin: 0px 0px 0px 0px;
	padding: 10px;
	height: 560px;
}

#footer {
	width: 100%;
	color: black;
	border: 0;
	background: #D8D8D8;
	margin: 0px 0px 0px 0px;
	padding: 10px;
}
</style>
</head>
<body>


	<!-- Begin Wrapper -->
	<div id="wrapper">

		<!-- Begin Header -->
		<div id="header">
			<%@ include file="/html/headder.html"%>


		</div>
		<!-- End Header -->




		<!-- Begin Naviagtion -->

		<div id="navigation">
			<%@ include file="/jsp/navbar.jsp"%>

		</div>
		<!-- End Naviagtion -->




		<!-- Begin Content -->
		<div id="content">
			<%@ include file="/jsp/welcomeUser.jsp" %>
		</div>
		<!-- End Content -->


		<!-- Begin Footer -->
		<div id="footer">
			<%@ include file="/html/footer.html"%>
		</div>
		<!-- End Footer -->



	</div>
	<!-- End Wrapper -->

</body>

</html>