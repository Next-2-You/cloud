package com.chen.api_zuul_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy //开启zuul网关
public class ApiZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiZuulServerApplication.class, args);
    }

}
