<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.stdioh321.jersey.entities.User"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page isELIgnored="false" %>



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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.0/axios.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/vue-moment@4.1.0/dist/vue-moment.min.js"></script>
</head>

<body>
	<div id="app">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h2>
						<%
							out.print("ssss");
						%>
					</h2>
					<c:forEach var="i" begin="1" end="10" step="1">
						<h3>
							<c:out value="${i}"></c:out>
						</h3>
					</c:forEach>

				</div>
				<div class="col-12">
					<div>
						<%
							String tmp = "tmp";
						EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
						EntityManager em = emf.createEntityManager();
						List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
						for (User u : users) {
						%>
							<div>${tmp}</div>
						<%
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