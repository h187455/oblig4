<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
	<head>
		<link rel="stylesheet" href="simple.css">
		<script src="kilentValidering.js" defer></script>
		<title>Logg inn</title>
	</head>
	
	<body>
		<h2>Logg inn</h2>
		<p style="color:red;">
			<c:forEach var="feilmelding" items="${feilmeldinger}">
				${feilmelding}<br>
			</c:forEach>
		</p>
		
		<form action="validerOgLoggInn" method="post" id="validerOgLoggInn">
			Mobil: <input type="text" name="mobilnummer"><br>
			Passord: <input type="password" name="passord"><br>
			<input type="submit" value="Logg inn">
		</form>
	</body>
</html>
