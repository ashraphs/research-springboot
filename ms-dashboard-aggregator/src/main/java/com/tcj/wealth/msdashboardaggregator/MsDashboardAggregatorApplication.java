package com.tcj.wealth.msdashboardaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsDashboardAggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDashboardAggregatorApplication.class, args);
	}

}
