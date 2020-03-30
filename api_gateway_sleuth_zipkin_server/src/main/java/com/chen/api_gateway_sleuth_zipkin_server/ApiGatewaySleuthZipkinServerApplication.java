package com.chen.api_gateway_sleuth_zipkin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewaySleuthZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewaySleuthZipkinServerApplication.class, args);
    }

}
