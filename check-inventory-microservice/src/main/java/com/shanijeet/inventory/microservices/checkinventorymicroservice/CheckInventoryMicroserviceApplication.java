package com.shanijeet.inventory.microservices.checkinventorymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.shanijeet.inventory.microservices")
@EnableDiscoveryClient
public class CheckInventoryMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckInventoryMicroserviceApplication.class, args);
    }
}
