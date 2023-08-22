package com.example.springboot.controllers;

import com.example.springboot.domain.product.ProductService;
import com.example.springboot.domain.product.RequestProductDTO;
import com.example.springboot.domain.product.ProductModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable("productId") String id) {
        return ResponseEntity.ok(productService.findProduct(id));
    }

    @PostMapping
    public ResponseEntity<Void> newProduct(@RequestBody @Valid RequestProductDTO data) {
        productService.newProduct(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProductModel> updateProduct(@RequestBody @Valid RequestProductDTO data) {
        return ResponseEntity.ok(productService.updateProduct(data));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
