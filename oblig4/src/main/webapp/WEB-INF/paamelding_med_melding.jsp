<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="no">
<head>
	<link rel="stylesheet" href="simple.css">
	<script src="klientValidering.js" defer></script>
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<p style="color:red;">
		<c:forEach var="feilmelding" items="${feilmeldinger}">
			${feilmelding}<br>
		</c:forEach>
		</p>

	<form action="validerOgRegistrer" method="post">
		Fornavn <input type="text" name="fornavn" value="${deltager.fornavn}"><br>
		Etternavn <input type="text" name="etternavn" value="${deltager.etternavn}"><br>
		Mobil <input type="text" name="mobilnummer" value="${deltager.mobilnummer}"><br>
		Passord	<input type="password" name="passord" value="${deltager.passord}"><br>
		Passord repetert<input type="password" name="repetertPassord"><br>

<<<<<<< HEAD
	<form action="sjekkPerson" method="get" id="person">
		Fornavn <input type="text" name="fornavn" value="${param.fornavn"><br>
		Etternavn <input type="text" name="etternavn" value="${param.etternavn}"><br>
		Mobil <input type="text" name="mobil" value="${person.mobil}"><br>
		
		<label>
			<input type="radio" name="kjonn" value="${param.mann}">
			Mann
		</label>
		<label>
			<input type="radio" name="kjonn" value="${param.kvinne}">
			Kvinne
		</label>

		Passord <input type="text" name="passord" value="${param.passord}"><br>
		Valider passord <input type="text" name="valider" value="${param.valider}"><br>

		<input type="submit" value="Meld inn"/>
=======
		Mann <input type="radio" name="kjonn" value="mann" > 
		Kvinne <input type="radio" name="kjonn" value="kvinne"> <br>
		<input type="submit" value="Send!"/>
>>>>>>> ec89079ea5b3ae54d3e199c285c7d7c42628faf9
	</form>


</body>
</html>
