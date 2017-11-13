package com.falcon.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableRedisRepositories
public class Application {

	private static final String GROUP_NAME = "falcon.io-coding-exercise";
	private static final String SWAGGER_BASE_PACKAGE = "com.falcon.io.controller";
	private static final String PROJECT_VERSION = "1.0";
	private static final String PROJECT_TITLE = "falcon.io coding exercise";
	private static final String PROJECT_DESCRIPTION = "This falcon.io coding exercise has been written by Marcos Zalacain";
	private static final String DOCKER_HOST_IP = "192.168.99.100";	// Make this configurable.
	private static final int REDIS_PORT = 6379;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Swagger
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(GROUP_NAME).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_BASE_PACKAGE)).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(PROJECT_TITLE).description(PROJECT_DESCRIPTION).version(PROJECT_VERSION)
				.build();
	}
	
	// Redis 
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
	    jedisConFactory.setHostName(DOCKER_HOST_IP);
	    jedisConFactory.setPort(REDIS_PORT);
	    jedisConFactory.setUsePool(true);
	    return jedisConFactory;
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
}