<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<% String url = application.getContextPath() + "/"; %>

<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인기 맛집</title>
</head>
<body>

<br><br><br>
<center>
<h3>인기 맛집 list</h3>
<hr><p>

<form action="dinerinfo" method="get">

<table border="1">
	<thead>
		<tr>
			<th>가게 이름</th><th>메뉴</th>
		</tr>
	</thead>

</body>
</html>