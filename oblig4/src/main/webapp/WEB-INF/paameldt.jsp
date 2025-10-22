<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
		<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="simple.css">
		<title>Påmeldingsbekreftelse</title>
	</head>
	<body>
		<h2>Påmeldingsbekreftelse</h2>
		<p>Påmeldingen er mottatt for</p>
		<p>
			&nbsp;&nbsp;&nbsp;${deltager.fornavn}<br />
			&nbsp;&nbsp;&nbsp;${deltager.etternavn}<br />
			&nbsp;&nbsp;&nbsp;${deltager.mobilnummer}<br />
			&nbsp;&nbsp;&nbsp;${deltager.kjonn}
		</p>
		<a href="<c:url value='/deltagerliste'/>">Gå til deltagerlisten</a>
	</body>
</html>