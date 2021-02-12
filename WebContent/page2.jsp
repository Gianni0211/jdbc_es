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

.btn{
 background-color: green;
 color: white;
 margin-top: 10px;
 padding: 5px 8px 5px 8px;
 border-radius: 20px;
 cursor: pointer;
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
	<form class="form" action="country_servlet">
	<label for="input">Inerisci una paese</label>
	<input id="input" name="paese" placeholder="es. Italia" type="text">
	<label for="input">Inerisci un continente</label>
	<input id="input" name="continente" placeholder="es. Europe" type="text">
	<button type="submit" class="btn">Inserisci</button>
	</form>
	<p class="err">${requestScope.res }</p>
	<div class="result">
	<p class="item">Nome : ${requestScope.country.getName() }</p>
	<p class="item">Codice Nazione: ${requestScope.country.getCountryCode() }</p>
	<p class="item">Popolazione: ${requestScope.country.getPopulation() }</p>
	<p class="item">Continente: ${requestScope.country.getContinent() }</p>
	<p class="item">Estenzione Geografica: ${requestScope.country.getSurfaceArea() }</p>
	</div>
	
	<form class="form" action="page1_servlet">
	<button class="btn" type="submit">Cerca citta</button>
	</form>
</body>
</html>