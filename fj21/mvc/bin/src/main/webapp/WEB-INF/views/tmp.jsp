<%@page import="com.stdioh321.mvc.entities.Contact"%>
<html>
	<head>
		<title>TMP</title>
	</head>
	<body>
		<h1>TMP inside VIEWS</h1>
		<%
			Contact c = (Contact) request.getAttribute("contact");
			out.println(c);
		%>
	</body>
</html>