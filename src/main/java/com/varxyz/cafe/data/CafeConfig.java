package com.varxyz.cafe.data;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.varxyz.cafe.dao.MenuDao;

@Configuration
@ComponentScan(basePackageClasses = {MenuDao.class})
public class CafeConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/cafe?serverTimezone=Asia/Seoul");
		ds.setUsername("cafe");
		ds.setPassword("cafe");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		return ds;
	}
	
}
