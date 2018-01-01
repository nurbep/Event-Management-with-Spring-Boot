<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Room Detail</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Room Detail</h1>
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
						<form:form action="/admin/rooms/${room.id}" method="post"
							modelAttribute="room">

							<div class="form-group">
								<label><span>Number:</span> <form:input path="number"
										cssClass="form-control" /></label>
							</div>
							<div class="form-group">
								<label><span>Name:</span> <form:input path="name"
										cssClass="form-control" /></label>
							</div>
							<div class="form-group">
								<label><span>Building:</span> <form:select path="building"
										cssClass="form-control">
												<form:options items="${buildings}" itemLabel="name" itemValue="id"  />
									</form:select> </label>
							</div>
							<div class="form-group">
								<label><span>No. of Occupants:</span> <form:input
										path="maxNoOfOccupants" cssClass="form-control" /></label>
							</div>
							<div class="form-group">
								<label><span>Description:</span> <form:input
										path="description" cssClass="form-control" /></label>
							</div>
							<c:if test="${room.id!=0}">
								<input type="submit" value="Update" class="btn btn-primary" />
							</c:if>
							<c:if test="${room.id==0}">
								<input type="submit" value="Save" class="btn btn-primary" />
							</c:if>
							<a class="btn btn-primary" href="/rooms">Back to List</a>
							<c:if test="${room.id!=0}">
								<button form="roomDelete" type="submit" class="btn btn-warning">Delete</button>
							</c:if>
						</form:form>

						<form:form id="roomDelete" action="/rooms/delete/${room.id}" method="post" modelAttribute="room"></form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>