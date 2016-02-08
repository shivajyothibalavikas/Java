<!DOCTYPE html>
<html>
<head>
<title>Register Page</title>

<link href="../css/bootstrap.css" rel="stylesheet">

</head>

<body>

	<div class="page-header">
		<h1>Welcome</h1>
	</div>

	<div class="pagination-centered">
		<div class="container text-center">

			<div class="panel panel-primary">
				<div class="panel-heading">Reigister</div>

				<div class="panel-body">
					<form class="form-horizontal" role="form"
						action="/Login/jsp/register.do" method="post" id="registerform">

						<div class="form-group">
							<label class="control-label col-sm-2" for="email">Email:</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="email"
									placeholder="Enter email" name="email">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="email">Name:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name"
									placeholder="Enter Name" name="Username">
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
							<label class="control-label col-sm-2" for="email">Phone
								no:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="phone"
									placeholder="Enter Phone-number" name="phone">
							</div>
						</div>

						<div class="form-group">
							<label class="radio-inline"><input type="radio"
								name="gender"><strong>Male</strong></label> <label
								class="radio-inline"><input type="radio" name="gender"><strong>Female</strong></label>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<button type="submit" class="btn btn-danger" id="submitbutton">Register</button>
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

function validatetext(id)
{
  if($("#"+id).val() == null || $("#"+id).val() == "")
  {
    var div = $("#"+id).closest("div");
    div.removeClass("has-success");
    $("#glypcn"+id).remove();
    div.addClass("has-error has-feedback");
    div.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-remove form-control-feedback"></span>');
    return false;
  }

  else
  {
    var div = $("#"+id).closest("div");
    div.removeClass("has-error");
    div.addClass("has-success has-feedback");
    $("#glypcn"+id).remove();
    div.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-ok form-control-feedback"></span>');
    return true;
  }
}

$(document).ready(

    function()
    {

      $("#submitbutton").click(

        function()
        {
          if(!validatetext("email"))
          {
            return false;
          }

          if(!validatetext("name"))
          {
            return false;
          }

          if(!validatetext("pwd"))
          {
            return false;
          }

          if(!validatetext("phone"))
          {
            return false;
          }

          $("form#registerform").submit();

        }
      );
    }

  );
</script>

	<div class="navbar-fixed-bottom">
		<p>Copyright &copy; kenscio.com</p>
	</div>

</body>
</html>