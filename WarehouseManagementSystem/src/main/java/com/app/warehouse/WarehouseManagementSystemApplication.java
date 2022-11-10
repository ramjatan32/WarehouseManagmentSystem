package com.app.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class WarehouseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseManagementSystemApplication.class, args);
		
		System.out.println("Applicatin Running");
		
	}

}
