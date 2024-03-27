package com.demo.sqlTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate3() {
		return new RestTemplate();
	}

}
