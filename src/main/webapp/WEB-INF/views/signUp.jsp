<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>

<title>Sign Up</title>
</head>
<body>
	<br />
	<div class="jumbotron">
		<form:form modelAttribute="user" action="register" method="post" class="form-horizontal">
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="firstName"><spring:message code="member.firstname" text="First Name:"/></label>
				<form:input class="col-xs-9 form-control" path="firstName" id="firstName" tabindex="1" />
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="lastName"><spring:message code="member.lastname" text="Last Name:"/></label>
				<form:input class="col-xs-9 form-control" path="lastName" id="lastName" tabindex="2" />
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="email"><spring:message code="member.email" text="Email:"/></label>
				<form:input class="col-xs-9 form-control" path="email" id="email" tabindex="3" />
			</div>a
		
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="password"><spring:message code="user.password" text="Password:"/></label>
				<form:input class="col-xs-9 form-control" type="password" path="userCredentials.password" id="password" tabindex="5"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="confirm_password"><spring:message code="user.confirmPassword" text="Confirm Password:"/></label>
				<form:input class="col-xs-9 form-control" type="password" path="userCredentials.verifyPassword" id="confirm_password" tabindex="5"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="authoroties"><spring:message code="user.role" text="Role:"/></label>
				<form:input class="col-xs-9 form-control" value="ROLE_USER" path="userCredentials.autharities" id="authoroties" tabindex="10"/>
			</div>
			<div class="form-group">
			    <h2><spring:message text="Addresses:"/></h2>
			</div>
			<c:forEach var="address" items="${user.addresses}" varStatus="status">
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="state"><spring:message text="State:"/></label>
				<input class="col-xs-9 form-control" type="text" name="addresses[${status.index}].state" id="state" value="${address.state}" tabindex="6"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="city"><spring:message text="City:"/></label>
				<input class="col-xs-9 form-control" type="text" name="addresses[${status.index}].city" value="${address.city}"id="city" tabindex="7"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="street"><spring:message text="Street:"/></label>
				<input class="col-xs-9 form-control" type="text" name="addresses[${status.index}].street" value="${address.street}" id="street" tabindex="8"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="zipCode"><spring:message text="State:"/></label>
				<input class="col-xs-9 form-control" type="text" name="addresses[${status.index}].zipcode" id="zipcode" value="${address.zipcode}" tabindex="9"/>
			</div>
			</c:forEach>
			<div class="form-group">
			    <div class="col-xs-offset-3 col-xs-9">
				    <input class="btn btn-default" type="submit" id="register" value="Register">
			    </div>
			</div>
		</form:form>
	</div>
</body>
</html>
