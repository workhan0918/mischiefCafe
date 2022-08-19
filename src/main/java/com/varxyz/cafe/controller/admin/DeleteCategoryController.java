package com.varxyz.cafe.controller.admin;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.cafe.service.CafeService;
import com.varxyz.cafe.service.CafeServiceImpl;
import com.varxyz.cafe.service.Alert;

@Controller
public class DeleteCategoryController {
	

	
	@GetMapping("/admin/deleteCategory")
	public String deleteCategory(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String cateName = request.getParameter("cateName");

		CafeService service = new CafeServiceImpl();
		
		service.deleteCategory(cateName);
		
		Alert.alertAndMovePage(response, "카테고리를 삭제 했습니다.", "addCategory");
		
		return "redirect:/addCategory";
	}
	
}
