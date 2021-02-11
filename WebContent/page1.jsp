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
.err{
  margin: 20px auto 10px auto;
  color: red;
  width: 200px;
  
}
</style>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jdbc</title>

</head>
<body>
<h3>Utente: ${sessionScope.userName }</h3>
	<form class="form" action="city_servlet">
	<label for="input">Inerisci una citta</label>
	<input id="input" name="citta" placeholder="es. Milano" type="text">
	<button type="submit" class="btn">Inserisci</button>
	</form>
	<p class="err">${requestScope.res }</p>
	<div class="result">
	
	<p class="item">Citta: ${requestScope.city.getName() }</p>
	<p class="item">Paese: ${requestScope.city.getCountry() }</p>
	<p class="item">Popolazione: ${requestScope.city.getPopulation() }</p>
	</div>
	<form class="form" action="page2_servlet">
	<button type="submit">Cerca paese</button>
	</form>
</body>
</html>