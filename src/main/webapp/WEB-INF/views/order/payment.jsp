<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
    <link rel="stylesheet" href="resources/css/start.css">
    <link rel="stylesheet" href="resources/css/main.css">
</head>
<body>
<div id="wrap">
<div style="margin-bottom: 30px;">
<c:forEach var="item" items="${list }">
	<p style="font-size: 42px; margin-bottom: 15px;">${item.name } ${item.count }개 ${item.price }원</p>
</c:forEach>
<p style="font-size: 42px; margin-top: 35px;">총 결제 금액 : ${sumPrice }원</p>
</div>
<button onclick="location.href='paymentSuccess'" style="width: 300px;
    height: 120px;
    border: none;
    margin-bottom: 30px;
    font-size: 42px;
    font-family: 'MapoGoldenPier';">결제하기</button>
</div>
</body>
</html>