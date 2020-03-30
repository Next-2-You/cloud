package com.chen.order_service_sentinel_feign.controller;



import com.chen.order_service_sentinel_feign.entity.Product;
import com.chen.order_service_sentinel_feign.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private ProductFeignClient productFeignClient;


    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) throws Exception {
        return  productFeignClient.findById(id);
    }

}
