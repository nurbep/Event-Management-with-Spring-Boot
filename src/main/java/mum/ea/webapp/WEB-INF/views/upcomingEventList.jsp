<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="https://secure.meetupstatic.com/s/fonts/402715706936963211631/graphik.css"
	type="text/css" />
<link rel="stylesheet"
	href="https://secure.meetupstatic.com/s/style/75103493079032032679636/foundation/main.css"
	type="text/css" />


<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<!-- <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
 -->
<title>Upcoming Events</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 style="display: block;">MUM Event Management</h1>
			

		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="panel panel-default" style="width:100%">
			<div class="pull-right" >
			
			<form:form action="/" method="post" modelAttribute="event"
				class="form-inline">
				<div class="form-group mx-sm-3">
					<form:input path="name" cssClass="form-control" />

				</div>
				<input type="submit" value="Search" class="btn btn-info" />
				<!-- <a href="/" class="btn btn-info">
						View All</a> -->
				
			</form:form>
			</div>
				<div class="panel-body">

					<h1 class="text-primary">Upcoming Events</h1>

					<div class="bounds bounds--categories">
						<ul
							class="gridList gridList--has2 atMedium_gridList--has3 atLarge_gridList--has4"
							style="text-align: left;">
							<c:forEach var="event" items="${events}">
								<c:if test="${event.status==true}">
									<li class="gridList-item"
										style="padding-right: 15px; padding-left: 15px;"><a
										href="eventDetail/${event.id}" class="button button--activity">
											<div>
												<h4 class="text-danger">${event.name}</h4>
												<h6 class="text-success">Date: ${event.startDate}</h6>
											</div>
									</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>