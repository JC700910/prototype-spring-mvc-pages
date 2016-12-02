<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>User Details</h2>

	<c:set var="a" value="5" scope="request" />
	<c:set var="b" value="15" scope="request" />
	<p>Expression output: ${a+b}</p>


	<ul>
	
			<li>User id:  ${user.userId}</li>
			<li>Name:  ${user.userName}</li>

	</ul>

	<!-- <c:if test="${not empty userlist}"> -->
	<!--  </c:if> -->
</body>
</html>