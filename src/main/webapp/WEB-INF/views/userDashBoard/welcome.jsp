<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">
<style type="text/css">@import url("<spring:url value="/css/style.css"/>");</style>
</head><body>
	<div class="container">
	    <div class="pull-right"><a href="?language=en">English</a>|<a href="?language=ar">Arabic</a></div>
		<div class="header">
			<ul class="nav nav-pills pull-right">
				 <li><a href="<spring:url value="/userDashBoard/addItem"/>">add Item</a></li>
                  <li><a href="<spring:url value="/userDashBoard/myItems"/>">my Menu </a></li>
                 <li><a href="<spring:url value="/userDashBoard/items"/>">Items</a></li>
                 <li><a href="<spring:url value="/userDashBoard/buyitems"/>">Buying History</a></li>
               
			</ul>
			<h3 class="text-muted">Olaf Ecommerce</h3>
		</div>


		<div class="jumbotron">
			<h1>
		Hi <security:authentication property="name"/> Enjoy in Shopping
				</h1>
			<p>
			User Page
			</p>
		</div>

		<div class="row">
		
		</div>

		<div class="footer">
			</div>

	</div>
</body>
</html>