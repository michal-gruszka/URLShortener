<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="url">
	<div class="url-header">
		<h1>URL Shortener</h1>
	</div>
	<div class="url-form">
	<h3>URL:</h3>
	<form:form action="/" method="post" modelAttribute="url">
		<form:errors path="originalUrl" class="error-text"/>

		<form:input type="text" path="originalUrl" />

		<input type="submit" value="Shorten" class="url-button"/>
	</form:form>
	
	</div>
</div>
</body>
</html>