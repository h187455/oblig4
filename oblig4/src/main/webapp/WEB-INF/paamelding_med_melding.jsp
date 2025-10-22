<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
<!-- <script src="js/myscript.js" defer></script>  -->  
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<p style="color:red;">Påmeldingsdetaljer er ugyldige</p>

	<!-- Jeg har fjernet alt som har med form og input å gjøre,
		 siden dette er pensum. Her får dere sette opp skjemaet
		 selv. Lykke til.
	-->
	<c:forEach var="feilmelding" items="${feil}"">
		<p style="color: red;">${feilmelding}</p>
	</c:forEach>

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
	</form>

</body>
</html>
