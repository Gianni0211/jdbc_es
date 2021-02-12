<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
.form{
   display: flex;
   flex-direction: column;
   width: 200px;
   margin: auto;
   margin-top: 80px;
}


.err{
  margin: 20px auto 10px auto;
  color: red;
  width: 200px;
  
}

.btn{
 background-color: green;
 color: white;
 margin-top: 10px;
 padding: 5px 8px 5px 8px;
 border-radius: 20px;
 cursor: pointer;
}
</style>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jdbc</title>

</head>
<body>
<h3>Utente: ${sessionScope.userName }</h3>
	<form class="form" action="addcity_servlet">
	<label for="input">Nome</label>
	<input id="input" name="name"  type="text">
	<label for="input">Codice Paese</label>
	<input id="input" name="countryCode" placeholder="es. ITA" type="text">
	<label for="input">Distretto</label>
	<input id="input" name="district" placeholder="es. Lombardia" type="text">
	<label for="input">Popolazione</label>
	<input id="input" name="population" placeholder="es. 10000" type="text">
	<label for="input">ID</label>
	<input id="input" name="id" placeholder="es. 123" type="text">
	<button type="submit" class="btn">Inserisci</button>
	
	${requestScope.res }
	</form>
	
	
</body>
</html>