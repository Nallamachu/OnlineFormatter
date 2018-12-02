<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Formatter</title>
</head>
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
a:link, a:visited {
    color: maroon;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}

a:hover, a:active {
    background-color: #FFEFD5;
}
</style>
<body style="color: maroon;">
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
        <a href="logger.jsp"><b style="font-size:35px;">Excel Logger</b><br />To find unique ERROR Log</a><br /><br />
        <a href="formatJSON.jsp"><b style="font-size:35px;">JSON Formatter</b><br />To Format JSON Data</a>
		<a href="xmlFormat.jsp"><b style="font-size:35px;">XML Formatter</b><br />To Format XML content</a>
		<a href="sqlFormater.jsp"><b style="font-size:35px;">SQL Formatter</b><br />To Format SQL content</a>
	</div>
	<div style="bottom: 0; position: absolute; width: 99%;">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>