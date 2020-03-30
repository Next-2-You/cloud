package com.chen.order_service_sleuth_zipkin.dao;


import com.chen.order_service_sleuth_zipkin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespoistory extends JpaRepository<Product,Long> {
}
