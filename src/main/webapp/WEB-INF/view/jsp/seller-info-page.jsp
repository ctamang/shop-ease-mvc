<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE>
<html>
	<head>
	<title>Login</title>
		<!-- <script>
			$("#search").click(function() {
				var roll_no = $('#roll_no').val();
				city_name.value = city_name;
				$.ajax({
					url : "fetch.jsp",
					type : 'POST',
					data : {
						roll_no : roll_no
					},
					success : function(data) {
						$('#city_name').val(data);
						alert(data);
						var city_name = data;
					}
				});
			});
		</script> -->
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
			Hello: <b> ${seller.firstName} ${seller.lastName}</b> 
			<div style="clear; both;"> </div>
			<c:if test="${seller.address != null}">
					<b>Address : </b> 
							<br>
							${seller.address.line1}, 
							${seller.address.line2}, 
							${seller.address.city}, 
							${seller.address.state}
							<br>
				</c:if>
			<c:if test="${seller.address == null}">
				<a href="${pageContext.request.contextPath}/seller/${seller.sellerId}/showSellerAddressRegistrationPage">
				<input type="button" value="Add Address"/></a>	
			</c:if>
			<br><br>
			<c:if test="${seller.item != null}">
			
					<input type="text" id="searchTextItemName">
					<a href="${pageContext.request.contextPath}/item/${seller.sellerId}/${document.getElementById('searchTextItemName')}">
					<input type="button" value="search"/></a>	
			
					<c:set var="evenCount" value="${1}"/> 
					<c:forEach var="item" items="${seller.item}" >
					<b>Item${evenCount}</b> 
							&emsp;<br>${item.itemId}, 
							${item.itemName}, 
							${item.itemDescription}, 
							${item.itemPrice}s<br>
					<c:set var="evenCount" value="${evenCount+1}" />
					</c:forEach>
				</c:if>
			<a href="${pageContext.request.contextPath}/item/${seller.sellerId}/showAddItemsPage">
			<input type="button" value="Add Item"/></a>	
		</div>	
	</body>
		

</body>

</html>