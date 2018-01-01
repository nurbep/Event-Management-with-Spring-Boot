<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">


<title>Building Detail</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Comment Detail</h1>
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
						<form:form action="/saveEventComment/${event.id}" method="POST"
							modelAttribute="comment">

							<div class="form-group">
								<label><span>Description:</span> <form:input path="description"
										cssClass="form-control" /></label>
							</div>
							<div class="form-group">
								<label><span>Rating:</span>
									<span><form:radiobutton path="rating" value="5" label="5" checked="checked" /></span>
									<span><form:radiobutton path="rating" value="4" label="4" /></span>
									<span><form:radiobutton path="rating" value="3" label="3" /></span>
									<span><form:radiobutton path="rating" value="2" label="2" /></span>
									<span><form:radiobutton path="rating" value="1" label="1" /></span>
								</label>
							</div>
							
							
							
								<input type="submit" value="Save" class="btn btn-primary" />
							
							<a class="btn btn-primary" href="comments">Back to List</a>
							
						</form:form>

						

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>