<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=STIX+Two+Text:ital@1&display=swap" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap" rel="stylesheet">
<style>
.about-form{
    text-align: center;
    font-size: 32px;
    font-family: sans-serif;
    font-weight: 700;
    font-family: 'STIX Two Text', serif;
    margin: 60px 50px;
}
h1{
    font-size: 65px;
    font-weight: 700;
    color:rgb(238, 172, 49);
    font-family: 'MonteCarlo', cursive;
    text-align: center;
    word-spacing: 5px;
    line-height: 200%;
    letter-spacing:2px;
}     
.about-submit{
    font-size: 25px;
    font-weight: 700;
    background-color: rgb(176, 176, 228);
    border:none
}
body{
    background: linear-gradient(to right, #4fc8fc,#70ff94);
}
button{
    margin:20px 10px;
    border:none;
    text-decoration: none;
    font-family:sans-serif;
    font-weight: 600;
    font-size: 25px;
    color:white;
    background-color: rgb(89, 150, 255);
    transition: all 0.3s ease-in-out ;
}
button:hover{
    background: rgb(247, 138, 104);
}
</style>
</head>
<body>
	<form action="" method="POST" class="about-form">
        Type some thing: <input class="about-submit" type="number" name="id" placeholder="Search...">
        <button value="submit">Submit</button>    
    </form>
	<h1>Your Searching Result: ${user }</h1>
</body>
</html>