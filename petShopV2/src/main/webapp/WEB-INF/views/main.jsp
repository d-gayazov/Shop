<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function find(){      
    var searchField = $("#searchField").val(); 
    var str = "searchField=" + searchField;       
    $.ajax({
      type: 'POST',
      url: 'Search',
      data: str,
      success: function(data_answer){
      	$("#answer").html(data_answer);
      }
  });
}

function add(id) {
	 var str = "id="+id;
     $.ajax({
       type: 'POST',
       url: 'Catalog',
       data: str,
       success: function(data_answer){
         $("#answer").html(data_answer);
       }
   });
}
</script>
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
        
        <div id="navigate">
            <input type="search" id="searchField" placeholder="Поиск">
            <button id="crtTab" onclick="find()">Поиск</button>
            <button id="crtTab" style="margin-left: 550px;"><a href="?action=cart">&#128722; Корзина товаров</a></button>
        	<button id="crtTab"><a href="?action=forAdmin">Вход для админа</a></button>
        </div>
        
        <div id="left">
            <div id="catalogue">
                <p>Каталог товаров</p>
                <ul>
                    <li><a class="goods" href="?action=good&id=1">Корм для животных</a></li><br>
                    <li><a class="goods" href="?action=good&id=2">Товары для груминга</a></li><br>
                    <li><a class="goods" href="?action=good&id=3">Товары для гигиены</a></li><br>
                    <li><a class="goods" href="?action=good&id=4">Игрушки для животных</a></li><br>
                    <li><a class="goods" href="?action=good&id=5">Товары для прогулки</a></li>
                </ul>
            </div>
        </div>
        
        <div id="content">
            <h3 id="answer"></h3>
            <h2>Товары по акции</h2>
            <c:forEach var="good" items="${goods}" varStatus="num">        
	        <p id="contentGood">
	        <figure>
	        <a href="?action=card&id=${good.id}"><img width="200" src="images/${good.photo }"></a>
	        <figcaption>${good.title}
	        </figcaption>
	        <div id="butAdd"><button onclick="add(${good.id})">&#128722;</button></div>        
	        </figure></p>        
	        </c:forEach>    
            </div>

        <div class="clear"></div>

        <div id="footer">
            <h3>
                <a class="info" href="?action=aboutUs">О магазине</a>
                <a class="info" href="?action=ourContacts">Наши контакты</a>
                <a class="info" href="?action=delivery">Доставка и оплата</a>
                <a class="info" href="?action=returnGood">Возврат товара</a>
            </h3>
        </div>
        
        
        </div>
</body>
</html>