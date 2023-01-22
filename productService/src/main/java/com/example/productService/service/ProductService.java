package com.example.productService.service;

import com.example.productService.entity_table.ProductTable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public ProductTable insertProductDetails(ProductTable productTable);

    List<ProductTable> findByName(String name);
    List<ProductTable> findByCategory(String name);
    public Optional<ProductTable> findById(String productId);
}
