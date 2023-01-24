package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.employee.configuration.swaggerconfiguration;
//@Import(swaggerconfiguration.class)
//@EnableWebMvc
@SpringBootApplication
public class EmployeeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBackendApplication.class, args);
	}

}
