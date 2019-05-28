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
			
			<form:form action="/addresses/${address.customer.customerId}/save" modelAttribute="address" method="POST">
			
			<table>
				<tbody>
					<tr>
						<td><label>Address Line1:</label></td>
						<td><form:input path="line1" /></td>
					</tr>
					<tr>
						<td><label>Address Line2:</label></td>
						<td><form:input path="line2" /></td>
					</tr>
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city" /></td>
					</tr>
					<tr>
						<td><label>State:</label></td>
						<td><form:input path="state" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save"></td>
					</tr>
				</tbody>
			</table>
			</form:form>	
			<div style="clear; both;"> </div>
			
		</div>	
	</body>
		

</body>

</html>