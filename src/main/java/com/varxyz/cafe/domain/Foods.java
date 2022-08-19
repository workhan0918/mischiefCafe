package com.varxyz.cafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Foods {
	private String name;
	private int price;
	private Category category;
	private int stock;
	private String imgUrl;
}


