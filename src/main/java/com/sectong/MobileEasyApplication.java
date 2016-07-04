package com.sectong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Order(HIGHEST_PRECEDENCE)
@EnableCaching // 开启缓存
@EnableJpaRepositories("com.sectong.repository")
public class MobileEasyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MobileEasyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MobileEasyApplication.class);
	}

}
