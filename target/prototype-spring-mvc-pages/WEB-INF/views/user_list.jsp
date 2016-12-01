<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Spring MVC and List Example</h2>

	<c:set var="a" value="5" scope="request" />
	<c:set var="b" value="15" scope="request" />
	<p>Expression output: ${a+b}</p>


	<ul>
		<c:forEach var="listValue" items="${userlist}">
			<li>${listValue.userId} | ${listValue.userName}</li>
		</c:forEach>
	</ul>

	<!-- <c:if test="${not empty userlist}"> -->
	<!--  </c:if> -->
</body>
</html>