<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="resources/css/start.css">
    <title>관리자 페이지 </title>
  </head>
  <body>
    <div id="admin_wrap">
          <div class="btn_box">
        <a href="start" class="admin_btn">메인으로</a>
      </div>
      <div class="btn_box">
        <a href="admin/addCategory" class="admin_btn">카테고리 추가</a>
      </div>
      <div class="btn_box">
        <a href="admin/addMenu" class="admin_btn">메뉴 추가</a>
      </div>
    </div>
  </body>
</html>