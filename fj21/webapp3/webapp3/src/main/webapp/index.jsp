<html>
<head>
<title>
	Form
</title>
<script type="text/javascript" src="resources/cleave.min.js"></script>
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

<label for="fCreated">Created At:</label>
<input type="text" placeholder="Created At" id="fCreated" name="fCreated" required="required" value="01-01-1990" />
</div>
<br>
<div >
	<input type="submit" value="Enviar"  />
</div>
</form>
</body>
<script type="text/javascript">
var cleave = new Cleave('#fCreated', {
    date: true,
    delimiter: '-',
    datePattern: ['d', 'm', 'Y']
});

var f= document.getElementsByTagName("form")[0];
f.onsubmit = function(e){
	var birthD = e.target.fCreated.value;
	if(!/^\d{2}-\d{2}-\d{4}$/.test(birthD)){
		e.preventDefault();
		return false;	
	}	

	
}
</script>
</html>
