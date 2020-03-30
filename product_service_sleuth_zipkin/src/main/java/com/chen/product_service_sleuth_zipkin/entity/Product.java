package com.chen.product_service_sleuth_zipkin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="product")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Product {

    @Id
    private Long id;

    private String productName;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private Integer inventory;
}
