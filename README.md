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
  
    * 추가
    * 조회
    * 삭제

  * 메뉴
  
    * 추가 / 추가시 이미지 업로드 기능
    * 조회
    * 수정 / 이미지 수정시 전에 올렸던 이미지 경로에서 삭제
    * 삭제 / 메뉴 다중 삭제 가능
  
 * 주문
 
    * 메뉴 선택시 장바구니에 저장
    * 결제
    
# Views
메인 화면


![image](https://user-images.githubusercontent.com/100820039/186041987-498bfad1-823f-4b98-9050-11fa79807199.png)


관리자 페이지 선택시 관리자 페이지로 이동 후 카테고리 추가, 메뉴추가 선택 가능


![image](https://user-images.githubusercontent.com/100820039/186042020-0be2b5ee-8db4-4337-9a1e-f32c53d29753.png)

* 카테고리 추가

카테고리 추가 페이지 화면


![image](https://user-images.githubusercontent.com/100820039/186042761-3612bd47-f5e8-4c59-a975-163765c612e6.png)

카테고리 추가


![image](https://user-images.githubusercontent.com/100820039/186043023-40da9cad-3464-4993-a334-ac1c6f53c6dd.png)
![image](https://user-images.githubusercontent.com/100820039/186043122-c8f2af5c-a1dd-477d-b963-8fde1f8e6194.png)
![image](https://user-images.githubusercontent.com/100820039/186043169-2b0b3c38-72a9-4df6-867e-5bb4ee6bf21f.png)

카테고리 삭제

![image](https://user-images.githubusercontent.com/100820039/186043268-632b38f5-28a5-4db5-abbe-c37252f705c4.png)
![image](https://user-images.githubusercontent.com/100820039/186043315-879b4f0b-f059-4ed0-9c28-a70f6eed6007.png)
![image](https://user-images.githubusercontent.com/100820039/186043333-c68dd728-8764-4818-807a-846c6e84d62d.png)


* 유효성 검사

  * 중복된 카테고리 추가 시도시 경고창 발생
  
  
   ![image](https://user-images.githubusercontent.com/100820039/186042830-e7a19ae6-5fa2-4327-ad32-85dd139723ca.png)
   ![image](https://user-images.githubusercontent.com/100820039/186042963-2bc2c64c-7566-4dea-b765-2b55bb90b8f4.png)
  
  
  * 추가한 카테고리에 포함된 메뉴가 생성되어 있는데 카테고리 삭제 시도 시 경고창 발생
  
  
  ![image](https://user-images.githubusercontent.com/100820039/186043492-a4970424-fde8-4fe2-8317-a4e9af6167be.png)
  ![image](https://user-images.githubusercontent.com/100820039/186043529-85d4e1fe-d13d-4fa7-9819-cdd6faffef54.png)
  ![image](https://user-images.githubusercontent.com/100820039/186043534-e60f6a2e-182d-4ab5-b1c6-59a87d273601.png)
  
  
  * 카테고리 추가 할 때 빈값으로 추가 시도시 경고창 발생
  
  ![image](https://user-images.githubusercontent.com/100820039/186044588-21618508-5d38-40e6-bd50-1da1bdc9f64e.png)


* 메뉴 추가 페이지 화면


![image](https://user-images.githubusercontent.com/100820039/186043830-4947980c-7655-4381-bfe0-1e1d116bb1bb.png)


 * 메뉴 추가
 
 메뉴 추가시 현재 추가된 카테고리 목록을 select box 로 사용자에게 보여주어 카테고리 선택을 편하게 하도록 구현하였습니다.
 
 ![image](https://user-images.githubusercontent.com/100820039/186044359-6b3b69b8-d181-4365-a430-9d0956c9f116.png)



   

