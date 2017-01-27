<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en" ng-app>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>

<style type="text/css">
@import url("<spring:url value="/css/style.css"/>");
</style>
</head>
<body>
	<div class="container">
		<div class="pull-right">
			<a href="?language=en">English</a>|<a href="?language=ar">Arabic</a>
		</div>
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<li><a href="<spring:url value="/welcome"/>">Home</a></li>
				<li><a href="<spring:url value="/login"/>">Login</a></li>
				<li><a href="<spring:url value="/signUp"/>">Register</a></li>
				<li><a href="<spring:url value="/about"/>">About</a></li>
				<li><a href="<spring:url value="/contactUs"/>">Contact Us</a></li>

			</ul>
			<h3 class="text-muted">Olaf Ecommerce</h3>
		</div>


		<div class="jumbotron">
			<h1>Ecommerce Website</h1>
			<p>Enjoy# Shopping</p>
		</div>

		<div class="row">
		<div class="form-group">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							Login Failed, Incorrect Username or Password<br />
						</div>
					</c:if>
				</div>
			<form:form modelAttribute="user" action="postLogin" method="post" class="form-horizontal">
				
				<div class="form-group">
					<label class="col-xs-3 control-label" for="username"><spring:message
							code="member.username" text="Username:" /></label>
					<form:input class="col-xs-9 form-control" path="username"
						id="username" tabindex="1" />
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label" for="password"><spring:message
							code="member.password" text="Password:" /></label>
					<form:input type="password" class="col-xs-9 form-control"
						path="password" id="password" tabindex="2" />
				</div>
				<div class="form-group">
					<div class="col-xs-offset-3 col-xs-9">
						<input class="btn btn-primary" type="submit" id="signIn"
							value="Sign In">
					</div>
				</div>
			</form:form>

<div ng-init="title='ecommerce app'">
    
</div>
		</div>
		<style type="text/css">
        .form-control {
	        width: 300px
         }
       </style>
		<div class="footer"></div>

	</div>
</body>
</html>