package com.chen.order_service_sentinel_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//激活Feign
@EnableFeignClients
public class OrderServiceSentinelFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceSentinelFeignApplication.class, args);
    }

}
