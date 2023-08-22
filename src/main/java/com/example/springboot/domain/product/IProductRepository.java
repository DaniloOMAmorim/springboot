package com.example.springboot.domain.product;

import com.example.springboot.domain.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductModel, String> {
}
