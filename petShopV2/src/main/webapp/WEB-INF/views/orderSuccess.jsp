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
		
    <div><p id="gName">Здравствуйте, ${user.name} ${user.patronymic}!</p></div>

   <div id="contentWind">  
        <div>

	</div>     	
    </div>       
    </div>
</body>
</html>