package com.chen.order_service_consul.dao;


import com.chen.order_service_consul.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespoistory extends JpaRepository<Product,Long> {
}
