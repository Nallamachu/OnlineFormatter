<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Formatter</title>
<style type="text/css">
html {
	background-color: white;
	background-image: url("images/Blue-background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 100% 100%;
	background-size: 100%;
}
h1 {
	margin-top: -5px;
	margin-bottom: -5px;
}
</style>
<script type="text/javascript">
	function validateForm(){
		var input = document.getElementById("input").value;
		if(input=="" || input==null){
			alert("Please enter SQL content to format");
			return false;
		}
	}
</script>
</head>
<body style="color: maroon;">
	<jsp:include page="header.jsp"></jsp:include>
	<form onsubmit="return validateForm();" action="sqlFormatter" method="post">
		<div align="center">
			<h3 style="color: maroon;">Place SQL Content Here</h3>
			<textarea rows="1000000" cols="0" name="input" id="input" style="height: 60vh; width: 90vw;"></textarea><br />
			<input type="submit" name="formatSQL" id="formatSQL" value="Format SQL"/>
			<input type="reset" name="reset" id="reset" value="Reset" />
		</div>
	</form>
	<div style="bottom: 0; position: absolute; width: 99%;">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>