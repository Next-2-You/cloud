package com.chen.order_service_hystrix_feign.feign;


import com.chen.order_service_hystrix_feign.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service",fallback = ProductFeignClientCallBack.class)
//@RequestMapping(value = "/product")
public interface ProductFeignClient {

    @RequestMapping(value = "/product/{id}")
    public Product findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/product/port")
    public String getPort();

    @RequestMapping(value = "/product/timeout")
    public Product testTimeOut();


}
