package com.chen.product_service_sleuth_zipkin.dao;


import com.chen.product_service_sleuth_zipkin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
