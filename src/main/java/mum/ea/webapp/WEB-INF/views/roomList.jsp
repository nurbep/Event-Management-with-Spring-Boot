<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rooms</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 style="display: inline;">Room List</h1>
			<span class="pull-right"> <a href="/admin/addRoom"
				class="btn btn-info"> Add Room</a>
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
								<th>Number</th>
								<th>Name</th>
								<th>Building</th>
								<th>Description</th>
								<th>Max Number of Occupants</th>
							</tr>
						</thead>
						<c:forEach var="room" items="${rooms}">
							<tr>
								<td>${room.number}</td>
								<td>${room.name}</td>
								<td>${room.building.name}</td>
								<td>${room.description}</td>
								<td>${room.maxNoOfOccupants}</td>
								<td><a href="/admin/rooms/${room.id}" class="btn btn-primary">Edit</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>