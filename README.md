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

  * 메뉴
  
    * [메뉴추가](#메뉴-추가) / 추가시 이미지 업로드 기능
    * [메뉴조회](#메뉴-조회)
    * [메뉴수정](#메뉴-수정) / 이미지 수정시 전에 올렸던 이미지 경로에서 삭제
    * [메뉴삭제](#메뉴-삭제) / 메뉴 다중 삭제 가능
  
 * 주문
 
    * [메뉴 선택시 장바구니에 저장](#주문)
    * 결제
    
 * [유효성 검사](#유효성-검사)
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

메뉴 이미지 수정시 수정 전의 이미지가 남아있는걸 확인하여 용량 확보를 위해 서버에서 삭제 될 수 있도록 구현했습니다.

사용자가 이미지 수정을 하지 않거나, 이미지 값이 default값일 경우 수정을 하더라도 이미지를 삭제하지 않도록 조건을 주었습니다.


>구현 코드
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

![image](https://user-images.githubusercontent.com/100820039/187025601-3f49e131-89d6-4b34-9229-d014de0eb1e2.png)

![image](https://user-images.githubusercontent.com/100820039/187025611-3312a2e4-9ea1-4ffa-8f3a-2694759b7080.png)


또한 여러개 삭제 하는 기능도 지원 합니다.

체크박스로 클릭한 value값을 list로 받아와 삭제할 수 있도록 구현하였습니다.



![image](https://user-images.githubusercontent.com/100820039/187031511-0b139dc0-59f1-4298-91ba-1469aa84fe0d.png)

![image](https://user-images.githubusercontent.com/100820039/187031526-8cec2ad7-af22-4731-91b2-022ce7d0944d.png)


![image](https://user-images.githubusercontent.com/100820039/187031542-2f4e53c3-5320-4c4c-97dc-4d1ffff6c58f.png)



삭제 기능 구현 코드 입니다.
```Java
	// Controller
	@PostMapping("admin/deleteMenu")
	public String deleteMenuForm(@RequestParam(required = false ,value = "check") ArrayList<String> names, 
			HttpServletRequest request, Model model) throws IOException {
		
		CafeService service = new CafeServiceImpl();
		
		// 삭제할 메뉴의 체크박스를 체크하지않고 삭제 버튼을 눌렀을 때
		if(names == null) {
			model.addAttribute("msg", "삭제할 메뉴를 선택해주세요");
			return "error/error";
		}
		
		for( String name : names) {
			service.deleteMenu(name, service.findImgUrlByName(name).getImgUrl());
		}
		model.addAttribute("msg", "삭제를 완료 했습니다.");
		model.addAttribute("url","addMenu");
		
		return "alert/alert_and_page";

	// Dao
	// 카테고리 삭제
	public boolean deleteCategory(String cateName) {
		String sql = "DELETE FROM Category cateName WHERE cateName = ?";
		try {
			jdbcTemplate.update(sql, cateName);			
		}catch (DataIntegrityViolationException e) {
			return false;
		}
		return true;
	}
```



# 유효성 검사

  * 중복된 카테고리 추가 시도시 경고창 발생
  
  
   ![image](https://user-images.githubusercontent.com/100820039/186042830-e7a19ae6-5fa2-4327-ad32-85dd139723ca.png)
   ![image](https://user-images.githubusercontent.com/100820039/186042963-2bc2c64c-7566-4dea-b765-2b55bb90b8f4.png)
  
  
  * 추가한 카테고리에 포함된 메뉴가 생성되어 있는데 카테고리 삭제 시도 시 경고창 발생
  
  
  ![image](https://user-images.githubusercontent.com/100820039/186043492-a4970424-fde8-4fe2-8317-a4e9af6167be.png)
  ![image](https://user-images.githubusercontent.com/100820039/186043529-85d4e1fe-d13d-4fa7-9819-cdd6faffef54.png)
  ![image](https://user-images.githubusercontent.com/100820039/186043534-e60f6a2e-182d-4ab5-b1c6-59a87d273601.png)
  
  
  * 카테고리 추가 할 때 빈값으로 추가 시도시 경고창 발생
  
  ![image](https://user-images.githubusercontent.com/100820039/186044588-21618508-5d38-40e6-bd50-1da1bdc9f64e.png)



# 주문

![image](https://user-images.githubusercontent.com/100820039/187031966-f32c0b96-8be8-47a2-bb54-36a03c171014.png)


* 추가된 카테고리들이 보이도록 구현하였습니다.


![image](https://user-images.githubusercontent.com/100820039/187032295-2c5e1933-098b-4ba8-8f9e-a4c4fa19d56e.png)


* 카테고리 선택시 그 카테고리에 해당하는 메뉴들이 나오게 됩니다.

![image](https://user-images.githubusercontent.com/100820039/187036318-12bd616b-ee45-42e1-a4d8-ba0c0f7fb4ff.png)

* 메뉴 선택시 나오는 화면입니다.

수량을 선택 후 장바구니에 담을 수 있도록 List를 전역변수로 선언하여 구현했습니다. List에 담겨져있는 메뉴들은 결제를 할때 session으로 보내집니다.

![image](https://user-images.githubusercontent.com/100820039/187036348-d6ea94ac-1d42-47ad-95d8-bf4bcd39ba36.png)


장바구니의 선택한 메뉴들이 담겨져있는 모습

![image](https://user-images.githubusercontent.com/100820039/187036385-078dcac4-be12-43b8-9a83-48d5da579010.png)


![image](https://user-images.githubusercontent.com/100820039/187036421-60a1e57f-8309-421c-a023-0934c75c2b92.png)


장바구니 구현 코드

```Java
	// 담기
	@PostMapping("/cart")
	public String cartForm(Model model, HttpSession session,
			@RequestParam("name") String name,@RequestParam("price") int price, @RequestParam("count") int count) {
		FoodsCommand food = new FoodsCommand();
		food.setName(name);
		food.setPrice(price * count);
		food.setCount(count);
		list.add(food);
		session.setAttribute("list", list);
		return "redirect:/main";
	}
```


장바구니에 담은 메뉴를 결제하기를 누르면 주문확인, 총 결제 가격 확인 후에 결제가 가능하게 구현했습니다.

![image](https://user-images.githubusercontent.com/100820039/187039181-f8f369fb-4bf1-4e32-9664-917b10f981c8.png)

![image](https://user-images.githubusercontent.com/100820039/187039192-a9c60bc1-20a9-48ae-b54d-c86667750425.png)


결제 후 처음으로 돌아가거나 장바구니에 메뉴를 담던 도중 처음으로 버튼을 누르면 장바구니 목록이 모두 사라지게 세션삭제를 이용해 구현했습니다.


![image](https://user-images.githubusercontent.com/100820039/187039234-e95d55d9-234b-4e85-a59b-091bc7a07a96.png)





