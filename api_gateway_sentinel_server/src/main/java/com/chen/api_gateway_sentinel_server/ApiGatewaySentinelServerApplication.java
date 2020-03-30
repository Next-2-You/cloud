package com.chen.api_gateway_sentinel_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewaySentinelServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewaySentinelServerApplication.class, args);
    }

}
