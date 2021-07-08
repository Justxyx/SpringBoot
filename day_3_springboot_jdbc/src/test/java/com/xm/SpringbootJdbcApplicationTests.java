package com.xm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootJdbcApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() throws SQLException {
//		看一下默认数据源
		System.out.println(dataSource.getClass() );    // class com.zaxxer.hikari.HikariDataSource 数据源
		//获得连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		//关闭连接
		connection.close();
//		String sql = "select * from books";
//		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//		System.out.println(maps);

	}

}
