<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">


<title>Event Search</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Event search</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Enter event name</h3>
					</div>
					<div class="panel-body">
						<form:form action="/" method="post"
							modelAttribute="event">

							<div class="form-group">
								 <form:input path="name"
										cssClass="form-control" />
							</div>
							
							
							
								<input type="submit" value="Search" class="btn btn-primary" />
							
							
							
						</form:form>

						

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>