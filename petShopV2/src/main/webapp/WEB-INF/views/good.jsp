<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="stylePetShop.css">
<style>
#contentWind{
background-color:steelblue;
height: 1400px;
}
</style>
<meta charset="UTF-8">
<title>Интернет-магазин зоотоваров "Пушистик"</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function add(id) {
		 var str = "id="+id;
	      $.ajax({
	        type: 'POST',
	        url: 'Catalog',
	        data: str,
	        success: function(data_answer){
	          $("h3").html(data_answer);
	        }
	    });
	}
</script>
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
        <button id="crtTab"><a href="Catalog">Вернуться назад</a></button>
        <button id="crtTab"><a href="?action=cart">&#128722; Корзина товаров</a></button>
		
		<h3></h3>
		</div>
   <div id="contentWind">         
        <c:forEach var="good" items="${goods}" varStatus="num">        
        <p id="contentGood">
        <figure>
        <a href="?action=card&id=${good.id}"><img width="200" src="images/${good.photo }"></a>
        <figcaption>${good.title} <span id="gPrice">${good.price} руб.</span>
        </figcaption>
        <div id="butAdd"><button onclick="add(${good.id})">&#128722;</button></div>        
        </figure></p>        
        </c:forEach>        
        
        </div>
        
    </div>
</body>
</html>