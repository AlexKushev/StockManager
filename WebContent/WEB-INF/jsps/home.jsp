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

	<c:url var="logoutUrl" value="/logout" />

	<form action="${logoutUrl}" method="post">

		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />

	</form>

	<table class=goods>

		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Amount</td>
		</tr>
		<c:forEach var="object" items="${goods}">
			<tr>
				<td id="id"><c:out value="${object.id }"></c:out></td>
				<td id="name"><c:out value="${object.name}"></c:out></td>
				<td id="amount"><c:out value="${object.amount}"></c:out></td>
				<td id="new_amount"><input type="number" min="1"
					required="required" id="new_amount_field${object.id}" /></td>
				<td><input type="button"
					onclick="location.href='${pageContext.request.contextPath}/change?id=${object.id }&amount=' + myFunction(${object.id });"
					value="Change Amount" /></td>
				<td><input type="button" id="del_btn"
					onclick="location.href='${pageContext.request.contextPath}/delete?id=${object.id }';"
					value="Delete" /></td>
			</tr>
		</c:forEach>

		<tr>

			<td><input type="button"
				onclick="location.href='${pageContext.request.contextPath}/addgoods';"
				value="Add new item" /></td>
		</tr>
	</table>


	<script>
		function myFunction(id) {
			var test = "new_amount_field".concat(id);
			var a = document.getElementById(test).value;
			if(a == null || a == ''){
     			 alert('You should enter new amount value.');
     			 window.onbeforeunload = function(){
            return 'Are you sure you want to leave?';
        };
			} else {
				return a;
			}
		};
		
		
	</script>


	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>


</body>
</html>