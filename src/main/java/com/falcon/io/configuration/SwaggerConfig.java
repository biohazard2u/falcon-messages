package com.falcon.io.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String GROUP_NAME = "falcon.io-coding-exercise";
	private static final String SWAGGER_BASE_PACKAGE = "com.falcon.io.controller";
	private static final String PROJECT_VERSION = "1.0";
	private static final String PROJECT_TITLE = "falcon.io coding exercise";
	private static final String PROJECT_DESCRIPTION = "This falcon.io coding exercise has been written by Marcos Zalacain";
	
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(GROUP_NAME).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_BASE_PACKAGE)).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(PROJECT_TITLE).description(PROJECT_DESCRIPTION).version(PROJECT_VERSION)
				.build();
	}
}