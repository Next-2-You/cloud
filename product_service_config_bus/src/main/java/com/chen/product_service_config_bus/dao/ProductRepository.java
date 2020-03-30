package com.chen.product_service_config_bus.dao;

import com.chen.product_service_config_bus.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
