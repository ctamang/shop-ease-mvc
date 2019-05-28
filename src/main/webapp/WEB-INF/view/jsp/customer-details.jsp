<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Customer Information Page</title>
</head>
<body>

	Customer Name : ${customer.firstName} ${custome.lastName}
	<br>
	Age : ${user.age}
	<br>
	Email Id : ${user.email}
	<br>
	Phone Number : ${user.contactNumber}
	<br>
</body>
</html>