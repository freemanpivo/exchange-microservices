package com.conversion.conversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.conversion.conversionservice")
@EnableDiscoveryClient
public class ConversionServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConversionServiceApplication.class, args);
  }

}
