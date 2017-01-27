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
<style type="text/css"> 
.center_div{
    margin: 0 auto;
    width:80% /* value of your choice which suits your alignment */
}</style>
</head>
<body>
	<div class="container">
		<div class="pull-right">
			<a href="?language=en">English</a>|<a href="?language=ar">Arabic</a>
		</div>
		
			<h3 class="text-muted">Olaf Ecommerce</h3>
		</div>


		<div class="jumbotron">
			<h1>Ecommerce Website</h1>
			<p>Enjoy# Shopping</p>
		</div>

		<div class="row">
	<div class="container center_div">
				
						<div class="alert alert-danger">
							Access denied<br />
						</div>
						<button class="btn btn-success">Home</button>
				
				</div>
				</div>

  </body>
</html>