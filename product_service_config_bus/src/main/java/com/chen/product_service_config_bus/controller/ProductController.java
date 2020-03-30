package com.chen.product_service_config_bus.controller;

import com.chen.product_service_config_bus.entity.Product;
import com.chen.product_service_config_bus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RefreshScope //开启动态刷新
public class ProductController {




    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/port")
    public String getPort(){
       return port;
    }

    @RequestMapping(value = "/timeout")
    public Product testTimeOut(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Product product = new Product();
        product.setProductName("这是一个睡眠的方法");
        return product;
    }


    @Value("${configInfo}")
    private String configInfo;

    @RequestMapping(value = "/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
