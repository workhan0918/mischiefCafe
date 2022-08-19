package com.varxyz.cafe.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.cafe.domain.FoodsCommand;
import com.varxyz.cafe.service.CafeService;
import com.varxyz.cafe.service.CafeServiceImpl;

@Controller
public class MainController {
	CafeService service = new CafeServiceImpl();
	List<FoodsCommand> list = new ArrayList<>();
	@GetMapping("/start")
	public String startGo(HttpSession session) {
		session.removeAttribute("list");
		list.clear();
		return "start/start";
	}
	
	@GetMapping("/main")
	public String mainForm(Model model, HttpSession session) {
		model.addAttribute("categorys", service.findAllCategory());
		model.addAttribute("list", session.getAttribute("list"));
		return "main/main_page";
	}
	
	@GetMapping("/orderMenu")
	public String categorySelectForm(Model model, @RequestParam("cateName") String cateName) {
		model.addAttribute("cateName", cateName);
		model.addAttribute("foodList", service.findAllMenuByCategory(cateName));
		return "order/orderPage";
	}
	
	@GetMapping("/putMenu")
	public String putMenu(Model model, @RequestParam("menuName") String menuName) {
		model.addAttribute("menu", service.findImgUrlByName(menuName));
		return "order/putMenu";
	}
	
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
	
	@GetMapping("/payment")
	public String paymentGo(Model model, HttpSession session) {
		model.addAttribute("list", session.getAttribute("list"));
		int sumPrice = 0;
		for (FoodsCommand foodsCommand : list) {
			sumPrice += foodsCommand.getPrice();
		}
		model.addAttribute("sumPrice", sumPrice);
		return "order/payment";
	}
	
	@GetMapping("/paymentSuccess")
	public String paymentSuccess() {
		return "order/paymentSuccess";
	}
	
}
