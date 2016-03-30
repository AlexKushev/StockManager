<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<sf:form method="post"
		action="${pageContext.request.contextPath}/doadd" commandName="goods">
		<table class="formtable">
			<tr>
				<td class="label">Name</td>
				<td><sf:input path="name" id="name" name="name" type="text" /><br />
					<sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Amount</td>
				<td><sf:input path="amount" id="amount" name="amount"
						type="number" min="1" max="10" /><br /> <sf:errors path="amount"
						cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td><input value="Add new object" type="submit" /></td>
			</tr>

		</table>

	</sf:form>

</body>
</html>