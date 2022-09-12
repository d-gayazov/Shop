<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="stylePetShop.css">
<style>
table{
		margin: 0 auto;
		width:100%;
		background: white;
		font-size: 20px;
	}
</style>
<meta charset="UTF-8">
<title>Интернет-магазин зоотоваров "Пушистик"</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<div id="container">
	<div id="header">
            <h1>Интернет-магазин зоотоваров "Пушистик"</h1>
        </div>
	
	<div id="headImg">
            <img src="images/fonZ1.jpg" alt="" height="240" width="1500">
        </div>
    <div id="crt">        
     	<button id="crtTab"><a href="Catalog">Вернуться на главную страницу</a></button>
     	
	</div>			
    <div><p id="gName">Список новых заказов</p></div>
        
   <div id="contentWind">        
		<table border="1">
		<tr>
				<th>№ п/п</th>
				<th>Название товара</th>
				<th>Стоимость товара</th>
				<th>Количество</th>
				<th>Итого</th>
				<th>Фамилия</th>
				<th>Имя</th>
				<th>Отчество</th>
				<th>Номер телефона</th>
				<th>Статус</th>
			</tr>
		<c:forEach var="orders" items="${orders}" varStatus="number">
			<tr>
				<td>${number.count}</td>
				<td style="text-align: left;">${orders.title}</td>
				<td>${orders.price}</td>
				<td>${orders.count}</td>
				<td>${Integer.parseInt(orders.price) * Integer.parseInt(orders.count)}</td>
				<td>${orders.surname}</td>
				<td>${orders.name}</td>
				<td>${orders.patronymic}</td>
				<td>${orders.phone}</td>
				<td><a href="?action=done&id=${orders.id}">Обработан</a></td>
			</tr>
			</c:forEach>
		</table>
		
    </div>       
    </div>
</body>
</html>