package com.multicamp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.multicamp"})
public class SpringNcpAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNcpAiApplication.class, args);
	}

}
