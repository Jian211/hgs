package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private DataSource dataSource;
	
	private Connection conn;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void 커넥션생성테스트() throws SQLException {
		System.out.println("dataSource : " + dataSource);
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("conn : " + conn );
		
		conn.close();
	}

	
	@Test
	public void 세션팩토리확생성() {
		System.out.println("sqlSessionFactory : " + sqlSessionFactory);
		
		
	}
	
}
