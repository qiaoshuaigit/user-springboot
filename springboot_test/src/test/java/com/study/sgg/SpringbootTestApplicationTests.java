package com.study.sgg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTestApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		try {
			//默认情况下 使用sspringboot 2.x HikariDataSource数据源
			System.out.println(dataSource.getConnection());
			System.out.println(dataSource.getClass());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
