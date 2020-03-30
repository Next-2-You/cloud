package com.chen.order_service_hystrix_feign.controller;


import com.chen.order_service_hystrix_feign.entity.Product;
import com.chen.order_service_hystrix_feign.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id){
        return productFeignClient.findById(id);
    }


    @RequestMapping(value = "/port",method = RequestMethod.GET)
    public String getPort() {
        return port + "-->" + productFeignClient.getPort();
    }


    @RequestMapping(value = "/timeout")
    public Product testTimeOut(){
        return productFeignClient.testTimeOut();
    }

}
