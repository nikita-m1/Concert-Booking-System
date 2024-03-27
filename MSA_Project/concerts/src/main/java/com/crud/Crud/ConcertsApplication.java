package com.crud.Crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConcertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcertsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate2() {
		return new RestTemplate();
	}
}