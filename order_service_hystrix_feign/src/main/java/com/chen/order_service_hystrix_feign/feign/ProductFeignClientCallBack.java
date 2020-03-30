package com.chen.order_service_hystrix_feign.feign;

import com.chen.order_service_hystrix_feign.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientCallBack implements ProductFeignClient{
    @Override
    public Product findById(Long id) {
        return defaultProduct();
    }

    @Override
    public String getPort() {
        return "降级啦";
    }

    @Override
    public Product testTimeOut() {
        return defaultProduct();
    }


    public Product defaultProduct(){
        Product product = new Product();
        product.setProductName("服务熔断降级");
        return product;
    }

}
