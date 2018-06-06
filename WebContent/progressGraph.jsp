<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Progress Graph With Smart Chart</title>
<link href="https://canvasjs.com/assets/css/jquery-ui.1.11.2.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amaranth"
	rel="stylesheet">
<style>
.ui-tabs-anchor {
	outline: none;
}
</style>
<script>
window.onload = function() {
var options1 = {
	animationEnabled: true,
	title:{
		fontFamily:"Amaranth",
        fontSize:"25" ,
		text: "${student.getFirstName()} ${student.getLastName()}"
	},
	axisX: {
		interval: 1,
		labelFontSize: 14,
		minimum: 0,
		maximum: 9,
		title: "Semester",
		
		
	},
	
	axisY: {
		minimum: 5,
		maximum: 10,
		title: "SGPA",
		interval: .2,
		labelFontSize: 14
	},
	data: [{
		type: "spline", //change it to line, area, bar, pie, etc
		dataPoints: [
			<c:forEach items="${marksList}" var="marks">
			{x:${marks.getSem()}, y: ${marks.getSgpa()}},
			</c:forEach>
			
		]
	}]
};

var options2 = {
	animationEnabled: true,
	title:{
		fontFamily:"Amaranth",
        fontSize:"25" ,
		text: "${student.getFirstName()} ${student.getLastName()}"
	},
	axisX: {
		interval: 1,
		labelFontSize: 14,
		minimum: 0,
		maximum: 9,
		title: "Semester",
		
		
	},
	
	axisY: {
		minimum: 5,
		maximum: 10,
		title: "SGPA",
		interval: .2,
		labelFontSize: 14
	},
	data: [{
		type: "column", //change it to line, area, bar, pie, etc
		dataPoints: [
			<c:forEach items="${marksList}" var="marks">
			{x:${marks.getSem()}, y: ${marks.getSgpa()}},
			</c:forEach>
			
		]
	}]
};

$("#tabs").tabs({
	create: function (event, ui) {
		//Render Charts after tabs have been created.
		$("#chartContainer1").CanvasJSChart(options1);
		$("#chartContainer2").CanvasJSChart(options2);
	},
	activate: function (event, ui) {
		//Updates the chart to its container size if it has changed.
		ui.newPanel.children().first().CanvasJSChart().render();
	}
});

}
</script>
<script type="text/javascript">
function back(){
	alert('You are leaving this page');
		window.location="EnterRollGraph";
}
</script>
</head>
<body>
	<div id="tabs" style="height: 600px">
		<ul>
			<li><a href="#tabs-1" style="font-size: 12px;"><i
					class="fas fa-chart-line"></i></a></li>
			<li><a href="#tabs-2" style="font-size: 12px"><i
					class="fas fa-chart-bar"></i></a></li>
			<li><a href="#" onclick="back()" style="font-size: 12px">Back</a></li>
		</ul>
		<div id="tabs-1" style="height: 570px">
			<div id="chartContainer1" style="height: 570px; width: 100%;"></div>
		</div>
		<div id="tabs-2" style="height: 570px">
			<div id="chartContainer2" style="height: 570px; width: 100%;"></div>
		</div>
	</div>
	<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
	<script
		src="https://canvasjs.com/assets/script/jquery-ui.1.11.2.min.js"></script>
	<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
</body>
</html>