<html>
<head>
<title>
	Form
</title>
<script type="text/javascript" src="http://raw.githubusercontent.com/nosir/cleave.js/master/dist/cleave.min.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<form action="my-form" method="post">
<div>
<label for="fName">Nome:</label>
<input type="text" placeholder="Nome" id="fName" name="fName" value="Seu Nome" />
</div>
<br>
<div>
<label for="fEmail">Email:</label>
<input type="email" placeholder="Email" id="fEmail" name="fEmail" required="required" value="temp@gmail.com" />
</div>
<br>
<label for="fBirthdate">Birthdate:</label>
<input type="text" placeholder="Birthdate" id="fBirthdate" name="fBirthdate" required="required" value="1990-01-01" />
</div>
<br>
<div >
	<input type="submit" value="Enviar" />
</div>
</form>
</body>
</html>
