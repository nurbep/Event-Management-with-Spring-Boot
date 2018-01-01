<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<style>
	.error{
		color: #ff0000;
		font-style: italic;
	}
</style>

<title>Event Detail</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1><a href="/">Event Detail</a></h1>
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
						<form:form action="../events/${event.id}" method="post"
							modelAttribute="event">
							<c:if test="${not empty errorMsg}">
								<div class="error alert-${css} alert-dismissible" role="alert">
									<strong>${errorMsg}</strong>
								</div>
							</c:if>

							<div class="form-group">
								<label><span>Name:</span> 
									<form:input path="name" cssClass="form-control" />
									<form:errors path="name" cssClass="error" />
								</label>
							</div>
													
							<div class="form-group">
								<label><span>Start Date:</span></label>
                				<div class='input-group date' id="startDate">
                    				<form:input path="startDate" cssClass="form-control" />
                    				<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                				</div>
                				<form:errors path="startDate" cssClass="error" />
            				</div>
							
							
							<div class="form-group">
								<label><span>End Date:</span></label>
                				<div class='input-group date' id="endDate">
                    				<form:input path="endDate" cssClass="form-control" />
                    				<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                				</div>
                				<form:errors path="endDate" cssClass="error" />
            				</div>
							
							<div class="form-group">
								<label><span>Facility:</span> 
								<form:select path="facility" cssClass="form-control">
										<form:option value="-1" label="--Please Select"/>
      									<form:options items="${facilities}" itemValue="id" itemLabel="name"/>
									</form:select> </label>
							</div>
							
							<div class="form-group">
								<label><span>Number of People:</span> 
									<form:input path="noOfPeople" cssClass="form-control" />
									<form:errors path="noOfPeople" cssClass="error" />
								</label>
							</div>
							
							<div class="form-group">
								<label><span>Category:</span> 
								<form:select path="category" cssClass="form-control">
										<form:option value="-1" label="--Please Select"/>
      									<form:options items="${categories}" itemValue="id" itemLabel="name"/>
									</form:select> </label>
							</div>
							
							<div class="form-group">
								<label><span>Status:</span>
								<form:checkbox path="status" checked="checked" />
								</label>
							</div>
							
							<c:if test="${event.id!=0}">
								<input type="submit" value="Update" class="btn btn-primary" />
							</c:if>
							<c:if test="${event.id==0}">
								<input type="submit" value="Save" class="btn btn-primary" />
							</c:if>
							<a class="btn btn-primary" href="/events">Back to List</a>
							<c:if test="${event.id!=0}">
								<button form="bldDelete" type="submit" class="btn btn-warning">Delete</button>
							</c:if>
						</form:form>

						<form:form id="bldDelete" action="/events/delete/${event.id}" method="post" modelAttribute="event"></form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="resources/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="resources/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script type="text/javascript">
		 $('#startDate').datetimepicker({
        	weekStart: 1,
        	todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
        	showMeridian: 1
    	});
		
		$('#endDate').datetimepicker({
        	weekStart: 1,
        	todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
        	showMeridian: 1
    	}); 
	</script>
</body>
</html>