<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<title>Comments</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 style="display: inline;">Comment List</h1>
				<span class="pull-right"> <a href="addComment"
					class="btn btn-info"> Add Comment</a>
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