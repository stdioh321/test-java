<%--
  Created by IntelliJ IDEA.
  User: hdias
  Date: 26/12/20
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>HELLO</h1>
<img  src="assets/penguin.jpg" />
<c:if test="${msg != null}">
    <h2>${msg}</h2>
</c:if>
</body>
</html>
