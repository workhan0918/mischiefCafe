<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 수정</title>
<link rel="stylesheet" href="../resources/css/start.css">
</head>
<body>
<div id=wrap>
<a style="left: 0; margin-top: 320px;" href="../admin" class="back">뒤로가기</a>
<form action="updateMenu" method="post" enctype="multipart/form-data">
	메뉴 이름 : <input type="text" maxlength="20" name="name" value="${foods.name }" class="input_box"><br>
	가격 : <input type="text" maxlength="6" name="price" oninput="onlyNumber(this)" value="${foods.price }" class="input_box">원<br>
	메뉴 카테고리 : <select name="category" class="category">
					<option value="unknown" selected disabled>카테고리 선택</option>
					<c:forEach var = "item" items="${cateList }">
						<option value="${item.cateName }">${item.cateName }</option>
					</c:forEach>
					</select>
	<br>재고 : <input type="text" maxlength="7" name="stock" oninput="onlyNumber(this)" value="${foods.stock }" class="input_box">개
	<div>
	<img style="width: 300px; height: 300px; box-sizing:border-box;"
			src="../resources/img/${foods.imgUrl}.jpg"
			onerror="this.src = '../resources/img/default_img.jpg'">
	</div>
	<br>이미지 수정 <input class="input_box" type="file" name="file" onchange="readURL(this)" accept="image/jpeg, image/png, image/jpg">
	<br /><br />
	<img style="width: 300px; height: 300px;" id="preview" />
	<br><input type="submit" value="수정" class="SubmitBtn">
</form>
</div>
<script type="text/javascript">
const onlyNumber = (target) => {
    target.value = target.value
    .replace(/[^0-9]/g, '');
  }
function readURL(input) {
	const type = input.files[0].name.split('.');
	if(type[1] != "jpg" && type[1] != "png" &&  type[1] != "jpeg"){
		alert("이미지 파일은 (jpg, png, jpeg) 형식만 등록 가능합니다.");
		document.getElementById('preview').src = "";
		document.getElementById('img').value = null;
		return false;
	}
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('preview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('preview').src = "";
	  }
	}
</script>
</body>
</html>