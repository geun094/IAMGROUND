package com.iamground.iam.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/*
 * Starter 등록한 것들
 * Spring Boot DevTools
 * JDBC API
 * Spring Data JPA
 * Oracle Driver
 * Thymeleaf
 * Spring Web
 * Spring Security 
 */
@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"com.iamground.iam"})
public class IamGroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamGroundApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}
