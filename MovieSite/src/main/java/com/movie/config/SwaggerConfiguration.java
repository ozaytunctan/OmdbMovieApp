package com.movie.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration extends WebMvcConfigurationSupport{
//
//	/**
//	 * Swagger dokümantasyonu için hangi api controller metodlarını taranacağını
//	 * configurasyonun yapıldığı metod.
//	 * 
//	 * @return
//	 */
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.movie.controller"))
//				.paths(PathSelectors.ant("/*")).build().apiInfo(apiInfo());
//	}
//
//	/**
//	 * Api dökümanında ui-tarafında yapılacak dökümantasyonda Apiler için genel
//	 * bilgilendirme mesajı vermek için kullanılan metod.
//	 * 
//	 * @return
//	 */
//	private ApiInfo apiInfo() {
//		return new ApiInfo("MOBVEN","Mobven Movie Exercise", "API TOS",
//				"Terms of service",
//				new Contact("Mobven", "http://ozaytunctan.com/", "ozaytunctan@gmail.com"),
//				"License of API", "API license URL", Collections.emptyList());
//	}
//
//	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//}
