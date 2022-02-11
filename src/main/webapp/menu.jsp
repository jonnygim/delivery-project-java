<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
</head>
<body>

<br><br><br>
<center>
<h3>menu list</h3>
<hr><p>

	<form action="order" method="get">
	
		<table border="1">
		
			<thead>
				<tr>
					<th>메뉴 이름</th><th>가격</th>
				</tr>
			</thead>
			<c:forEach items="${requestScope.menuInfo}" var="dataAll"> 
		 		<tr>
			 		<td>
			 		<a href='delivery?command=menuInfo&diner_id=${dataAll.diner_id}'>${dataAll.menu_name}</a>
			 		</td>
		 		
			 		<td>
			 		${dataAll.menu_price}
			 		</td>
		 		</tr>
		 	</c:forEach> 
		 	
		</table>
	</form>
</body>
</html>