package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmpRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpRestServiceApplication.class, args);
	}
	
public ApiInfo apiInfo() {
	return new ApiInfoBuilder().description("A Demo REST Api Doc")
			.license("Use Free")
			.title("EMP Service REST DOC")
			.build();
}

@Bean
public Docket docket() {
	return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.demo.spring"))
			.paths(PathSelectors.any()).build().apiInfo(apiInfo());
}
}
