package com.chen.order_service_feign.dao;


import com.chen.order_service_feign.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespoistory extends JpaRepository<Product,Long> {
}
