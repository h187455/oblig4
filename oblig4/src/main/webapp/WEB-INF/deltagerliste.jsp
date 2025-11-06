<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
	<head>
		<link rel="stylesheet" href="simple.css">
		<meta charset="UTF-8">
		<title>Deltagerliste</title>
		<style>
			.highlight {
				background-color: lime !important;
				color: white;
			}
		</style>
		
	</head>
	<body>
		<h2>Deltagerliste</h2>
		<p>Innlogget som: 
		    <c:out value="${sessionScope.mobilnummer}" /> / 
		    <c:out value="${sessionScope.fornavn}" /> 
		    <c:out value="${sessionScope.etternavn}" />
		</p>

		<table>
			<tr>
				<th>Kjønn</th>
				<th align="left">Navn</th>
				<th align="left">Mobilnummer</th>
			</tr>
			
			<c:forEach var="deltager" items="${alleDeltagere}">
				<tr class="${deltager.mobilnummer == sessionScope.mobilnummer ? 'highlight' : ''}">
					<td align="center">
						<c:choose>
							<c:when test="${deltager.kjonn == 'kvinne'}">&#9792;</c:when>
							<c:when test="${deltager.kjonn == 'mann'}">&#9794;</c:when> 
						</c:choose>
					</td>
					<td>${deltager.fornavn} ${deltager.etternavn}</td>
					<td>${deltager.mobilnummer}</td>
				</tr>
			</c:forEach>
		</table>
		<form action="loggUt" method="post">
			<input type="submit" value="Logg ut">
		</form>
	</body>
</html>