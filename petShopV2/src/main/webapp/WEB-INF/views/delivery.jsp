<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
</style>
<link rel="stylesheet" href="stylePetShop.css">
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
        
   <div id="contentWind">        
		<table border="1">
		<tr>
				<th>Доставка и оплата</th>
			</tr>
		<c:forEach var="shop" items="${shop}" varStatus="number">
			<tr>
				<td id="shopInfo">${shop.delivery}</td>
			</tr>
			</c:forEach>
		</table>
    </div>       
    </div>
</body>
</html>