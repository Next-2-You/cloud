package com.chen.product_service_apollo.service;

import com.chen.product_service_apollo.dao.ProductRepository;
import com.chen.product_service_apollo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRespoistory;

    public Product findById(Long id){
       return productRespoistory.getOne(id);
    }

}
