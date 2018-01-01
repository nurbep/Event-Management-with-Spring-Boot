<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">


<title>Upcoming Event Detail</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<a href="/">Event Detail</a>
			</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="text-danger">${event.name}</h1>
				</div>
				<div class="panel-body">
					<p class="text-primary">
						This event will start at <span class="text-success">${event.startDate}</span>,
						and it will finish at <span class="text-success">${event.endDate}.</span>
					</p>
					<p class="text-primary">
						It will celebrate at <span class="text-success">${event.facility.name}</span>
						with <span class="text-success">${event.noOfPeople}</span> of
						people.
					</p>
					<p class="text-primary">
						This is a kind of <span class="text-success">${event.category.name}</span>
						event.
					</p>

					<table class="table table-responsive">
						<tr>
							<td><span class="pull-right"> <a
									href="/addComment/${event.id}" class="btn btn-info"> Add
										Comment</a>
							</span></td>
						</tr>
					</table>

					<h2>Comments</h2>

					<table class="table table-responsive">
						<thead>
							<tr>
								<th>Description</th>
								<th>Rating</th>
								<th>Date</th>
							</tr>
						</thead>
						<c:forEach var="comment" items="${comments}">
							<tr>
								<td>${comment.description}</td>
								<td>${comment.rating}</td>
								<td>${comment.commentDate}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
