<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="stylePetShop.css">
<style>
#gCardPrice{
font-size: 30px;
color: yellow;
font-weight: bold;
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
        
        <div><p id="gName">${good.title}</p></div>
        
   <div id="contentWind">        
        <table style="text-align: center;margin:0 auto" border="3" width="1300"><tr>
        <td><img width="400" src="images/${good.photo}"></td>
        <tr><td id="gInfo">${good.info}</td>
        </table>
        <div><p id="gCardPrice">Цена ${good.price} рублей</p></div>
        </div>
        
    </div>
</body>
</html>