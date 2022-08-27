<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>카테고리 추가</title>
	<link rel="stylesheet" href="../resources/css/start.css">
</head>
  <body>
    <div id="wrap">
      <a href="../admin" class="back">뒤로가기</a>
      <h1 class="addCateTitle">카테고리 추가</h1>
      <p class="addCateSubTitle">현재 추가 되어있는 카테고리 목록</p>
      <form action="deleteCategory" class="addCategoryForm">
      <select name="cateName">
      <c:forEach var = "item" items="${cateList }">
        <option value="${item.cateName }">${item.cateName }</option>
      </c:forEach>
      </select>
      <input type="submit" value="삭제" class="SubmitBtn">
      </form>
      <form method="post" action="addCategory" class="addCategoryForm">
      <p class="addCateSubTitle red">중복된 카테고리는 추가 할 수 없으니 유의 해주세요.</p>
      <span>카테고리 이름 : </span><input type="text" name="cateName" maxlength="10" class="input_box">
      <input type="submit" value="추가" class="SubmitBtn">
      </form>
    </div>
  </body>
</html>