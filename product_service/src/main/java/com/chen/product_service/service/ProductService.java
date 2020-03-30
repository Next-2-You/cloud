package com.chen.product_service.service;

import com.chen.product_service.dao.ProductRepository;
import com.chen.product_service.entity.Product;
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
