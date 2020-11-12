package com.insurance.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.insurance.config.RibbonConfiguration;
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RibbonClient(value = "bank-loadbalance", configuration = RibbonConfiguration.class)
public class InsuranceApplication2Application {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceApplication2Application.class, args);
	}

}
