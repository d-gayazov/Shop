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
	function authAdm() {
	      var loginAdm = $("#loginAdm").val(); 
	      var passAdm = $("#passAdm").val();
	      var str = "loginAdm=" + loginAdm + "&passAdm=" + passAdm;       
	      $.ajax({
	        type: 'POST',
	        url: 'Admin',
	        data: str,
	        success: function(data_answer){
	        	$("#answer").html(data_answer);
	        }
	    });
	}
	
	function showOrders() {
	      var str = "action=showOrders";       
	      $.ajax({
	        type: 'POST',
	        url: 'OrdersForAdmin',
	        data: str,
	        success: function(data_answer){
	        	$("#answer").html(data_answer);
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
        <button id="crtTab"><a href="Catalog">Вернуться на главную страницу</a></button>		
		</div>
		<div><p id="gName">Введите логин и пароль администратора</p></div>
		
   <div id="contentWind">         
     	<div>
		<p id="data">Логин</p>
		<p><input id="loginAdm" type="text"></p>
		<p id="data">Пароль</p>
		<p><input id="passAdm" type="password"></p><br><br>		
		<p><button onclick="authAdm()">Авторизоваться</button></p><br>
		<p id="answer"></p>
		</div>       
        
        </div>
        
    </div>
</body>
</html>