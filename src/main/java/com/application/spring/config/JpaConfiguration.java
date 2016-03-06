package com.application.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"com.application.spring.repository"})
public class JpaConfiguration {

}