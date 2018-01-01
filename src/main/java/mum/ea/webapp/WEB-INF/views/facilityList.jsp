<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Facilities</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 style="display: inline;">Facility List</h1>
			<span class="pull-right"> <a href="/admin/addFacility"
				class="btn btn-info"> Add Facility</a>
			</span>
		</div>
	</div>
	<div class="container">
	<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-body">

					<table class="table table-responsive">
						<thead>
							<tr>
								<th>Facility code</th>
								<th>Name</th>
								<th>Building</th>
								<th>Type</th>
								<th>Description</th>
								<th>Max Number of Occupants</th>

							</tr>
						</thead>
						<c:forEach var="facility" items="${facilities}">
							<tr>
								<td>${facility.code}</td>
								<td>${facility.name}</td>
								<td>${facility.building.name}</td>
								<td>${facility.type}</td>
								<td>${facility.description}</td>
								<td>${facility.maxPeople}</td>
								<td><a href="/admin/facilities/${facility.id}"
									class="btn btn-primary">Edit</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>