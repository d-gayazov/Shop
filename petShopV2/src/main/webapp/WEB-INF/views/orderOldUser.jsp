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
#data, #answer{
font-size: 30px;
color: white;
}
</style>
<meta charset="UTF-8">
<title>Интернет-магазин зоотоваров "Пушистик"</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  function auth(){      
      var login = $("#login").val(); 
      var pass = $("#pass").val();
      var str = "login=" + login + "&pass=" + pass;       
      $.ajax({
        type: 'POST',
        url: 'Order',
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
		
    <div><p id="gName">Для оформления заказа авторизуйтесь/зарегистрируйтесь</p></div>
        
   <div id="contentWind">  
   	<div>
	<p id="data">Логин</p>
	<p><input id="login" type="text"></p>
	<p id="data">Пароль</p>
	<p><input id="pass" type="password"></p><br><br>
	<p id="answer"></p>
	<p><button onclick="auth()">Авторизоваться/зарегистрироваться</button></p>
	</div>	    	
    </div>        
    </div>
</body>
</html>