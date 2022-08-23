# mischiefCafe

자주 가던 카페의 키오스크 기기를 보고 '이건 어떻게 만들었을까?'라는 호기심에 개발하게된 개인 프로젝트입니다.
# Description

* 개발 기간 : 2022.08.02 ~ 2022.08.10

* 개발 인원 : 1명 (개인)

* 사용 기술

   * Html5, CSS3, JavaScript
   * Java 11
   * JSP / JSTL
   * Java Spring 3.9
   * MVC Pattern
   * Apache Tomcat 8.5
   * MySQL DataBase 8.0.29
 
# 구현 내용

  * 카테고리
    * [카테고리 추가](#카테고리-추가)
    * 카테고리 조회
    * [카테고리 삭제](#카테고리-삭제)
    * [카테고리 유효성 검사](#카테고리-유효성-검사)

  * 메뉴
  
    * [메뉴추가](#메뉴-추가) / 추가시 이미지 업로드 기능
    * [메뉴조회](#메뉴-조회)
    * [메뉴수정](#메뉴-수정) / 이미지 수정시 전에 올렸던 이미지 경로에서 삭제
    * [메뉴삭제](#메뉴-삭제) / 메뉴 다중 삭제 가능
  
 * 주문
 
    * 메뉴 선택시 장바구니에 저장
    * 결제
    
# Views
메인 화면


![image](https://user-images.githubusercontent.com/100820039/186041987-498bfad1-823f-4b98-9050-11fa79807199.png)


관리자 페이지 선택시 관리자 페이지로 이동 후 카테고리 추가, 메뉴추가 선택 가능


![image](https://user-images.githubusercontent.com/100820039/186042020-0be2b5ee-8db4-4337-9a1e-f32c53d29753.png)

# 카테고리 추가

카테고리 추가 페이지 화면


![image](https://user-images.githubusercontent.com/100820039/186042761-3612bd47-f5e8-4c59-a975-163765c612e6.png)

카테고리 추가


![image](https://user-images.githubusercontent.com/100820039/186043023-40da9cad-3464-4993-a334-ac1c6f53c6dd.png)
![image](https://user-images.githubusercontent.com/100820039/186043122-c8f2af5c-a1dd-477d-b963-8fde1f8e6194.png)
![image](https://user-images.githubusercontent.com/100820039/186043169-2b0b3c38-72a9-4df6-867e-5bb4ee6bf21f.png)

# 카테고리 삭제

![image](https://user-images.githubusercontent.com/100820039/186043268-632b38f5-28a5-4db5-abbe-c37252f705c4.png)
![image](https://user-images.githubusercontent.com/100820039/186043315-879b4f0b-f059-4ed0-9c28-a70f6eed6007.png)
![image](https://user-images.githubusercontent.com/100820039/186043333-c68dd728-8764-4818-807a-846c6e84d62d.png)


# 카테고리 유효성 검사

  * 중복된 카테고리 추가 시도시 경고창 발생
  
  
   ![image](https://user-images.githubusercontent.com/100820039/186042830-e7a19ae6-5fa2-4327-ad32-85dd139723ca.png)
   ![image](https://user-images.githubusercontent.com/100820039/186042963-2bc2c64c-7566-4dea-b765-2b55bb90b8f4.png)
  
  
  * 추가한 카테고리에 포함된 메뉴가 생성되어 있는데 카테고리 삭제 시도 시 경고창 발생
  
  
  ![image](https://user-images.githubusercontent.com/100820039/186043492-a4970424-fde8-4fe2-8317-a4e9af6167be.png)
  ![image](https://user-images.githubusercontent.com/100820039/186043529-85d4e1fe-d13d-4fa7-9819-cdd6faffef54.png)
  ![image](https://user-images.githubusercontent.com/100820039/186043534-e60f6a2e-182d-4ab5-b1c6-59a87d273601.png)
  
  
  * 카테고리 추가 할 때 빈값으로 추가 시도시 경고창 발생
  
  ![image](https://user-images.githubusercontent.com/100820039/186044588-21618508-5d38-40e6-bd50-1da1bdc9f64e.png)



 # 메뉴 추가
 
 
* 메뉴 추가 페이지 화면


![image](https://user-images.githubusercontent.com/100820039/186043830-4947980c-7655-4381-bfe0-1e1d116bb1bb.png)
 
 메뉴 추가시 현재 추가된 카테고리 목록을 select box 로 사용자에게 보여주어 카테고리 선택을 편하게 하도록 구현하였습니다.
 
 ![image](https://user-images.githubusercontent.com/100820039/186044359-6b3b69b8-d181-4365-a430-9d0956c9f116.png)
 
 메뉴 사진 추가시 자바스크립트를 활용하여 미리보기 기능을 구현하였습니다.
 
 
 ![image](https://user-images.githubusercontent.com/100820039/186046393-499108f9-a777-4a6b-8289-76fb2b471515.png)
 
 활용된 JavaScript Code
 
 ``` JavaScript Codes
 if (input.files && input.files[0]) {
		    var reader = new FileReader();
		    reader.onload = function(e) {
		      document.getElementById('preview').src = e.target.result;
		    };
		    reader.readAsDataURL(input.files[0]);
		  } else {
		    document.getElementById('preview').src = "";
 ```
 
 메뉴 이미지 업로드시 원래 이미지의 이름을 랜덤으로 부여후에 지정된 경로로 사진이 업로드 됩니다.
 
 ![image](https://user-images.githubusercontent.com/100820039/186047728-3ba5546e-4363-4013-8d68-e931d0e5a7fd.png)
 
 또한 이미지를 업로드하지 않을시에 미리 설정해둔 default 이미지로 대체됩니다.
 
 ![image](https://user-images.githubusercontent.com/100820039/186048897-bbc72ad2-0057-4858-a173-1a76096cd4c2.png)

 
 이미지 업로드에 사용됐던 코드입니다.
 
 ```Java
 category.setCateName(request.getParameter("category"));
		food.setCategory(category);
		food.setStock(Integer.parseInt(request.getParameter("stock")));
		
		String fileRealName = file.getOriginalFilename(); // 실제 파일 명을 알수있는 메소드
		long size = file.getSize(); // 파일 사이즈
		
		// 사용자가 이미지를 업로드 하지 않았을 경우 예외 처리
		if (fileRealName == null || fileRealName.length() == 0) {
			food.setImgUrl("default_img");
			service.addMenu(food);
			
			model.addAttribute("msg", "메뉴 추가를 완료 했습니다.");
			model.addAttribute("url", "addMenu");
			
			return "alert/alert_and_page";
			
		}
		
		System.out.println("파일명 : " + fileRealName);
		System.out.println("용량 크기(byte) : " + size);

		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uploadFolder = "C:\\Hbackend\\eclipse-workspace\\mischiefCafe\\src\\main\\webapp\\resources\\img";
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유 문자열 : " + uniqueName );
		System.out.println("확장자명 : " + fileExtension);
		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
		File saveFile = new File(uploadFolder + "\\" + uniqueName + fileExtension); // 적용 후
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메소드( filewriter 작업을 손쉽게 한방에 처리해준다. )
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		food.setImgUrl(uniqueName);
 ```

 
 
 메뉴 추가 완료시 알림창
 
 
 ![image](https://user-images.githubusercontent.com/100820039/186046950-f715bcb6-3952-4154-83e9-4e55f630064e.png)




# 메뉴 조회

메뉴 추가페이지 밑쪽에서 카테고리별로 추가된 메뉴를 조회 할 수 있습니다.

![image](https://user-images.githubusercontent.com/100820039/186047058-7d6a3af7-bcf0-4409-a9d1-0fba95ac0e53.png)


케이크를 선택 후 조회한 모습

![image](https://user-images.githubusercontent.com/100820039/186048277-4d236677-9b21-4204-a278-1bc0e48494c3.png)

# 메뉴 수정 
   
오른쪽에 수정버튼을 눌러 메뉴를 수정 할 수 있습니다.

![image](https://user-images.githubusercontent.com/100820039/186048951-7ee5ed70-e714-4843-8163-9d8a8277e537.png)

메뉴 이름, 가격, 카테고리, 재고, 이미지 모든 정보를 수정 할 수 있습니다.

메뉴를 당근케이크로 변경해보겠습니다.

![image](https://user-images.githubusercontent.com/100820039/186049164-506fad94-c8ec-468f-a75a-9ca4b7575307.png)

![image](https://user-images.githubusercontent.com/100820039/186049218-f7134cb3-a6e6-451e-b588-29fc2d11a27d.png)

성공적으로 메뉴가 변경된 모습

![image](https://user-images.githubusercontent.com/100820039/186049294-c1a08978-b005-4ef4-8e1a-7de5dd1c9972.png)

메뉴 이미지 수정시 수정 전의 이미지가 서버에서 삭제 될 수 있도록 구현했습니다.
사용자가 이미지 수정을 하지 않거나, 이미지 값이 default값일 경우 수정을 하더라도 이미지를 삭제하지 않도록 조건을 주었습니다.

구현 코드
```Java
	// 개별 메뉴 수정
	public boolean updateMenu(FoodsCommand foods, FoodsCommand sessionFoodId) {
		String sql = "UPDATE Menu SET name=?, price=?, category=?, stock=?, imgUrl=? "
				+ " WHERE name=?";
		jdbcTemplate.update(sql, foods.getName(), foods.getPrice(), foods.getCategory(), 
				foods.getStock(), foods.getImgUrl(), sessionFoodId.getName());
		
		File file = new File("C:\\Hbackend\\eclipse-workspace\\mischiefCafe\\src\\main\\webapp\\resources\\img\\" + sessionFoodId.getImgUrl() + ".jpg");
		if(!sessionFoodId.getImgUrl().equals("default_img") && foods.getImgUrl() != sessionFoodId.getImgUrl()) {
			file.delete();
		}
		return true;
	}
```

이전 이미지가 삭제된 모습

![image](https://user-images.githubusercontent.com/100820039/186050222-86c339bb-a5eb-4583-a575-201a8ea38775.png)

# 메뉴 삭제

메뉴 조회 화면에서 체크박스를 체크 후 삭제 버튼을 누르면 메뉴가 삭제되게 구현했습니다.

![image](https://user-images.githubusercontent.com/100820039/186056027-308d403d-6351-4e55-974a-68bca43e58c6.png)




