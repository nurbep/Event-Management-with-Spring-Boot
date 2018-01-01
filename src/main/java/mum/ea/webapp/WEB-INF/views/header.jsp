<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="resources/css/header.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="header">
		<security:authorize access="isAuthenticated()">

			<div class="userInfo">
				<h2>
					Welcome
					<security:authentication property="principal.username" />
				</h2>

			</div>
			<a id="lnkLogout" href="logout" class="actionButton">Logout</a>
		</security:authorize>

	</div>

</body>
</html>