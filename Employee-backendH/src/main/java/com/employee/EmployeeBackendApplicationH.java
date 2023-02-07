package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.employee.configuration.swaggerconfiguration;
//@Import(swaggerconfiguration.class)
//@EnableWebMvc
@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class EmployeeBackendApplicationH {

	public static void main(String[] args) {    
		
		SpringApplication.run(EmployeeBackendApplicationH.class, args);
	}

}
