package com.example.MerchantMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MerchantMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantMicroserviceApplication.class, args);
	}

}
