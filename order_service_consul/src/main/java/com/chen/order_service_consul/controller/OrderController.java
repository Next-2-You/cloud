package com.chen.order_service_consul.controller;



import com.chen.order_service_consul.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;


    /**
     * 基于ribbon的形式调用远程微服务
     *  1.使用@LoadBalanced声明RestTemplate
     *  2.使用服务名称替换ip地址
     */
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById2(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://product-service-consul/product/"+id,Product.class);
    }

    @RequestMapping(value = "/port",method = RequestMethod.GET)
    public String getPort() {
        return restTemplate.getForObject("http://product-service-consul/product/port",String.class);
    }

}
