<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSON Formatter</title>
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
	function formatJSON(){
		var input="",output="";
		input = document.getElementById("inputString").value;
		output = JSON.stringify(JSON.parse(input), null, 4);
		document.getElementById("outputString").innerHTML = ""+output; 
	}
	function clearText() {
	    document.getElementById("outputString").value = "";
	}
</script>
</head>
<body>
    <div>
		<jsp:include page="header.jsp"></jsp:include>
		<br />
		<div align="center">
			<h3 style="color: maroon;">Place JSON Data</h3>
			<textarea rows="1000000" cols="0" style="height: 60vh; width: 90vw;" id="inputString" name="inputString"></textarea><br />
            <input type="button" name="formatJSON" id="formatJSON" value="Format JSON" onclick="formatJSON()"/>
            <input type="button" name="reset" id="reset" value="Reset" onClick="window.location.reload()"/>
		</div><br /><br />
        <div align="center">
             <h3 style="color: maroon;">JSON Formatted Data</h3>
             <textarea rows="1000000" cols="0" style="height: 65vh; width: 90vw;" id="outputString" name="outputString"></textarea>
         </div><br /><br />
	</div>
   <div style="bottom: 0; position: fixed; width: 99%;">
       <jsp:include page="footer.jsp"></jsp:include>
  </div>
</body>
</html>