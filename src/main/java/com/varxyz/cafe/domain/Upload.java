package com.varxyz.cafe.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Upload {
	private String name;
	private MultipartFile file;
}
