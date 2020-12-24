<%@page import="com.stdioh321.mvc.entities.Contact"%>





<html>
	<head>
		<title>TMP</title>
	</head>
	<body>
		<h1>
			TMP
		</h1>
		<h3>
			Param tmp: ${param.tmp}
		</h3>
		<div>
		
			<%
				Contact c = (Contact) request.getAttribute("contact"); 
				out.println(c);
			%>
		</div>
	</body>
</html>