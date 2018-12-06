package com.ftn.isa.projekat.rentACar.rentACarCore.config;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/rentacar/.*"), regex("/api/rentacar/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Rent a car microservice API")
				.description("Rent a car microservice API reference for developers")
				.contact("sale96@protonmail.com").license("Alexandross License")
				.licenseUrl("ftnmejl96@gmail.com").version("1.0").build();
	}

}
