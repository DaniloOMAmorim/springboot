package com.example.springboot.domain.product;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final IProductRepository repository;

    public List<ProductModel> findAllProducts() {
        return repository.findAll();
    }

    public ProductModel findProduct(String id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.error("--> Product with id {} not found", id);
                    return new EntityNotFoundException("Product with id " + id + " not available");
                });
    }

    public void newProduct(RequestProductDTO data) {
        ProductModel productModel = new ProductModel(data);
        repository.save(productModel);
    }

    @Transactional
    public ProductModel updateProduct(RequestProductDTO data) {
        ProductModel productModel = repository.findById(data.id())
                .orElseThrow(() -> {
                    log.error("--> Product with id {} not found", data.id());
                    return new EntityNotFoundException("Product with id " + data.id() + " not available");
                });

        productModel.setName(data.name());
        productModel.setPrice(data.price());
        productModel.setCode(data.code());

        return productModel;
    }

    @Transactional
    public void deleteProduct(String id) {
        ProductModel productModel = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("--> Product with id {} not found", id);
                    return new EntityNotFoundException("Product with id " + id + " not available");
                });

        repository.delete(productModel);
    }
}
