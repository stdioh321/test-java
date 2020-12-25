<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Form Login</title>
</head>
<body>
	<form method="POST" action="login">
		Username: <input type="text" id="username" name="username" required /><br />
		Password: <input type="password" id=password "" name="password"
			required /><br /> <input type="submit" value="Send" />
	</form>
	<br />
	<div>
		<%
			String err = request.getParameter("error");
		if (err != null && !err.isEmpty()) {
			out.println(err);
		}
		%>
	</div>

</body>
</html>