package com.chen.order_service_sleuth_zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//激活Feign
@EnableFeignClients
public class OrderServiceSleuthZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceSleuthZipkinApplication.class, args);
    }

}
