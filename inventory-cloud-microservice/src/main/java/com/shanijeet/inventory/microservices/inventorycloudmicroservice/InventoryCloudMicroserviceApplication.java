package com.shanijeet.inventory.microservices.inventorycloudmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class InventoryCloudMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryCloudMicroserviceApplication.class, args);
    }
}
