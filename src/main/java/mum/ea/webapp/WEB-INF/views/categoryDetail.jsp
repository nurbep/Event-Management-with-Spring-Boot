<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.error{
		color: #ff0000;
		font-style: italic;
	}
</style>

<title>Category Detail</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Category Detail</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Enter Details</h3>
					</div>
					<div class="panel-body">
						<form:form action="../categories/${category.id}" method="post" modelAttribute="category">

							<div class="form-group">
								<label><span>Name:</span> 
									<form:input path="name" cssClass="form-control" />
									<form:errors path="name" cssClass="error" />
								</label>
							</div>
							<div class="form-group">
								<label><span>Description:</span> <form:input
										path="description" cssClass="form-control" /></label>
							</div>
							<c:if test="${category.id!=0}">
								<input type="submit" value="Update" class="btn btn-primary" />
							</c:if>
							<c:if test="${category.id==0}">
								<input type="submit" value="Save" class="btn btn-primary" />
							</c:if>
							<a class="btn btn-primary" href="/categories">Back to List</a>
							<c:if test="${category.id!=0}">
								<button form="bldDelete" type="submit" class="btn btn-warning">Delete</button>
							</c:if>
						</form:form>

						<form:form id="bldDelete" action="/categories/delete/${category.id}" method="post" modelAttribute="category"></form:form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>