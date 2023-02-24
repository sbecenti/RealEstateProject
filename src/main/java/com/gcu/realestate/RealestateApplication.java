package com.gcu.realestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.gcu"})
@SpringBootApplication
public class RealestateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealestateApplication.class, args);
	}

}
