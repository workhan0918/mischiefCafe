package com.varxyz.cafe.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.domain.Category;
import com.varxyz.cafe.domain.Foods;
import com.varxyz.cafe.domain.FoodsCommand;

@Repository("menuDao")
public class MenuDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MenuDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 카테고리 추가
	public boolean addCategory(Category category) throws DataIntegrityViolationException {
		String sql = "INSERT INTO Category (cateName) VALUES (?)";
		jdbcTemplate.update(sql, category.getCateName());
		return true;
	}
	
	// 카테고리 전체 조회
	public List<Category> findAllCategory() {
		String sql = "SELECT cateName FROM Category";
		
		List<Category> list = new ArrayList<>();
		list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
		
		return list;
	}

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
	
	// 메뉴 추가
	public boolean addMenu(Foods food) {
		String sql = "INSERT INTO Menu (name, price, category, stock, imgUrl) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, food.getName(), 
								 food.getPrice(),
								 food.getCategory().getCateName(), 
								 food.getStock(), 
								 food.getImgUrl());
		return true;
	}
	
	// 카테고리로 전체 메뉴 조회
	public List<FoodsCommand> findAllMenuByCategory(String category) {
		List<FoodsCommand> foodList = new ArrayList<>();
		String sql = "SELECT name, price, category, stock, imgUrl FROM Menu WHERE category = ?";
		foodList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<FoodsCommand>(FoodsCommand.class), category);
		return foodList;
	}
	
	// 개별 메뉴 삭제
	public boolean deleteMenu(String name, String imgUrl) {
		String sql = "DELETE FROM Menu WHERE name = ?";
		jdbcTemplate.update(sql, name);
		
		File file = new File("C:\\workhan\\mischiefCafe\\src\\main\\webapp\\resources\\img\\" + imgUrl + ".jpg");
		if(!imgUrl.equals("default_img")) {
			file.delete();
		}
		return true;
	}
	
	// 개별 메뉴 수정
	public boolean updateMenu(FoodsCommand foods, FoodsCommand sessionFoodId) {
		String sql = "UPDATE Menu SET name=?, price=?, category=?, stock=?, imgUrl=? "
				+ " WHERE name=?";
		jdbcTemplate.update(sql, foods.getName(), foods.getPrice(), foods.getCategory(), 
				foods.getStock(), foods.getImgUrl(), sessionFoodId.getName());
		
		File file = new File("C:\\workhan\\mischiefCafe\\src\\main\\webapp\\resources\\img\\" + sessionFoodId.getImgUrl() + ".jpg");
		if(!sessionFoodId.getImgUrl().equals("default_img") && foods.getImgUrl() != sessionFoodId.getImgUrl()) {
			file.delete();
		}
		return true;
	}
	
	// 이름으로 메뉴 전체 조회
	public FoodsCommand findImgUrlByName(String name) {
		String sql = "SELECT * FROM Menu WHERE name = ?";
		FoodsCommand food = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<FoodsCommand>(FoodsCommand.class), name);
		return food;
	}

}
