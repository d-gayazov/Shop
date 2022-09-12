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
height: 1100px;
}
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
function reg(){      
    var surname = $("#surname").val(); 
    var name = $("#name").val();
    var patr = $("#patr").val();
    var phNum = $("#phNum").val();
    var login = $("#login").val();
    var passwrd = $("#passwrd").val();
    var str = "surname=" + surname + "&name=" + name + "&patr=" + patr + "&phNum=" + phNum + "&login=" + login + "&passwrd=" + passwrd;       
    $.ajax({
      type: 'POST',
      url: 'Registr',
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
		
    <div><p id="gName">Регистрация нового пользователя</p></div>
        
   <div id="contentWind">  
   	<div>
	<p id="data">Ваша фамилия</p>
	<p><input id="surname" type="text"></p>
	<p id="data">Ваше имя</p>
	<p><input id="name" type="text"></p>
	<p id="data">Ваше отчество</p>
	<p><input id="patr" type="text"></p>
	<p id="data">Ваш контактный телефон</p>
	<p><input id="phNum" type="text"></p>
	<p id="data">Придумайте логин</p>
	<p><input id="login" type="text"></p>
	<p id="data">Придумайте пароль</p>
	<p><input id="passwrd" type="text"></p><br><br>
	<p id="answer"></p>
	<p><button onclick="reg()">Зарегистрироваться</button></p>
	</div>	    	
    </div>        
    </div>
</body>
</html>