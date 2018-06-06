<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-family: 'Raleway', sans-serif !important;">
<head>
<link rel="icon" href="images/logo.jpg">
<title>Edit User</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Validation Signup Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

	 
	 function searchUser(userId) {
		 window.location = "ShowEditUserPage?userId=" + userId;
		
	}


</script>
<!-- fonts -->
<link href="//fonts.googleapis.com/css?family=Muli:300,400"
	rel="stylesheet">
<!-- /fonts -->
<!-- css -->
<link href="css/bootstrap.css" rel="stylesheet" type='text/css'
	media="all" />
<link href="css/searchUser.css" rel="stylesheet" type='text/css'
	media="all" />
<!-- /css -->
</head>

<body>
	<jsp:include page="menuHome.jsp"></jsp:include>
	<form action="ShowEditUserPage">
		<span class="w3ls-text w3ls-name">
			<div style="padding: 20px;">
				<label 
					style="letter-spacing: 0px !important; text-transform: capitalize; color: #fff; text-align: left;">
					${errorMsg.getErrorMessage()} </label><br>
			</div>
			<div class="form-group agileinfo wthree w3-agileits agile">
				<input style="width: 300px" name="userId" type="text"
					class="form-control" id="Phone" placeholder="Enter User Id"
					data-error="Enter Your User Id" required>
				<div class="help-block with-errors"></div>
			</div>
			<button
				style="border-radius: 5px; font-size: 18px; height: 40px; background-color: #9e1d20;; border: 1px solid #ffff; color: white;"
				onClick="searchUser()">Search</button>
		</span>
	</form>

</body>

</html>