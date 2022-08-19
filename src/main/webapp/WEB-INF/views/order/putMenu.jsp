<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>메뉴 확인</title>
    <link rel="stylesheet" href="resources/css/start.css">
    <link rel="stylesheet" href="resources/css/main.css">
  </head>
<body>
   <div id="wrap">
    <h1 style="position: relative; top: 455px;">주문 확인</h1>
      <div class="content" style="justify-content: center; background: #99A799;">
      	<form action="cart" method="post">
        <div class="inner" style="flex-direction: column; margin: 15px; height:355px;">
      	<img style="width: 300px; height: 300px;"
      			src="../cafe/resources/img/${menu.imgUrl}.jpg"
      			onerror="this.src = '../cafe/resources/img/default_img.jpg'">
      	<p style="font-size: 22px;">${menu.name}</p>
      	<p style="font-size: 22px;">${menu.price }원</p>
      	<input type="text" style="display:none;" value="${menu.name }"  name="name">
      	<input type="text" style="display:none;" value="${menu.price }"  name="price">
      	</div>
      	<div class="inner">
      	<span style="font-size: 32px; ">수량 : </span> <input type="number" name="count" value=1 style="margin-left: 20px;
    padding: 5px;
    outline: none;
    border: none;
    width: 25px;
    text-align: center;
    align-items: center;">
      	</div>
      	<input style="width: 300px; height: 200px; outline:none; font-size: 22px; width: 300px;
    height: 120px;
    border: none;
    margin-bottom: 30px;
    font-size: 42px;
    font-family: 'MapoGoldenPier';" type="submit" value="담기">
      	</form>
      	</div>
      	<button onclick="javascript:history.back();" style= "width: 300px;
    height: 120px;
    border: none;
    margin-bottom: 30px;
    font-size: 42px;
    font-family: 'MapoGoldenPier';">뒤로가기</button>
      <div class="cart" style="    overflow-y: scroll;
    margin-bottom: 30px;">
        <c:forEach var="item" items="${list }">
	        <div style="width: 300px; background: #99A799; height: 30px; margin-bottom: 15px; text-align: center; align-items: center; line-height: 32px; color: white; font-size: 22px;">
	         <span>${item.name }</span>
	         <span>${item.count }개</span>
	         <span>${item.price }원</span>
	        </div>
        </c:forEach>
      </div>
      <footer id="footer">
        <span>design By hantaewoo</span>
      </footer>
      </div>
</body>
</html>