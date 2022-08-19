package com.varxyz.cafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodsCommand {
	private String name;
	private int price;
	private String category;
	private int stock;
	private String imgUrl;
	private int count;
}


