package com.billpayjobs.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BillpayJobsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillpayJobsApiApplication.class, args);
	}

}
