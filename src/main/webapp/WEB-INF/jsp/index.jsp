<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>

	<h2>URL shortener</h2>

	<form:form action="result" method="post" modelAttribute="url">

		URL: <form:input path="originalUrl" />
		<form:errors path="originalUrl" cssStyle="color: #ff0000;" />

		<input type="submit" value="Shorten URL" />
	</form:form>

</body>
</html>