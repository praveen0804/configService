package com.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.configservice")
public class ConfigServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}

}
