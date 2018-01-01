<%@ include file="/resources/common/header.jspf"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<jsp:include page="header.jsp" />
<div align="center" class="container"
	style="margin: 1% auto; width: auto; border: 2px solid #F0FFFF; border: 2px solid #73AD21; background: url(home.jpg);">

	<h1>
	${principal.username}
		<security:authorize access="isAuthenticated()">
    authenticated as <security:authentication
				property="principal.username" />
		</security:authorize>
	</h1>
</div>

<%@ include file="/resources/common/footer.jspf"%>