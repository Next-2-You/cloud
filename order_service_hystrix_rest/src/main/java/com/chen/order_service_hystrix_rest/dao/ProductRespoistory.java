package com.chen.order_service_hystrix_rest.dao;


import com.chen.order_service_hystrix_rest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespoistory extends JpaRepository<Product,Long> {
}
