<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>FORM</h1>

<form action="form" method="post">
Name: <input type="text" name="name" placeholder="Name" /><br />
Population: <input type="number" name="population" placeholder="population" /><br />
<input type="submit" value="Send" />
</form>


</body>
</html>