package com.spring.providerone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.spring.providerone.dao")
public class ProviderOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderOneApplication.class, args);
	}

}
