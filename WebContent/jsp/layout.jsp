<%@ page import="com.kenscio.to.Books"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.css" rel="stylesheet">
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

<script type='text/javascript'>
window.history.forward();
function noBack() {window.history.forward(); }
window.onload='noBack()';
window.onpageshow=function(evt){if(evt.persisted)noBack()}
window.onunload=function(){void(0)}
 </script>

</head>

<body>

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

</body>

</html>