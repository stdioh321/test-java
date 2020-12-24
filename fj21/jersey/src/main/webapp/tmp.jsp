<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.stdioh321.jersey.entities.User"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.time.Instant"%>
<%@ page isELIgnored="false"%>

<jsp:useBean id="utils" class="com.stdioh321.jersey.helpers.Utils" />


<html lang="en">

<head>



<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tmp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"
	integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.0/axios.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/vue-moment@4.1.0/dist/vue-moment.min.js"></script>
</head>

<body>
	<div class="my-3">
		<mytags:dateFIeld id="aaa" />

	</div>
	<div id="app">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<c:import url="pages/header.jsp"></c:import>
				</div>
				<div class="col-12">
					<h2>
						<%
							out.print("ssss");
						%>
					</h2>

					<div>
						<c:url value="/assets/penguin.jpg" var="img"></c:url>
						<img src="${img}" />
					</div>
					<c:forEach var="i" begin="1" end="100" step="1">
						<span><c:out value="${i}"></c:out></span>
					</c:forEach>

				</div>
				<div class="col-12">
					<c:forEach var="ut" items="${utils.someList()}">
						<c:out value="${ut}"></c:out>
					</c:forEach>

					<c:choose>
						<c:when test="${ 10 > 9 }">
							<c:out value="OK"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="NOT OK"></c:out>
						</c:otherwise>
					</c:choose>


				</div>
				<div class="col-12">
					<div>
						<%
							String tmp = "tmp";
						EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
						EntityManager em = emf.createEntityManager();
						List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
						for (User u : users) {
							out.println("Old Way: " + u.getName() + "<br />");
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    Vue.use(vueMoment);
        var app = new Vue({
            el: "#app",
            data: {
                msg: "Hello",
                
            },
            methods: {
            },
            mounted() {
            }
        });
    </script>
</body>

</html>