<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 추가</title>
<link rel="stylesheet" href="../resources/css/start.css">
</head>
  <body>
    <div id="wrap">
      <a style="left: 0; margin-top: 320px;" href="../admin" class="back">뒤로가기</a>
      <form action="addMenu" method="post" enctype="multipart/form-data">
      	<div >메뉴 이름 : <input type="text" maxlength="20" name="name" class="input_box"></div>
      	<div style="margin-left: 37px;">가격 : <input type="text" maxlength="6" name="price" oninput="onlyNumber(this)" class="input_box">원</div>
      	<div style="margin-left: -33px">메뉴 카테고리 : <select name="category" class="category">
      					<option value="unknown" selected disabled>메뉴 선택</option>
      					<c:forEach var = "item" items="${categoryList }">
      						<option value="${item.cateName }">${item.cateName }</option>
      					</c:forEach>
      					</select></div>
      	<div>초기 재고 : <input type="text" maxlength="7" name="stock" oninput="onlyNumber(this)" class="input_box">개</div>
      	<div>이미지 추가 <input style="width: 250px;"class="input_box" id="img" type="file" name="file" onchange="readURL(this)" accept="image/jpeg, image/png, image/jpg"></div>
        <br /><br />
        <p>미리보기</p>
      	<img style="width: 300px; height: 300px;" id="preview" />
      	<br><input type="submit" value="추가하기" class="SubmitBtn">
      </form>
      <h1 style="margin: 15px 0 15px 0">현재 메뉴 목록</h1>
      <form action="addMenu" method="get" name="getMenu" class="addCategoryForm">
      		<c:if test="${categoryName == null }">
      		<span style="font-size: 32px; position: realative; top: -3px">메뉴 카테고리  : </span><select style="height: 40px; font-size: 30px;" name="cateName" onchange="select()">
      					<option value="unknown" selected disabled>카테고리 선택</option>
      					<c:forEach var = "item" items="${cateList }">
      						<option value="${item.cateName }">${item.cateName }</option>
      					</c:forEach>
      					</select>
      		</c:if>
      		<c:if test="${categoryName != null }">
      		<span style="font-size: 32px; position: realative; top: -3px">메뉴 카테고리  : </span><select style="height: 40px; font-size: 30px;" name="cateName" onchange="select()">
      					<option value="unknown" disabled>카테고리 선택</option>
      					<option selected value=${categoryName }>${categoryName }</option>
      					<c:forEach var = "item" items="${cateList }" >
      						<option value="${item.cateName }">${item.cateName }</option>
      					</c:forEach>
      					</select>
      		</c:if>
      </form>
      <form action="deleteMenu" method="post">
      <table>
      <c:if test="${foodList != '[]' }">
      <h1 style="margin-bottom: 20px;">${foodList[0].category }</h1>
      <tr>
      <th>이미지</th>
      <th>메뉴 이름</th>
      <th>가격</th>
      <th>재고</th>
      <th>카테고리</th>
      <th>삭제</th>
      </tr>
      </c:if>
      <c:forEach var="item" items="${foodList }">
      	<tr>
      	<td><img style="width: 100px; height: 100px; box-sizing:border-box;"
      			src="../resources/img/${item.imgUrl}.jpg"
      			onerror="this.src = '../resources/img/default_img.jpg'"></td>
      	<td><label for="${item.name}">${item.name }</label></td>
      	<td><label for="${item.name}">${item.price }원</label></td>
      	<td><label for="${item.name}">${item.stock }</label></td>
      	<td><label for="${item.name}">${item.category }</label></td>
      	<td><input type="checkbox" name="check" value="${item.name }" id="${item.name }" style="width: 30px; height: 30px;"></td>
      	<td><button type="button" onclick="window.location.href='updateMenu?name=${item.name}&price=${item.price }&stock=${item.stock }&category=${item.category }&imgUrl=${item.imgUrl}'" class="SubmitBtn"  style="height: 107.98px;">수정</button>
      	</tr>
      </c:forEach>
      </table>
      <c:choose>
      	<c:when test="${foodList != '[]'}"><input style="margin-top: 20px; margin-bottom: 20px;" type="submit" value="삭제" class="SubmitBtn"></c:when>
      	<c:when test="${foodList == '[]'}"><div><h1 style="margin-top: 20px; margin-bottom: 20px;">조회된 메뉴가 없습니다.</h1></div></c:when>
      </c:choose>
      </form>
    </div>
<script type="text/javascript">
	function select() {
		document.getMenu.submit();
	};

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