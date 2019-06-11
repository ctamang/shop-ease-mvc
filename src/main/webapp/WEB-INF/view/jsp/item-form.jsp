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
			<h3>Add Item Page</h3>
			
			<form:form action="/item/${sellerId}/save" modelAttribute="item" method="POST">
			
			<table>
				<tbody>
					<tr>
						<td><label>Item Name:</label></td>
						<td><form:input path="itemName" /></td>
					</tr>
					<tr>
						<td><label>Item Description:</label></td>
						<td><form:input path="itemDescription" /></td>
					</tr>
					<tr>
						<td><label>Item Price:</label></td>
						<td><form:input path="itemPrice" /></td>
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