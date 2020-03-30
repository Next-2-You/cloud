package com.chen.order_service.controller;

import com.chen.order_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id){
        List<ServiceInstance> list = discoveryClient.getInstances("product_service");
        ServiceInstance instance = list.get(0);
        return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+id,Product.class);
//        return restTemplate.getForObject("http://192.168.1.104:9090/product/"+id,Product.class);
    }


    /**
     * 基于ribbon的形式调用远程微服务
     *  1.使用@LoadBalanced声明RestTemplate
     *  2.使用服务名称替换ip地址
     */
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById2(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://product-service/product/"+id,Product.class);
    }

    @RequestMapping(value = "/port",method = RequestMethod.GET)
    public String getPort() {
        return restTemplate.getForObject("http://product-service/product/port",String.class);
    }

}
