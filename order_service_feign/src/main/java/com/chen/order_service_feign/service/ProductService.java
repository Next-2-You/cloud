package com.chen.order_service_feign.service;


import com.chen.order_service_feign.dao.ProductRespoistory;
import com.chen.order_service_feign.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRespoistory productRespoistory;



    public Product findById(Long id){
        return productRespoistory.getOne(id);
    }


}
