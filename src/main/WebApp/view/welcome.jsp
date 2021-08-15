<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
<style>
#button {
    width: 10em;
    border: 2px solid green;
    background: rgb(240, 240, 127);
    border-radius: 5px;
    margin-top: 20px;
    margin-left: 150px;
}
a {
    display: block;
    width: 100%;
    line-height: 2em;
    text-align: center;
    text-decoration: none;
    border-radius: 5px;
    font-size: 20px;
    font-weight: bold;
    font-family: sans-serif;
    font-weight: bold;
}
a:hover {
    color: steelblue;
    background: rgb(169, 240, 240);
}
.about-div{
    width: 6em;
    border: 2px solid green;
    background: #ffe;
    border-radius: 5px;
    position: relative;
    right: -1050px;
    top: -40px;
}
.about-text{
    font-size: 20px;
    text-align: center;
    text-decoration: none;
    border-radius: 5px;
    display: block;
    width: 100%;
    line-height: 2em;
}
.about-text:hover{
    background-color: rgb(178, 238, 121);
    border-radius: 5px;
}
body{
    background:linear-gradient(to right, #ee9ca7,#ffdde1)
}
h1{
    font-family: sans-serif;
}

</style>
</head>
<body>
	<h1>Chose your role in below: <div class="about-div"><a class="about-text" href="http://localhost:8899/logout">logout</a></div></h1>
	<div id="button"><a href="http://localhost:8899">Student</a></div>
	<br><br>
	<div id="button"><a href="http://localhost:8899/admin/">Admin</a></div>
	<br><br>
	<div id="button"><a href="http://localhost:8899/admin/">Collaborate</a></div>
</body>
</html>