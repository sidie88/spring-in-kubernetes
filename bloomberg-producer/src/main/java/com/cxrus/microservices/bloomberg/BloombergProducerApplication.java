package com.cxrus.microservices.bloomberg;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan
@EnableScheduling
@EnableFeignClients("com.cxrus.microservices.bloomberg")
public class BloombergProducerApplication {


	
	public static void main(String[] args) {
		new SpringApplicationBuilder(BloombergProducerApplication.class).bannerMode(Mode.OFF).run(args);
	}
	
}