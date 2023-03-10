//package com.employee.configuration;
//
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//@Configuration
//@EnableSwagger2
//public class swaggerconfiguration {
//	 @Bean
//	    public Docket Employeeswagger() {
//	  
//			return new Docket(DocumentationType.SWAGGER_2)
//	                .select()
//	              //  .apis(RequestHandlerSelectors.any());	    
//	               .paths(PathSelectors.ant("/employeeApi**"))
//	             //.paths( PathSelectors.any())
//	                .build()	            
//	                .apiInfo(apiDetails());
//	    }
//	
//	private ApiInfo apiDetails() {
//		return new ApiInfo("Employee Management System",
//				"Api to Access details of Employees",
//				"1.0",
//				"free to use",
//				new springfox.documentation.service.Contact("Hariharan ", "hariharangounder1@gmail.com","hariharangounder1gmail.com"),
//				"Api License",
//				"https://github.com/Hariharan8Rpc?tab=repositories",
//				Collections.emptyList());
//	}
//
//}
