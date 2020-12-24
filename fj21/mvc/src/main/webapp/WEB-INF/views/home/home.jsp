<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page isELIgnored="false"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<c:choose>
		<c:when test="${title.getId() == null}">
		NULL
	</c:when>
		<c:otherwise>
	Not NULL
	</c:otherwise>
	</c:choose>
	<h1>-HOME-</h1>
	<%
		Set<String> myList = new HashSet<>();
	myList.add("a");
	myList.add("b");
	myList.add("c");
	myList.add("B");
	myList.add("d");
	for (String s : myList) {
		out.print("<h2>");
		out.print("Item: " + s);
		out.print("</h2>");
	}
	%>

</body>
</html>