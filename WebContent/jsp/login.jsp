<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>

<link href="../css/bootstrap.css" rel="stylesheet">

</head>

<body>

	<div class="page-header"> 
		<h1>Welcome</h1>
	</div>



	<div class="pagination-centered">
		<div class="container text-center">


			<div class="panel panel-primary">
				<div class="panel-heading">Login</div>

				<div class="panel-body" style="padding-bottom: 20px;">
					<form class="form-horizontal" id="loginform" role="form"
						action="/Login/html/login.do" method="post">
						<div class="form-group">
							<label class="control-label col-sm-2" for="email">Email:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email"
									placeholder="Enter email" name="Username">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="pwd">Password:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="pwd"
									placeholder="Enter password" name="password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<div class="span-4">
									<button type="submit" id="submitbutton" class="btn btn-success">Login</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script>
		function validatetext(id) {
			if ($("#" + id).val() == null || $("#" + id).val() == "") {
				var div = $("#" + id).closest("div");
				div.removeClass("has-success");
				$("#glypcn" + id).remove();
				div.addClass("has-error has-feedback");
				div
						.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-remove form-control-feedback"></span>');
				return false;
			}

			else {
				var div = $("#" + id).closest("div");
				div.removeClass("has-error");
				div.addClass("has-success has-feedback");
				$("#glypcn" + id).remove();
				div
						.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-ok form-control-feedback"></span>');
				return true;
			}
		}

		$(document).ready(

		function() {

			$("#submitbutton").click(

			function() {
				if (!validatetext("email")) {
					return false;
				}

				if (!validatetext("pwd")) {
					return false;
				}

				$("form#loginform").submit();

			});
		}

		);
	</script>

	<div class="navbar-fixed-bottom">
		<p>Copyright &copy; kenscio.com</p>
	</div>

</body>
</html>