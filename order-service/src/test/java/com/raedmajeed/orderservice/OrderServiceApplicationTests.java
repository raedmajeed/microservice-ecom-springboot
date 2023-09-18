package com.raedmajeed.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class OrderServiceApplicationTests {

//	@Container
//	static MySQLContainer<SELF> mySQLContainer = new MySQLContainer<>(DockerImageName.parse("mysql:latest"));
//
//	@DynamicPropertySource
//	public void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//		return dynamicPropertyRegistry.add("spring.datasource.url", mySQLContainer::);
//	}

	@Test
	void contextLoads() {
	}

}
