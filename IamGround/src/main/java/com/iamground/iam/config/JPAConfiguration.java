package com.iamground.iam.config;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.iamground.iam"})
@EnableJpaRepositories(basePackages = "com.iamground.iam")
public class JPAConfiguration {

}
