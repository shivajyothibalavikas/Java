<%@ page import="java.util.*"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/Login/css/jquery.dataTables.min.css" rel="stylesheet">
<script type="text/javascript" src="/Login/js/jquery.js"></script>
<script type="text/javascript" src="/Login/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="/Login/js/datatable.js"></script>
<title>Student Form</title>
</head>
<body>
	<form>
		<h2 style="text-align: center;">Book List</h2>
		<div class="formDiv" style="border-style: inset; padding: 15px">
			<table class="hover stripe row-border cell-border" id="bookListTable">
				<thead>
					<tr>
						<th>BOOK_ID</th>
						<th>BOOK_NAME</th>
						<th>BOOK_CATEGORY</th>
						<th>BOOK_ISBN</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>
