package com.chen.product_service_apollo.dao;


import com.chen.product_service_apollo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
