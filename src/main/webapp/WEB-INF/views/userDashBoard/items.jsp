<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                 <li><a href="<spring:url value="/Items"/>">Items</a></li>
                 <li><a href="<spring:url value="/myItems"/>">my Items </a></li>
			</ul>
			<h3 class="text-muted">Olaf Ecommerce</h3>
		</div>


		<div class="jumbotron">
			<h1>
		Enjoy in Shopping
				</h1>
			<p>
			User Page
			</p>
		</div>

		<div class="row">
		<section>
 			<div id="prod" class="container"  >
   			     <div id="result" style="display:none" >
   		 </div>
			</div>
 	</section>	

 	<section class="container" >
 		<div>

			
			<table class="table table-hover">
				<tr>
					<th>---ID---</th>
					<th><spring:message code="item.table.itemname"/></th>
					<th><spring:message code="item.table.itemdescribtion"/></th>
					<th><spring:message code="item.table.created"/></th>
					<th><spring:message code="item.table.iteminitialprice"/></th>
					<th><spring:message code="item.table.itemreservedprice"/></th>
				</tr>
			</table>
	<table id="cart_table" class="table table-hover">
	
		<c:forEach  var="item" items ="${items}" >
				<tr>
					<td>${item.id}</td>
					<td>${item.description}</td>
					<td>${item.created}</td>
					<td>${item.initialPrice}</td>
					<td>${item.reservePrice}</td>
						<td>
				<a
									href=" <spring:url value="/userDashBoard/getItem?id=${item.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon glyphicon-ok" /></span> Details
								</a>	
					
				</td>
				</tr>
		</c:forEach>
  
				
			</table>
		</div>
		</section>
		
		</div>

		<div class="footer">
			</div>

	</div>
</body>
</html>
	