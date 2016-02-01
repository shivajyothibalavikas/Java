<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
 <link href="../css/bootstrap.min.css" rel="stylesheet">
 <!--  <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }
    </style> -->
	  <!--   <style type="text/css">
	   #icon
	    {
	    	padding-bottom: 20px;
	    }
	    </style> -->
</head>
<body>
	  <!-- Navigation -->
    <nav class="navbar navbar-inverse" role="navigation"  style="background-color: #1C1C1C; -moz-box-shadow: -1px 0px 6px 3px #07b307;
	-webkit-box-shadow: -1px 0px 6px 3px #07b307;">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" id="icon">
               <a class="navbar-brand" href="#" style="padding: 1px"><img src="../images/Kenscio.jpg" alt="Kenscio" height="50" width="50"/></a>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
              
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" onclick="load_home()">Home</a>
                    </li>
                    <li>
                        <a href="#" onclick="load_upload()">Upload File</a>
                    </li>
                    <li>
                        <a href="#" onclick="load_jsonParsing()">Json File Parsing</a>
                    </li>
                    <li>
                        <a href="#" onclick="load_view()">View Book Catalog</a>
                    </li>
                    <li>
                        <a href="/Login/html/logout.do">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
</body>
</html>

 