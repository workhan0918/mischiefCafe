<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>메뉴 선택</title>
    <link rel="stylesheet" href="resources/css/start.css">
    <link rel="stylesheet" href="resources/css/main.css">
  </head>
  <body>
    <div id="wrap">
      <a href="start" style="left: 30px; background: #99A799;">처음으로</a>
      <div class="content" style="background: none;">
          <c:forEach var="category" items="${categorys }">
          	<form method="get" action="orderMenu">
          	<div class="inner"><input style="width:300px; height: 300px; border:none; border-radius: 50%; font-size: 42px; font-family: 'MapoGoldenPier';" type="submit" value="${category.cateName }" name="cateName"></div>
          	</form>
          </c:forEach>
      </div>
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
      <div>
      	<button onclick="location.href='payment'" 
    style="width: 300px;
    height: 120px;
    border: none;
    margin-bottom: 30px;
    font-size: 42px;
    font-family: 'MapoGoldenPier';">결제하기</button>
      </div>
      <footer id="footer">
        <span>design By hantaewoo</span>
      </footer>
    </div>
  </body>
</html>
