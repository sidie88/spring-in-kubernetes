package com.eureka.auth.springeurekaauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaAuthApplication.class, args);
	}

}
