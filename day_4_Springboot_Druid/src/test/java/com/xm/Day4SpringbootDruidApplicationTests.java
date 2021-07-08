package com.xm;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Day4SpringbootDruidApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {

		 //使用druid源查询数据库,其实在这里看不太出来区别.
		System.out.println(dataSource.getClass());   // class com.alibaba.druid.pool.DruidDataSource 换源为阿里巴巴A
		String sql = "select * from books";
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
		System.out.println(maps);



//		使用加载配置后的druid,这里就可以看出区别了

		DruidDataSource druidDataSource = (DruidDataSource) dataSource;
		System.out.println(druidDataSource.getMaxActive() + "数据库的最大连接数,跟自己的配置有关");

	}

}
