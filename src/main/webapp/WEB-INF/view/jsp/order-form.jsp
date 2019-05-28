<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			<h3>Address Page</h3>
			
			<form:form action="/orders/${customerId}/save" modelAttribute="order" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Order Description</label></td>
						<td><form:input path="orderDescription" /></td>
					</tr>
					<tr>
						<td><label>Order Total</label></td>
						<td><form:input path="orderTotal" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Create Order" class="save"></td>
					</tr>
				</tbody>
			</table>
			</form:form>	
			<div style="clear; both;"> </div>
			
		</div>	
	</body>
		

</body>

</html>