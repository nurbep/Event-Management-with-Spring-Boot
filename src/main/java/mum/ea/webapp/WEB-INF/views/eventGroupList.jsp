<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<title>Event Groups</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 style="display: inline;">Event Group List</h1>
				<span class="pull-right"> <a href="addEventGroup"
					class="btn btn-info"> Add EventGroup</a>
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
								<th>Created By</th>
								<th>Date</th>
								<th>Categories</th>
								
							</tr>
						</thead>
						
						<c:forEach var="eventGroup" items="${eventGroups}">
							<tr>
								<td>${eventGroup.name}</td>
								<td>${eventGroup.createdBy.name}</td>
								<td>${eventGroup.createdOn}</td>
								<td>
								 <c:forEach var="category" items="${eventGroup.categoryList}">
								 ${category.name} 
								 </c:forEach>
								</td>
								
								
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>