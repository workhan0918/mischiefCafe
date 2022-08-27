package com.varxyz.cafe.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.cafe.domain.FoodsCommand;
import com.varxyz.cafe.service.CafeService;
import com.varxyz.cafe.service.CafeServiceImpl;

@Controller
public class UpdateMenuController {
	
	CafeService service = new CafeServiceImpl();
	
	@GetMapping("admin/updateMenu")
	public String updateMenuGo(FoodsCommand foods, Model model, HttpSession session) {
		session.setAttribute("sessionFood", foods);
		model.addAttribute("foods", foods);
		model.addAttribute("cateList", service.findAllCategory());
		return "admin/update_menu_page";
	}
	
	@PostMapping("admin/updateMenu")
	public String updateMenu(HttpServletRequest request, Model model, HttpSession session,
			@RequestParam("file") MultipartFile file) {
		
		System.out.println(request.getParameter("category"));
		
		if(request.getParameter("category") == null) {
			model.addAttribute("msg", "카테고리가 선택되지 않았습니다!");
			return "error/error";
		}
		FoodsCommand foods = new FoodsCommand();
		foods.setName(request.getParameter("name"));
		foods.setPrice(Integer.parseInt(request.getParameter("price")));
		foods.setStock(Integer.parseInt(request.getParameter("stock")));
		foods.setCategory(request.getParameter("category"));
		
		

		
		String fileRealName = file.getOriginalFilename(); // 실제 파일 명을 알수있는 메소드
		long size = file.getSize(); // 파일 사이즈

		System.out.println("파일명 : " + fileRealName);
		System.out.println("용량 크기(byte) : " + size);
		//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
		
		// 사용자가 이미지를 업로드 하지 않았을 경우 예외 처리
		if (fileRealName == null || fileRealName.length() == 0) {
			foods.setImgUrl(((FoodsCommand)session.getAttribute("sessionFood")).getImgUrl());
			
			service.updateMenu(foods, (FoodsCommand)session.getAttribute("sessionFood"));
			
			session.removeAttribute("foodId");
			
			model.addAttribute("msg","수정을 완료했습니다!");
			model.addAttribute("url","addMenu");
			return "alert/alert_and_page";
		}
		
		
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uploadFolder = "C:\\Hbackend\\eclipse-workspace\\mischiefCafe\\src\\main\\webapp\\resources\\img";
		
//		집 폴더 경로
//		String uploadFolder = "C:\\Users\\hanta\\Desktop\\mycoding\\StudyJava\\cafe\\src\\main\\webapp\\resources\\img";
		
		/*
		  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
		  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있다. 
		  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
		  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
		 */
		
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유 문자열 : " + uniqueName );
		System.out.println("확장자명 : " + fileExtension);
		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
		
		File saveFile = new File(uploadFolder + "\\" + uniqueName + fileExtension); // 적용 후
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메소드(filewriter 작업을 손쉽게 한방에 처리해준다.
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		foods.setImgUrl(uniqueName);
		
		service.updateMenu(foods, (FoodsCommand)session.getAttribute("sessionFood"));
		
		session.removeAttribute("foodId");
		model.addAttribute("msg","수정을 완료했습니다!");
		model.addAttribute("url","addMenu");
		return "alert/alert_and_page";
	}
	
}
