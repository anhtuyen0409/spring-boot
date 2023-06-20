package com.nguyenanhtuyen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * class DemoApplication dùng để start ứng dụng
 * Note: By default Spring Boot will automatically configures JPA, and create Spring Bean related to JPA.
 * These automatic configurations of the Spring Boot include:
 * DataSourceAutoConfiguration
 * DataSourceTransactionManagerAutoConfiguration
 * HibernateJpaAutoConfiguration
 * The purpose of this application is to use Hibernate, therefore, we need to disable the above automatic configurations of Spring Boot.
 * Then, config the Spring Beans required of the Hibernate in HinernateConfig.java
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
