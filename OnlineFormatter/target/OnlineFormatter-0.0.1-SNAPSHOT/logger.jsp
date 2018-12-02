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
	function fileValidator() {
		var text = "";
		var input = document.getElementById("fileinput");
		if (input == null || input.value == "" || input.files.length < 0) {
			alert("Please Select Valid File(s).");
			return false;
		}
		for (var i = 0; i < input.files.length; i++) {
			if ((input.files[i].name.indexOf('.log')) == -1
					&& (input.files[i].name.indexOf('.txt')) == -1
					&& (input.files[i].name.indexOf('.out')) == -1) {
				alert("Please select .log/.txt extension file.");
				return false;
			} else {
				var file = input.files[i];
				if ('name' in file) {
					text += file.name + " size ";
				}
				if ('size' in file) {
					text += getSize(file.size) + " </b><br>";
				}
			}
		}
		document.getElementById("filesList").innerHTML = text;
	}
	function getSize(x) {
		var units = [ 'bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB' ], n = parseInt(
				x, 10) || 0, l = 0;
		while (n >= 1024) {
			n = n / 1024;
			l++;
		}
		return (n.toFixed(n >= 10 || l < 1 ? 0 : 1) + ' ' + units[l]);
	}
</script>
</head>
<body style="color: maroon;">
	<jsp:include page="header.jsp"></jsp:include>
	<form onsubmit="return fileValidator();" action="excelLogger"
		method="post" enctype="multipart/form-data" id="primary">
		<div align="center">
			<b><label>Select File(s):</label></b> 
			<input type="file" id="fileinput"
				name="fileinput" multiple="multiple"
				onchange="return fileValidator();" /><br /> <br />
			<input type="submit" id="fileUpload" name="fileUpload" value="Generate Excel" /><br />
			<br /> <label id="filesList"></label>
		</div>
	</form>
	<div style="bottom: 0; position: absolute; width: 99%;">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>