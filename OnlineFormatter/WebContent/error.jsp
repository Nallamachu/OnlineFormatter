<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Logger</title>
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
</head>
<body style="color: maroon;">
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
			<h3 style="color: maroon;">Sorry for the inconvenience.....We are not able to process your input data...</h3>
			<textarea rows="100" cols="0" style="height: 65vh; width: 90vw;" disabled="disabled">${results}</textarea>
		</div>
	<div style="bottom: 0; position: absolute; width: 99%;">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>