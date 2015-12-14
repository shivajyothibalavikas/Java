<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}
<<<<<<< HEAD
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #F5A9A9;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #4CAF50;
}

.active {
    background-color: #4CAF50;
}
=======

>>>>>>> 1951563133dfe445a5d3cdfabc0aeaf0c9f559e7

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
	color: #333;
	padding: 10px;
	border: 1px solid #ccc;
	height: 100px;
	margin: 0px 0px 0px 0px;
	background: #DAC8BF;
}

#navigation {
	width: 100%;
	color: #333;
	padding: 10px;
	border: 1px solid #ccc;
	margin: 0px 0px 0px 0px;
	background: black;
}

#content {
	width: 100%;
	color: #333;
	border: 1px solid #ccc;
	background: #F2F2E6;
	margin: 0px 0px 0px 0px;
	padding: 10px;
	height: 350px;
}

#footer {
	width: 100%;
	color: #333;
	border: 1px solid #ccc;
	background: #BD9C8C;
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
		 <%@ include file="/jsp/welcomeUser.jsp"%>
		 </div>
		 <script>
		 function load_home()
		 {
		 document.getElementById("content").innerHTML='<object type="text/html" data="html/about.html" ></object>';
         }
		 </script>
		 
		 
		 <script>
		 function load_welcome()
		 {
		 document.getElementById("content").innerHTML='<object type="text/html" data="html/logout.html" ></object>';
         }
		 </script>
		 
		 <script>
		 function load_news()
		 {
		 document.getElementById("content").innerHTML='<object type="text/html" data="html/news.html" ></object>';
         }
		 </script>
		 
		 <script>
		 function load_contact()
		 {
		 document.getElementById("content").innerHTML='<object type="text/html" data="html/contact.html" ></object>';
         }
		 </script>
		 
		 <script>
		 function load_about()
		 {
		 document.getElementById("content").innerHTML='<object type="text/html" data="html/about2.html" ></object>';
         }
		 </script>
		 
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