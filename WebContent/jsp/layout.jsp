<%@ page import="com.kenscio.to.Books"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Kenscio</title>
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
<link rel="stylesheet"  href="../css/layout.css">
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
			<%@ include file="/jsp/welcomeUser.jsp"%>
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