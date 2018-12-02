<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<form>
		<jsp:include page="header.jsp"></jsp:include>
		<br />
		<div align="center">
			<h3 style="color: maroon;">Unique Error Log</h3>
			<textarea rows="1000000" cols="0" style="height: 65vh; width: 90vw;"><c:forEach items="${results}" var="String">${String}</c:forEach></textarea>
		</div>
		<div style="bottom: 0; position: absolute; width: 99%;">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</form>
</body>
</html>