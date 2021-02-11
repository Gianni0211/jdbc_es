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
.result{
  margin: auto;
  margin-top: 30px;
  width: 200px;
}
</style>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jdbc</title>

</head>
<body>
	<form class="form" action="user_servlet">
	<label for="input">Inerisci un nome utente</label>
	<input id="input" name="utente" placeholder="es. Mario21" type="text">
	<button type="submit" class="btn">Inserisci</button>
	</form>
	
	
</body>
</html>