package com.varxyz.cafe.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.varxyz.cafe.domain.Category;
import com.varxyz.cafe.domain.Foods;
import com.varxyz.cafe.domain.FoodsCommand;

public interface CafeService {
	
	// 카테고리 추가
	public boolean addCategory (Category category) throws DataIntegrityViolationException;

	// 카테고리 목록 조회
	public List<Category> findAllCategory();
	
	// 카테고리 삭제
	public boolean deleteCategory(String cateName);
	
	// 카테고리로 전체 메뉴 조회
	public List<FoodsCommand> findAllMenuByCategory(String Category);
	
	// 메뉴 추가
	public boolean addMenu(Foods food);
	
	// 메뉴 개별 삭제
	public boolean deleteMenu(String name,  String imgUrl);
	
	// 메뉴 개별 수정
	public boolean updateMenu(FoodsCommand foods, FoodsCommand sessionFoodId);
	
	// 메뉴 이름으로 이미지 주소 검색
	public FoodsCommand findImgUrlByName(String name);

}
