<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>order</title>
</head>
<body>

<br><br><br>
<center>
<h3>order list</h3>
<hr><p>

	<form action="delivery?command=success" method="post">
	
		<table border="1">
		
			<thead>
				<tr>
					<th colspan=3>[ 주문 정보 ]</th>
				</tr>
			</thead>
			
		 	<tbody>
			
			<c:forEach items="${requestScope.deliveryProjectInfo}" var="dataAll"> 
		 		<tr>
		 			<th>매장 이름</th>
			 		<td>
			 		${dataAll.diner_name}
		 			</td>
		 		</tr>
		 		<tr>
		 			<th >주문 일시</th>
		 			<td>${dataAll.reg_date}</td>
		 		</tr>
		 		<tr>
		 			<th>주문 내역</th>
		 			<td>${dataAll.menu_name} : ${dataAll.menu_price} 원</td>
		 		</tr>
		 		
		 	</c:forEach>
			</tbody>
		</table>
		
		<input type="submit" value="order">
	</form>
</body>
</html>