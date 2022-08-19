package com.varxyz.cafe.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.domain.Category;
import com.varxyz.cafe.service.CafeService;
import com.varxyz.cafe.service.CafeServiceImpl;

@Controller
public class AddCategoryController {
	CafeService service = new CafeServiceImpl();
	
	@GetMapping("/admin/addCategory")
	public String addCategoryGo(Model model) {
		List<Category> cateList = new ArrayList<>();
		cateList = service.findAllCategory();
		model.addAttribute("cateList", cateList);
		return "admin/addCategory";
	}
	
	@PostMapping("/admin/addCategory")
	public String addCategoryForm(@ModelAttribute("categoryList") Category category,
			HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
		// 입력값 빈값인지 검사
		if (request.getParameter("cateName").trim().isEmpty()) {
			model.addAttribute("msg", "빈값은 입력 할 수 없습니다!");
			return "error/error";
		}
		
		Category cate = new Category();
		
		cate.setCateName(request.getParameter("cateName"));
		
		
		try {
			service.addCategory(cate);
		} catch (DataIntegrityViolationException e) {
			// 이미 생성된 카테고리 생성 시도시
			e.printStackTrace();
			model.addAttribute("msg", "이미 생선된 카테고리 입니다!");
			return "error/error";
		}
		
		model.addAttribute("msg", "카테고리 추가를 완료했습니다");
		model.addAttribute("url", "addCategory");
			
		return "alert/alert_and_page";
	}
}
