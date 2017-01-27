<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">
<style type="text/css">@import url("<spring:url value="/css/style.css"/>");</style>
</head>
<body>
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
		
		
			<div class="col-md-5">
				<h3>${item.name}</h3>
				
				<p>
					<strong><spring:message code="item.description" text="Item Describtion"/></strong>
						 	<ul class="list-group">
  <li class="list-group-item">
     ${item.description}
  </li>
</ul>
			
				<p>
					<strong><spring:message code="item.initialPrice" text="Item initialPrice"/></strong>
					<h4><span class="label label-success"> ${item.initialPrice}</span></h4>
				</p>
		        <p>
					<strong><spring:message code="item.reservePrice" text="Item reservePrice"/></strong> 
					<h4><span class="label label-success"> ${item.reservePrice}</span></h4>
				</p>
				
				
				
		</div>
		<div class="col-md-5">
		<c:forEach items="${comments}" var="comment">
	 	<ul class="list-group">
  <li class="list-group-item">
  <button class="btn btn-primary" type="button">
  review  <span class="badge">${comment.review}</span>
</button>
<br>
<br>
     ${comment.describtion}
     <br>
     ${comment.created }
  </li>
</ul>
			</c:forEach>
		<br>
		<form:form commandName="newcomment"   method="post" >
		<c:set var="error"  value="${error}"/>
	       <c:if test="${error eq true}">
	
	         <p class="alert alert-danger">
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			</c:if>
		 <input type="text" name="itemid" value="${item.id}" disabled="disabled"/>
				<div class="form-group">
		    <label class="col-xs-3 control-label" for="describtion"><spring:message code="comment.description" text="Comment Describtion:"/></label>
		    <form:textarea class="col-xs-9 form-control" path="describtion" rows="5" cols="30" />
			</div>
		
			 <div class="form-group">
			    <label class="col-xs-3 control-label" for="review"><spring:message code="item.reservePrice" text="Comment review:"/></label>
				<form:input class="col-xs-9 form-control" path="review" id="review" tabindex="1" />
				</div>
			
			
				<div class="form-group">
			    <div class="col-xs-offset-3 col-xs-9">
			    <br>
				    <input style="width:100px" class="btn btn-info" type="submit" id="Send" value="Send">
			    </div>
			</div>
</form:form>
	    </div>

		<div class="footer">
			</div>
</div>
	</div>
</body>
</html>