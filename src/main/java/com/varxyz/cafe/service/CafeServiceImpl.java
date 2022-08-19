package com.varxyz.cafe.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.varxyz.cafe.dao.MenuDao;
import com.varxyz.cafe.data.CafeConfig;
import com.varxyz.cafe.domain.Category;
import com.varxyz.cafe.domain.Foods;
import com.varxyz.cafe.domain.FoodsCommand;

public class CafeServiceImpl implements CafeService {

	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(CafeConfig.class);
	
	MenuDao dao = context.getBean("menuDao", MenuDao.class);
	
	@Override
	public boolean addCategory(Category category) throws DataIntegrityViolationException {
		return dao.addCategory(category);
	}

	@Override
	public List<Category> findAllCategory() {
		return dao.findAllCategory();
	}

	@Override
	public boolean deleteCategory(String cateName) {
		return dao.deleteCategory(cateName);
	}

	@Override
	public boolean addMenu(Foods food) {
		return dao.addMenu(food);
	}

	@Override
	public List<FoodsCommand> findAllMenuByCategory(String category) {
		return dao.findAllMenuByCategory(category);
	}

	@Override
	public boolean deleteMenu(String name, String imgUrl) {
		return dao.deleteMenu(name, imgUrl);
	}

	@Override
	public boolean updateMenu(FoodsCommand foods, FoodsCommand sessionFoodId) {
		return dao.updateMenu(foods, sessionFoodId);
	}

	@Override
	public FoodsCommand findImgUrlByName(String name) {
		return dao.findImgUrlByName(name);
	}

}
