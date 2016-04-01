<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.12.2.min.js"></script>

<script type="text/javascript">
	function onLoad() {
		$("#password").keyup(checkPasswordMatch);
		$("#confirm_password").keyup(checkPasswordMatch);

		$("#details").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmpassword = $("#confirm_password").val();

		if (password != confirmpassword) {
			alert("Passwords do not match");
			return false;
		} else {
			return true;
		}
	}

	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmpassword = $("#confirm_password").val();

		if (password.length > 1 || confirmpassword.length > 1) {
			if (password == confirmpassword) {
				$("#matchpass").text("Password match");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("Password do not match");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}

	}

	$(document).ready(onLoad);
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new account</title>
</head>
<body>
	<h2>Create new account</h2>

	<sf:form id="details" method="post"
		action="${pageContext.request.contextPath}/createaccount"
		commandName="user">
		<table class="formtable">
			<tr>
				<td class="label">Username</td>
				<td><sf:input path="username" id="username" name="username"
						type="text" /><br /> <sf:errors path="username" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Password</td>
				<td><sf:input path="password" id="password" name="password"
						type="password" /><br /> <sf:errors path="password"
						cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Confirm Password</td>
				<td><input id="confirm_password" name="confirm_password"
					type="password" />
					<div id="matchpass"></div> <br /></td>
			</tr>

			<tr>
				<td><input value="Create account" type="submit" /></td>

			</tr>

		</table>

	</sf:form>


</body>
</html>