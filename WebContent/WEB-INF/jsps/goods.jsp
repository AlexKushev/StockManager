<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table class=goods>

		<tr>
			<td>Name</td>
			<td>Amount</td>
		</tr>
		<c:forEach var="object" items="${goods}">
			<tr>
				<td id="name"><c:out value="${object.name}"></c:out></td>
				<td id="amount"><c:out value="${object.amount}"></c:out></td>
				<td><input type="button"
					onclick="location.href='http://google.com';" value="Change Amount" /></td>
				<td><a href="${pageContext.request.contextPath }/delete?id=${object.id}">Delete</a></td>
			</tr>
		</c:forEach>

		<tr>
			
				<td><a href="${pageContext.request.contextPath }/addgoods">Add new
					goods</a></td>

		</tr>
	</table>

</body>
</html>