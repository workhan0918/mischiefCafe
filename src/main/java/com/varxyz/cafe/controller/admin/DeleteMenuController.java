package com.varxyz.cafe.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.cafe.service.CafeService;
import com.varxyz.cafe.service.CafeServiceImpl;

@Controller
public class DeleteMenuController {
	
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
	}
}
