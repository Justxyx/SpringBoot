package com.xm;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class Day5SpringbootMybatisApplicationTests {
	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() {
		DruidDataSource druidDataSource = (DruidDataSource) dataSource;
		System.out.println(druidDataSource.getMaxActive());
	}

}
