package com.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.api"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	@SuppressWarnings("unchecked")
	private ApiInfo apiInfo() {
		return new ApiInfo("Colmena", "Api envia email", "1.0", null, null, null, null, Collections.EMPTY_LIST);
	}

}
