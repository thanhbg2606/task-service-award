package com.example.server_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerTestApplication.class, args);
    }

}
