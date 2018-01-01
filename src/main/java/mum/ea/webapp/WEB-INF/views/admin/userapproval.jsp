<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<div class="container">

	<spring:url value="/admin/approval/" var="saveApproval" />

	<form:form modelAttribute="approvalForm" method="POST" action="${saveApproval}">
		
		<table class="table table-striped">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email(s)</th>
				<th align="right"></th>
			</tr>
			 
			<c:forEach items="${userList}" var="users">
				<tr>
					<td width="150px">${users.name}</td>
					<td width="150px">${users.lastName}</td>
					<td width="40px">${users.email}</td>
					<td align="right">
						<spring:url value="/admin/userapprove?id=${users.id}" var="userApprove" />
						<a type="button" class="btn btn-primary" href="${userApprove}">Approve</a>
						<spring:url value="/admin/notapprove?id=${users.id}" var="notApproved" />
						<a type="button" class="btn btn-large btn-primary btn-warning" href="${notApproved}">Not Approve</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</form:form>
 
	
</div>
<script type="text/javascript">
	function myFunc() {
    var  selectedValue= $("#categoryId").val();
    alert(selectedValue);
   }
</script>

<%@ include file="/resources/common/footer.jspf"%>

<script>
$(document).ready(function () {
    var url = window.location;
    $('ul.nav > li').removeClass('active');
    $('ul.nav a[href="'+ url +'"]').parent().addClass('active');
    $('ul.nav a').filter(function() {
         return this.href == url;
    }).parent().addClass('active');
});
</script>