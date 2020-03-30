package com.chen.order_service_sleuth_zipkin.feign;

import com.chen.order_service_sleuth_zipkin.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service-sleuth-zipkin")
@RequestMapping(value = "/product")
public interface ProductFeignClient {

    @RequestMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/port")
    public String getPort();


}
