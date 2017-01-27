<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
.form-control
{

width: 300px
}
</style>
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
		     
			
	<form:form modelAttribute="item" action="addItem" method="POST">
	<c:set var="error"  value="${error}"/>
	       <c:if test="${error eq true}">
	
	         <p class="alert alert-danger">
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			</c:if>
			  <div class="form-group">
			    <label class="col-xs-3 control-label" for="name"><spring:message code="item.name" text="Item Name:"/></label>
				<form:input class="col-xs-9 form-control" path="name" id="name" tabindex="1" />
			<br>
			</div>
			 <br>
			
			   
			<div class="form-group">
		    <label class="col-xs-3 control-label" for="description"><spring:message code="item.description" text="Item Describtion:"/></label>
		    <form:textarea class="col-xs-9 form-control" path="description" rows="5" cols="30" />
			</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		
	
	         <div class="form-group" style="padding-top: 20px">
			    <label class="col-xs-3 control-label" for="categories"><spring:message code="item.categories" text="Item categories:"/></label>
			    <form:select cssStyle="width:300px;font-weight: bold;" path="categories" multiple="true" id="categories">
			     <form:option value="NONE"> --SELECT--</form:option>
			    <form:options items="${categories}" itemValue="id" itemLabel="name"></form:options>
              </form:select>
            
			</div>
			<br>
			
	   
	       <div class="form-group">
			    <label class="col-xs-3 control-label" for="initialPrice"><spring:message code="item.initialPrice" text="Item initial Price:"/></label>
				<form:input class="col-xs-9 form-control" path="initialPrice" id="initialPrice" tabindex="1" />
			</div>
		  <br>
		  <br>
		  
	       <div class="form-group">
			    <label class="col-xs-3 control-label" for="reservePrice"><spring:message code="item.reservePrice" text="Item reserve Price:"/></label>
				<form:input class="col-xs-9 form-control" path="reservePrice" id="reservePrice" tabindex="1" />
				</div>
				
				<br>
				<br>
			<div class="form-group">
			    <div class="col-xs-offset-3 col-xs-9">
				    <input style="width:100px" class="btn btn-primary" type="submit" id="addItem" value="addItem">
			    </div>
			</div>
<style type="text/css">
.form-control
{

width: 300px
}
</style>	
			
    </form:form>
		</div>

		<div class="footer">
			</div>

	</div>
</body>
</html>