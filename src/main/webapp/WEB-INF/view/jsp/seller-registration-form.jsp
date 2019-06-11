<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
	<head>
		<title>Login</title>
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
			
			<form:form action="/seller/save" modelAttribute="seller" method="POST">
			
			<!-- need to associate this data with itemId -->
			<form:hidden path="sellerId"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Office Name:</label></td>
						<td><form:input path="sellerOfficeName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" /></td>
					</tr>
					<tr>
						<td><label>Contact Number:</label></td>
						<td><form:input path="contactNumber" /></td>
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