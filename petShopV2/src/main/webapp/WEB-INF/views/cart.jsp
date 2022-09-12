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
		
    <div><p id="gName">Корзина товаров</p></div>
        
   <div id="contentWind">        
		<table border="1">
		<tr>
				<th>№ п/п</th>
				<th>Название товара</th>
				<th>Стоимость товара</th>
				<th>Количество</th>
				<th>Итого</th>
				<th> </th>
			</tr>
		<c:forEach var="cart" items="${cart}" varStatus="number">
			<tr>
				<td>${number.count}</td>
				<td style="text-align: left;">${cart.title}</td>
				<td>${cart.price}</td>
				<td>${cart.count}</td>
				<td>${Integer.parseInt(cart.price) * Integer.parseInt(cart.count)}</td>
				<td><a href="?action=delFromCart&id=${cart.id}">Удалить из корзины</a></td>
			</tr>
			</c:forEach>
		</table>
		<table id="btnDel">
		<td></td>
		<td style="text-align: right;"><button style="background: yellow; font-size: 20px;"><a href="?action=delCart">Очистить корзину</a></button></td>
		</table>
		 <div style="text-align: center;">
        <button id="order"><a href="?action=order">Оформить заказ</a></button>
        </div>
    </div>       
    </div>
</body>
</html>