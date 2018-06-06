<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Edit Details</title>
<!-- metatags-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="effective application form a Flat Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Meta tag Keywords -->
<link href="css/registrationPage.css" rel="stylesheet" type="text/css"
	media="all" />
<!--style_sheet-->
<link href="//fonts.googleapis.com/css?family=Quicksand"
	rel="stylesheet">
<!--online_fonts-->
<link href="//fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<!--online_fonts-->
<link href="//fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<!--online_fonts-->
</head>
<body>
	<jsp:include page="menuHome.jsp"></jsp:include>

	<h1>
		<span>Edit Details</span>
	</h1>
	<div class="w3ls-main">
		<div class="w3ls-form">
			<label class="alert-danger"
				style="letter-spacing: 0px !important; text-transform: capitalize; text-align: left;">
				${errorMsg.getErrorMessage()} </label>
			<form action="UpdateStudent" method="post" id="studentDetailsForm">
				<c:forEach items="${studentList}" var="studentDto">
					<ul class="fields">
						<li><label class="w3ls-opt">Roll Number<span
								class="w3ls-star"> * </span></label>
							<div class="w3ls-name">
								<input type="text" readonly="readonly"
									value="${studentDto.getRollNumber()}" name="rollNumber"
									required="required" />
							</div></li>
						<li><label class="w3ls-opt">first name<span
								class="w3ls-star"> * </span></label>
							<div class="w3ls-name">
								<input type="text" value="${studentDto.getFirstName()}"
									name="firstName" required="required" />
							</div></li>
						<li><label class="w3ls-opt">last name<span
								class="w3ls-star"> * </span></label>
							<div class="w3ls-name">
								<input type="text" name="lastName" required="required"
									value="${studentDto.getLastName()}" />
							</div></li>
						<li><label class="w3ls-opt">Guardian's name<span
								class="w3ls-star"> * </span></label>
							<div class="w3ls-name">
								<input type="text" name="guardianName" required="required"
									value="${studentDto.getGuardianName()}" />
							</div></li>
						<li><label class="w3ls-opt">address <span
								class="w3ls-star"> * </span>
						</label>
							<div class="adderss">
								<span class="text"> <input type="text" name="addLine1"
									required="required" value="${studentDto.getAddLine1()}" />
								</span> <span class="text"> <input type="text" name="addLine2"
									required="required" value="${studentDto.getAddLine2()}" />
								</span> <span class="text"> <input type="text" name="city"
									required="required" value="${studentDto.getCity()}" />

								</span> <span class="text"> <input type="text" name="state"
									required="required" value="${studentDto.getState()}" />

								</span> <span class="text"> <input type="text" name="zipcode"
									required="required" value="${studentDto.getZipcode()}" />
								</span> <span class="text"> <input type="text" name="country"
									required="required" value="${studentDto.getCountry()}" />
								</span>
							</div></li>
						<li><label class="w3ls-opt">phone number<span
								class="w3ls-star"> * </span></label> <span class="w3ls-text w3ls-name">
								<input type="text" name="phoneNumber" required="required"
								value="${studentDto.getPhoneNumber()}" />
						</span></li>
						<li><label class="w3ls-opt">guardian's number<span
								class="w3ls-star"> * </span></label> <span class="w3ls-text w3ls-name">
								<input type="text" name="guardianPhoneNumber"
								required="required"
								value="${studentDto.getGuardianPhoneNumber()}" />
						</span></li>
						<li>
							<div class="mail">
								<label class="w3ls-opt">e-mail<span class="w3ls-star">
										* </span></label> <span class="w3ls-text w3ls-name"> <input
									type="email" name="email" style="text-transform: lowercase;"
									required="required" value="${studentDto.getEmail()}" />
								</span>
							</div>
						</li>
						<li>
							<div class="mail">
								<label class="w3ls-opt">Department<span
									class="w3ls-star"> * </span></label> <span class="w3ls-text w3ls-name">
									<select name="department" required="required">
										<option value="">--Select from below--</option>
										<c:forEach items="${departmentList}" var="department">
											<option value="${department.getDepartmentId()}"
												<c:if test="${department.getDepartmentId()==studentDto.getDepartment()}">selected</c:if>>
												${department.getDepartmentName()}</option>
										</c:forEach>

								</select>
								</span>
							</div>
						</li>
						<li>
							<div class="mail">
								<label class="w3ls-opt">Semester<span class="w3ls-star">
										* </span></label> <span class="w3ls-text w3ls-name"> <select
									name="sem" required="required">
										<option value="">--Select from below--</option>
										<option value="1">1st Semester</option>
										<option value="2">2nd Semester</option>
										<option value="3">3rd Semester</option>
										<option value="4">4th Semester</option>
										<option value="5">5th Semester</option>
										<option value="6">6th Semester</option>
										<option value="7">7th Semester</option>
										<option value="8">8th Semester</option>
								</select>
								</span>
							</div>
						</li>
						<div class="input">
							<label class="w3ls-opt1">Extra Curricular Activities<span>
									?</span></label> <span class="w3ls-input"><textarea
									name="extraCurricular">${studentDto.getExtraCurricular()}</textarea></span>
						</div>
					</ul>
					<div style="background-color: red; width: 100%; height: 10px; padding-bottom: 20px"></div>
				</c:forEach>
				<div class="clear"></div>
				<div class="w3ls-btn">
					<input type="submit" value="Update">
				</div>
			</form>
		</div>
	</div>
</body>

</html>