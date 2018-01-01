<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Events</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 style="display: inline;">Event List</h1>
				<span class="pull-right"> <a href="/addEvent"
					class="btn btn-info"> Add Event</a>
				</span>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-body">

					<table class="table table-responsive">
						<thead>
							<tr>
								<th>Name</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Facility</th>
								<th>Number of People</th>
								<th>Category</th>
								<th>Status</th>
							</tr>
						</thead>
						<c:forEach var="event" items="${events}">
							<tr>
								<td>${event.name}</td>
								<td>${event.startDate}</td>
								<td>${event.endDate}</td>
								<td>${event.facility.name}</td>
								<td>${event.noOfPeople}</td>
								<td>${event.category.name}</td>
								<td>${event.status}</td>
								<td><a href="/events/${event.id}"
									class="btn btn_primary">edit</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>