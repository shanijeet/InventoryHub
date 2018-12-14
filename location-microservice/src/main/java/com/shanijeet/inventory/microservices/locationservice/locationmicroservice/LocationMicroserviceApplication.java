package com.shanijeet.inventory.microservices.locationservice.locationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.shanijeet.inventory.microservices.locationservice.locationmicroservice")
public class LocationMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationMicroserviceApplication.class, args);
    }
}
