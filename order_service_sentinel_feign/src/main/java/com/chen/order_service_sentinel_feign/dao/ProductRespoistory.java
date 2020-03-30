package com.chen.order_service_sentinel_feign.dao;


import com.chen.order_service_sentinel_feign.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespoistory extends JpaRepository<Product,Long> {
}
