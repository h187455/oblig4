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
		<label>
			Mann <input type="radio" name="kjonn" value="mann" >
		</label>
		<label>
		Kvinne <input type="radio" name="kjonn" value="kvinne"> <br>
		</label>
		<input type="submit" value="Meld inn"/>
	</form>


</body>
</html>
