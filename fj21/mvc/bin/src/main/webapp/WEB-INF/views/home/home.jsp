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
                                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
                            </head>

                            <body>
                                <div class="id">
                                    <h1>
                                        <fmt:formatDate value="${d}" pattern="dd/MM/yyyy HH:mm:ss z" />
                                    </h1>
                                    <div>
                                    	<img class="img-fluid" alt="" src='${pageContext.request.contextPath}/assets/penguin.jpg'>
                                    </div>
                                    <table class="table table-responsive">
                                        <thead>
                                            <tr>
                                                <td>Id</td>
                                                <td>Name</td>
                                                <td>Username</td>
                                                <td>Password</td>
                                                <td>Created At</td>
                                                <td>Updated At</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${users}" var="u">
                                                <tr>
                                                    <td>${u.getId()}</td>
                                                    <td>${u.getName()}</td>
                                                    <td>${u.getUsername()}</td>
                                                    <td>${u.getPassword()}</td>
                                                    <td>${u.getCreatedAt()}</td>
                                                    <td>${u.getUpdatedAt()}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                    </ul>

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
                                </div>
                            </body>
                            <script type="text/javascript">
                                window.addEventListener("load", function() {
                                    console.log("WINDOW LOAD");
                                });
                            </script>

                            </html>