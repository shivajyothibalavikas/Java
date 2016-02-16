<%@ page
	import="java.util.*"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var basePath = '${pageContext.request.contextPath}';
</script>
 
<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/demo_table_jui.css" >
<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.11.custom.css" >

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.2.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ajax-form-plugin/jquery.form.js" ></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.11.custom.min.js" ></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/datatable.js"></script>	

<title>Student Form</title>
</head>
<body>
<form>
	<div class="titleDiv">Book List</div>
	<div class="clearfix"></div>
	
	<div class="formDiv">
		<table width="100%" border="0" margin="0" padding="0" 
			class="dataTables_wrapper" id="bookListTable">
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
