<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE>
<html>
	<head>
		<title>Login</title>
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
<body>

		<body>
		<div id="wrapper">
			<div id="header">
				<h2>Shop Ease</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Registration Page</h3>
			Hello: <b> ${customer.firstName} ${customer.lastName}</b> 
			<div style="clear; both;"> </div>
				<c:if test="${customer.address != null}">
					<c:set var="evenCount" value="${1}"/> 
					<c:forEach var="item" items="${customer.address}" >
					<b>Address${evenCount}</b> 
							&emsp;<br>${item.line1}, 
							${item.line2}, 
							${item.city}, 
							${item.state}s<br>
					<c:set var="evenCount" value="${evenCount+1}" />
					</c:forEach>
				</c:if>
				
				<c:if test="${customer.order != null}">
					<c:set var="evenCount" value="${1}"/> 
					<c:forEach var="item" items="${customer.order}" >
					<b>order${evenCount}</b> 
							&emsp;<br>${item.orderDescription}, 
							${item.orderTotal}, 
							<br>
					<c:set var="evenCount" value="${evenCount+1}" />
					</c:forEach>
				</c:if>
				<a href="${pageContext.request.contextPath}/customers/${customer.customerId}/addAddress">
				<input type="button" value="Add Address"/></a>	
				<br><br>
				<a href="${pageContext.request.contextPath}/customers/${customer.customerId}/createOrder">
				<input type="button" value="order"/></a>	
		</div>	
	</body>
		

</body>

</html>