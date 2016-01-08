<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="com.kenscio.to.Books"%>
<%@ page import="com.kenscio.database.DatabaseClass"%>
<%@ page import="com.kenscio.util.FetchDataFromDb" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GridView for Java - jQuery Data Table</title>
<link href="css/demo_page.css" rel="stylesheet" type="text/css" />
<link href="css/demo_table.css" rel="stylesheet" type="text/css" />
<link href="css/demo_table_jui.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.dataTables.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.8.24.custom.css" rel="stylesheet"
	type="text/css" media="all" />
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.js" type="text/javascript"></script>
<script>
        $(document).ready(function () {
            $("#companies").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true               
            });
        });
 </script>
<%-- <%= "testing done" %> --%>
</head>
<body id="dt_example">
	<div id="container">
		<h1>Gridview for Java using jQuery DataTable plugin</h1>
		<div id="demo_jui">
			<table id="companies" class="display">
				<thead>
					<tr>
						<th><u>Book ID</u></th>
						<th><u>Book Name</u></th>
						<th><u>Book Category</u></th>
						<th><u>Book ISBN</u></th>
					</tr>
				</thead>
				<tbody>
				<%!Map<Long,Books> books = new HashMap<Long,Books>();%>
				<% books = DatabaseClass.getBook(); %>
					<% for(Books c:books.values()){ %>
					<tr>
						<td><%=c.getBook_id()%></td>
						<td><%=c.getBook_name()%></td>
						<td><%=c.getBook_category()%></td>
						<td><%=c.getISBN()%></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>